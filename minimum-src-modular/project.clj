(defproject hey "0.0.1"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [ring/ring-core "1.6.3"]
                 [ring/ring-jetty-adapter "1.6.3"]]
  :plugins [lein-jlink "0.2.0-SNAPSHOT"]
  :jlink-modules ["java.base", "java.logging"]
  :main hey.core)
