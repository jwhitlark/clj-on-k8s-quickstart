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

This image weighs in at **TODO**

## Minimal Image

The minimal image is **TODO**, space savings of **TODO**

https://docs.docker.com/develop/develop-images/multistage-build/#name-your-build-stages
https://sunng.info/blog/custom-jre-for-clojure-app-distribution.html
http://dev.solita.fi/2018/01/24/Java9-modules-Spring-Boot-2-Docker.html
https://github.com/juxt/pack.alpha/blob/master/src/mach/pack/alpha/capsule.clj


## Create and push the image

``` shell
# build & tag

# Push it
```

### References

https://cloud.google.com/container-registry/docs/pushing-and-pulling?hl=en_US&_ga=2.167371894.-910061897.1517597687
https://cloud.google.com/container-registry/docs/



Next: [Start, expose, and test the service](06-start-expose-test.md)


If you need to take down your cluster, see [Cleanup](99-cleanup.md)
