# Create the Docker Image

## Normally

``` dockerfile
FROM clojure:lein-alpine

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY project.clj /usr/src/app/
RUN lein deps
COPY . /usr/src/app
# FIXME: clean this up, since we know the jar.
RUN mv "$(lein uberjar | sed -n 's/^Created \(.*standalone\.jar\)/\1/p')" app-standalone.jar
CMD ["java", "-jar", "app-standalone.jar"]
```

## Minimal Image


## Create and push the image

``` shell
# build & tag

# Push it
```

Next: [Start, expose, and test the service](06-start-expose-test.md)
