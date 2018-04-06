# Create the Docker Image

**TODO: put project name in shell var, for ease of use.**

## Normally

``` dockerfile
FROM clojure:lein-alpine

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY project.clj /usr/src/app/
RUN lein deps
COPY . /usr/src/app
RUN lein uberjar
CMD ["java", "-jar", "target/hey-0.0.1--standalone.jar"]
```

``` console
$ docker image build -t clj-on-k8s/hey:0.0.1 .
```

This image weighs in at 157MB

## Run the image locally

``` console
$ docker run -p 3000:3000 clj-on-k8s/hey:0.0.1
```

## Minimal Image

The minimal image is **TODO**, space savings of **TODO**

https://docs.docker.com/develop/develop-images/multistage-build/#name-your-build-stages
https://sunng.info/blog/custom-jre-for-clojure-app-distribution.html
http://dev.solita.fi/2018/01/24/Java9-modules-Spring-Boot-2-Docker.html
https://github.com/juxt/pack.alpha/blob/master/src/mach/pack/alpha/capsule.clj


## Push the image

``` shell
# Verify your project name
$ gcloud projects list

PROJECT_ID     NAME           PROJECT_NUMBER
core-XXXXXX    Core           XXXXXXXXXXXX

# Tag it
$ docker tag clj-on-k8s/hey:0.0.1 gcr.io/core-XXXXXX/hey:0.0.1

# Setup authentication
$ gcloud auth configure-docker

The following settings will be added to your Docker config file
located at [/Users/username/.docker/config.json]:
 {
  "credHelpers": {
    "gcr.io": "gcloud",
    "us.gcr.io": "gcloud",
    "eu.gcr.io": "gcloud",
    "asia.gcr.io": "gcloud",
    "staging-k8s.gcr.io": "gcloud"
  }
}

Do you want to continue (Y/n)?

# Push it
$ docker push gcr.io/core-XXXXXX/hey 

The push refers to repository [gcr.io/core-XXXXXX/hey]
2d5e8a0334d7: Pushed
c151f2c209d3: Pushed
11a076f3110b: Pushed
bf9532724541: Pushed
2846050d776f: Pushed
6b456871a5e0: Layer already exists
f40b01b94275: Layer already exists
404de543c863: Layer already exists
685fdd7e6770: Layer already exists
c9b26f41504c: Layer already exists
cd7100a72410: Layer already exists
0.0.1: digest: sha256:33c9487d64b716cb7dba45862f0250ed0e6fd91e8747e3a789615318a7518d17 size: 2628

# Verify
$ gcloud container images list-tags gcr.io/core-XXXXXX/hey 

DIGEST        TAGS   TIMESTAMP
33c9487d64b7  0.0.1  2018-04-06T15:57:06

```

### References

https://cloud.google.com/container-registry/docs/pushing-and-pulling?hl=en_US&_ga=2.167371894.-910061897.1517597687
https://cloud.google.com/container-registry/docs/



Next: [Start, expose, and test the service](06-start-expose-test.md)


If you need to take down your cluster, see [Cleanup](99-cleanup.md)
