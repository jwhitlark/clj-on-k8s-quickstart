# Building a minimal image

**Experimental!**

The minimal image is 100MB, compared to the regular image of 157MB. 

## Update project.clj
Add the following to the project.clj

``` clojure
:plugins [lein-jlink "0.2.0-SNAPSHOT"]
:jlink-modules ["java.base", "java.logging"]
```

## Replace the Dockerfile

There isn't a Java 10 Clojure build, so we'll need to install Leiningen manually.

``` dockerfile
FROM openjdk:10-jdk as build

ENV LEIN_VERSION=2.8.1
ENV LEIN_INSTALL=/usr/local/bin/

WORKDIR /tmp

# Download the whole repo as an archive
RUN mkdir -p $LEIN_INSTALL \
  && wget -q https://raw.githubusercontent.com/technomancy/leiningen/$LEIN_VERSION/bin/lein-pkg \
  && echo "Comparing lein-pkg checksum ..." \
  && echo "019faa5f91a463bf9742c3634ee32fb3db8c47f0 *lein-pkg" | sha1sum -c - \
  && mv lein-pkg $LEIN_INSTALL/lein \
  && chmod 0755 $LEIN_INSTALL/lein \
  && wget -q https://github.com/technomancy/leiningen/releases/download/$LEIN_VERSION/leiningen-$LEIN_VERSION-standalone.zip \
  && wget -q https://github.com/technomancy/leiningen/releases/download/$LEIN_VERSION/leiningen-$LEIN_VERSION-standalone.zip.asc \
  && gpg --keyserver pool.sks-keyservers.net --recv-key 2B72BF956E23DE5E830D50F6002AF007D1A7CC18 \
  && echo "Verifying Jar file signature ..." \
  && gpg --verify leiningen-$LEIN_VERSION-standalone.zip.asc \
  && rm leiningen-$LEIN_VERSION-standalone.zip.asc \
  && mkdir -p /usr/share/java \
  && mv leiningen-$LEIN_VERSION-standalone.zip /usr/share/java/leiningen-$LEIN_VERSION-standalone.jar

ENV PATH=$PATH:$LEIN_INSTALL
ENV LEIN_ROOT 1

# Install clojure 1.9.0 so users don't have to download it every time
RUN echo '(defproject dummy "" :dependencies [[org.clojure/clojure "1.9.0"]])' > project.clj \
  && lein deps && rm project.clj

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . /usr/src/app

RUN lein jlink init
RUN lein jlink assemble
RUN lein jlink package

#NOTE: If you run jlink on ubuntu, you can't use the same jre on alpine, they have incompatible libc libraries!

FROM debian:sid-slim
COPY --from=build /usr/src/app/target/jlink /opt/hey
ENTRYPOINT /opt/hey/bin/hey
```

## Debugging/Checking the module requirements

You can add the following after the *jlink init* line, and it will list the module requirements.  This doesn't mean they are all needed.
``` dockerfile
RUN lein jlink init
RUN lein uberjar
RUN jdeps -s target/hey-0.0.1-standalone.jar
```

The above outputs something like:

``` console
hey-0.0.1-standalone.jar -> java.base
hey-0.0.1-standalone.jar -> java.desktop
hey-0.0.1-standalone.jar -> java.logging
hey-0.0.1-standalone.jar -> java.naming
hey-0.0.1-standalone.jar -> java.sql
hey-0.0.1-standalone.jar -> java.xml
hey-0.0.1-standalone.jar -> jdk.unsupported
hey-0.0.1-standalone.jar -> not found
```

Now you can return to [Build it](05-create-image.md)

## References
https://github.com/sunng87/lein-jlink
