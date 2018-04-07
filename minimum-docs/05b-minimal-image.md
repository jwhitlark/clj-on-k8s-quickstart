# Building a minimal image

The minimal image is **TODO**, space savings of **TODO**

From https://github.com/sunng87/lein-jlink

Add the following to the project.clj

:plugins [lein-jlink "0.2.0-SNAPSHOT"]

:jlink-modules ["java.base"]

lein jlink run  # make sure it works

## Not sure if I need the next bit. (in project.clj)
:profiles {
  :jlink {:java-cmd "./target/jlink/bin/java"}
}

## Assemble it
lein jlink assemble

## Make the docker file
FROM sunng/alpine-jlink-base

ADD target/default/jlink /opt/jlinktest
ENTRYPOINT /opt/jlinktest/bin/jlinktest

## Anything else needed?


https://docs.docker.com/develop/develop-images/multistage-build/#name-your-build-stages
https://sunng.info/blog/custom-jre-for-clojure-app-distribution.html
http://dev.solita.fi/2018/01/24/Java9-modules-Spring-Boot-2-Docker.html
https://github.com/juxt/pack.alpha/blob/master/src/mach/pack/alpha/capsule.clj

