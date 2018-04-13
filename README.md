# clj-on-k8s-quickstart

**Note:** I've been meaning to add exposition to this, but haven't had the
time lately.  Rather than let it languish on my hard drive, I'm
pushing it out in its current form.  Everything should work, start to
finish, I just don't explain all that I'd like.  That said, it does
show one path through all the issues I found in putting it together.

## Goals and Rational

It's an exciting time.

Clojure has always been a clean and powerful language with nice interop with the JVM

Clojure.spec has added exciting capabilities that are very relevant to microservices.

With JDK9, the JVM has become modular, allowing us to greatly shrink the size of our images.

With JDK10, the JVM has become a much better docker citizen.

With Kubernetes, we now have a great platform to build microservices on.

Istio on K8s gives us new ways to easily visualize, monitor and trace our traffic flows between services. It also simplifies many security tasks, and gives us new abilities to control traffic.

## Paths through this.

1. The [Minimum](minimum-docs/01-prerequisites.md) to see a clj response publicly.


## Future additions

1. Show two microservice interacting.
2. Luminus example, adding a database, etc.
3. More config maps examples
4. Secrets
5. Volume mounts
6. Health & Liveliness checks
7. [Istio](https://istio.io/about/intro.html) example, rewriting [bookinfo](https://github.com/istio/istio/blob/master/samples/bookinfo/src/details/details.rb), showing metrics and tracing.
     
## Thanks!

* To Yogthos, for his advice and all the work his put into the Clojure community.
* To Sunng for his work on [lein-jlink](https://github.com/sunng87/lein-jlink).
