# clj-on-k8s-quickstart

## Install clj

## Install gcloud and kubectl

https://cloud.google.com/kubernetes-engine/docs/quickstart

## Install Docker

## Ensure all setup and configured

## Create a K8s cluster

## Write the basic code

## Test locally

## Test locally as docker

## Run on K8s
https://cloud.google.com/container-registry/docs/pushing-and-pulling?hl=en_US&_ga=2.167371894.-910061897.1517597687
https://cloud.google.com/container-registry/docs/

## Expose it

## Update it


## References

https://docs.docker.com/develop/develop-images/multistage-build/#name-your-build-stages

Custom JRE

https://sunng.info/blog/custom-jre-for-clojure-app-distribution.html
&
http://dev.solita.fi/2018/01/24/Java9-modules-Spring-Boot-2-Docker.html

https://github.com/juxt/pack.alpha/blob/master/src/mach/pack/alpha/capsule.clj



Sample Dockerfile

FROM golang:1.7.3 as builder
WORKDIR /go/src/github.com/alexellis/href-counter/
RUN go get -d -v golang.org/x/net/html  
COPY app.go    .
RUN CGO_ENABLED=0 GOOS=linux go build -a -installsuffix cgo -o app .

FROM alpine:latest  
RUN apk --no-cache add ca-certificates
WORKDIR /root/
COPY --from=builder /go/src/github.com/alexellis/href-counter/app .
CMD ["./app"]  
