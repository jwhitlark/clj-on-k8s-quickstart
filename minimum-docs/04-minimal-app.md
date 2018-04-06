# A minimal Clojure webapp

## Structure

``` shell
mkdir -p hey-clj/src/hey
```

## project.clj

``` clojure
(defproject hey "0.0.1"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-jetty-adapter "1.6.3"]]
  :main hey.core)
```

## hey.core

``` clojure
(ns hey.core
  (:gen-class)
  (:require [ring.adapter.jetty :as jetty]))

(defn handler [my-name request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (format "Hello %s from Clojure, Docker, and Kubernetes." my-name)})

(defn -main [& args]
  (let [my-name (or (System/getenv "MY_NAME") 
                     "World")]
    (jetty/run-jetty (partial handler my-name) {:port 3000})))
```

## Run it locally, without an environment variable

``` console
$ lein run
```

## Run it locally, with an environment variable
``` console
$ MY_NAME=Monty lein run
```

Next: [Create the Docker Image](05-create-image.md)


If you need to take down your cluster, see [Cleanup](99-cleanup.md)
