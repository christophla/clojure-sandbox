(ns sandbox.multimethods)


(def basic-type {:one :two})

; -----------------------------------------------------------------------------
; basic multimethod


(defmulti do-basic basic-type)

(defmethod do-basic :one
  []
  (println ["one"]))

(defmethod do-basic :two
  []
  (println ["two"]))


; -----------------------------------------------------------------------------
; calulated multimethod

(def calculated-type
  (fn [typename]
    (cond
      (= typename "one") :one
      (= typename "two") :two)))

(defmulti do-calculated calculated-type)

(defmethod do-calculated :one
  []
  (println "one"))

(defmethod do-calculated :two
  []
  (println "two"))


; -----------------------------------------------------------------------------
; complex multimethod config

(def multi-config)

(defmulti do-config basic-type)

(defmethod do-config :one
  [basic-type multi-config]
  (println basic-type multi-config))

(defmethod do-config :two
  [basic-type multi-config]
  (println basic-type multi-config))
