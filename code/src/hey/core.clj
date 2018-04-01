(ns hey.core
  (:gen-class)
  (:require
   [ring.adapter.jetty :as jetty]
   ))

(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello World from Clojure, Docker, and Kubernetes"})

(defn -main [& args]
  (println "foo")
  (jetty/run-jetty handler {:port 3000})
  )

;; http://kubernetes.io/docs/user-guide/kubectl-conventions/#generators

;; docker build -t example/simple-clj:0.0.1 .
;; docker tag example/simple-clj gcr.io/core-194108/simple-clj:0.0.1
;; gcloud docker -- push gcr.io/core-194108/simple-clj:0.0.1
;; gcloud container images list-tags gcr.io/core-194108/simple-clj
;; kubectl run simple-clj --image=gcr.io/core-194108/simple-clj:0.0.1 --port=3000
;; kubectl port-forward simple-clj-6659c7d6f8-x9tzj 3000:3000

;; how to get a shell into the machine
;; how to get a repl into the machine
;; how to get a repl into the process
;; how to get a nrepl into the process
;; how to check around for DNS stuff
;; how to expose it
;; how to add a db
;; how to add configuration/secrets
;; how to add a stable log space
;; how to configure logging for aggregations
;; how to add cljs
;; how to websocket
;; how to microservice (secure? transit/edn/json, tracing)
;; how to add monitoring
;; how to add ssl

;; cleanup (local images, clean up cluster)

;; do it the hard way, manually compiling and building the code?
;; display all important info, git build, docker image, hostname, ip, etc.?

;; This works for deployment to gcp k8s
;; kubectl run simple-clj --image=gcr.io/core-194108/simple-clj:0.0.1 --port=3000
;; kubectl expose deployment simple-clj --type "LoadBalancer"


;; https://cloud.google.com/container-registry/docs/pushing-and-pulling?hl=en_US&_ga=2.167371894.-910061897.1517597687
;; https://console.cloud.google.com/gcr/images/core-194108/GLOBAL/simple-clj?project=core-194108&organizationId=390556102629&gcrImageListsize=50
;; Google container registry supports github build triggers.
;; https://oli.me.uk/2018-02-26-clojure-projects-from-scratch/
;; https://github.com/kirang89/cljboot/blob/master/Makefile
;; https://cloud.google.com/kubernetes-engine/docs/quickstart

;; https://medium.com/jeroen-rosenberg/from-monolith-to-microservice-architecture-on-kubernetes-part-1-the-api-gateway-eb82f8c2d10c
;; Talks about service accounts and passing in tokens, to get/update DNS records?

;; https://www.youtube.com/watch?v=hG5k61vXgfo&feature=youtu.be  Service mesh
