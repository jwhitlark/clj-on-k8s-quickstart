# Create the Docker Image

## Create the Dockerfile

``` dockerfile
FROM clojure:lein-alpine

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN lein uberjar
CMD ["java", "-jar", "target/hey-0.0.1-standalone.jar"]
```

## Build it

``` console
$ docker image build -t clj-on-k8s/hey:0.0.1 .
```

This image weighs in at 157MB.  See [Minimal Image](05b-minimal-image.md) for how to lower the size of the deployed image using Java 10 and jlink.

## Run the image locally

``` console
$ docker run -p 3000:3000 clj-on-k8s/hey:0.0.1
```

## Pushing the image

### Verify your project name
``` console
$ gcloud projects list

PROJECT_ID     NAME           PROJECT_NUMBER
core-XXXXXX    Core           XXXXXXXXXXXX

```
### Tag it so that it can be pushed to GCP
``` console
$ docker tag clj-on-k8s/hey:0.0.1 gcr.io/core-XXXXXX/hey:0.0.1
```

### Setup authentication
``` console
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

```
### Perform the push
``` console
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

```
### Verify the image has been pushed
``` console
$ gcloud container images list-tags gcr.io/core-XXXXXX/hey 

DIGEST        TAGS   TIMESTAMP
33c9487d64b7  0.0.1  2018-04-06T15:57:06
```


Next: [Start, expose, and test the service](06-start-expose-test.md)


If you need to take down your cluster, see [Cleanup](99-cleanup.md)
