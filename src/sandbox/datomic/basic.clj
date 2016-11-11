(ns sandbox.datomic.basic
  (:require [datomic.api :as d]))


(import datomic.Peer)

;; Create the in memory database, calling the static class method Peer#createDatabase
(def uri "datomic:mem://hello")
(Peer/createDatabase uri)

;; Create a "connection" to the database
(def conn (Peer/connect uri))


;; Create a datom to describe the first bits of data we're entering into the DB:
(def datom ["db/add" (Peer/tempid "db.part/user") "db/doc" "hello world"])

;; Pass the datom to the transactor via the connection (note the 'vector of vectors' for the datom):
(def resp (.transact conn [datom]))