# clj-on-k8s-quickstart

## Goals and Rational

It's an exciting time.  

Clojure has always been a clean and powerful language with nice interop with the JVM

Clojure.spec has added exciting capabilities that are very relevant to microservices.

With JDK9, the JVM has become modular, allowing us to greatly shrink the size of our images.

With JDK10, the JVM has become a much better docker citizen.

With Kubernetes, we now have a great platform to build microservices on.

Istio on K8s gives us new ways to easily visualize, monitor and trace our traffic flows between services. It also simplifies many security tasks, and gives us new abilities to control traffic.

## Paths through this.

1. [Absolute Minimum](minimum-docs/01-prerequisites.md), to see a clj response publicly

## Future additions

2. microservices?
3. Luminus?
4. istio?
5. Perhaps rewrite bookinfo?
     https://github.com/istio/istio/blob/master/samples/bookinfo/src/details/details.rb
     Also see istio-0.6.0/samples/bookinfo/kube/*
