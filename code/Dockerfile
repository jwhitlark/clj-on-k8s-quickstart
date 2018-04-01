# FROM ubuntu:17.10

#FROM openjdk:8-jdk-alpine  #123M

#RUN apk --no-cache add curl

# RUN apt-get -y update
# RUN apt-get -y install curl
# RUN apt-get -y install openjdk-8-jdk-headless

#RUN mkdir -p /usr/local/share/man/man1

# ADD linux-install-1.9.0.348.sh linux-install-1.9.0.348.sh
# RUN chmod +x ./linux-install-1.9.0.348.sh
# RUN /bin/sh ./linux-install-1.9.0.348.sh

#FROM clojure:boot-alpine
FROM clojure:lein-alpine

# ADD deps.edn deps.edn
# ADD src src

# FROM clojure
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY project.clj /usr/src/app/
RUN lein deps
COPY . /usr/src/app
RUN mv "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app-standalone.jar
CMD ["java", "-jar", "app-standalone.jar"]


#CMD ["/usr/local/bin/clojure",  "-m", "hey.core"]


# FROM clojure
# RUN mkdir -p /usr/src/app
# WORKDIR /usr/src/app
# COPY project.clj /usr/src/app/
# RUN lein deps
# COPY . /usr/src/app
# RUN mv "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app-standalone.jar
# CMD ["java", "-jar", "app-standalone.jar"]

