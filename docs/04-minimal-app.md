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
                 [ring/ring-jetty-adapter "1.6.3"]
                 ]
  :main hey.core)
```

## hey.core

``` clojure
(ns hey.core
  (:gen-class)
  (:require
   [ring.adapter.jetty :as jetty]
   ))

;; TODO: move from top level
(or (System/getenv "DATABASE_URL") 
    "http://localhost/mydb")

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello World from Clojure, Docker, and Kubernetes"})

(defn -main [& args]
  (println "foo")
  (jetty/run-jetty handler {:port 3000}))
```

## Run it

Next: [Create the Docker Image](05-create-image.md)
