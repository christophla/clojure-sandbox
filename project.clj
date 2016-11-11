(defproject sandbox "0.1.0-SNAPSHOT"
  :description "Clojure Sandbox"
  :url "https://github.com/christophla/clojure-sandbox"
  :license {:name "MIT"
            :url  "https://opensource.org/licenses/MIT"}
  :plugins [[environ/environ.lein "0.2.1"]]
  :hooks [environ.leiningen.hooks]
  :profiles {:production {:env {:production false}}}
  :dependencies [[com.datomic/datomic-free "0.9.5390"]
                 [environ "1.1.0"]
                 [org.clojure/clojure "1.8.0"]
                 [prismatic/schema "1.1.3"]])
