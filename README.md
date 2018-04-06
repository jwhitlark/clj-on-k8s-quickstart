# clj-on-k8s-quickstart

## Goals and Rational

Paths through this.

1. Absolute Minimum setup, to see a clj response publicly
2. two services talking
3. Luminus
4. istio

* What about helm?

[Start here](minimum-docs/01-prerequisites.md)



**TODO: Anything I need out of below?** 

``` dockerfile
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
```


