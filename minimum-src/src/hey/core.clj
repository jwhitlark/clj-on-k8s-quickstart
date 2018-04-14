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
