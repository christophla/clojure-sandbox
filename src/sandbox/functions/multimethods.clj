(ns sandbox.functions.multimethods
  (:require [clojure.test :as test]))


(def basic-type #{:one :two})


; -----------------------------------------------------------------------------
; basic multimethod


(defmulti do-basic basic-type)

(defmethod do-basic :one
  [keyword]
  (name keyword))

(defmethod do-basic :two
  [keyword]
  (name keyword))

(test/testing "basic multimethod"
    (test/is (= "one" (do-basic :one)))
    (test/is (= "two" (do-basic :two))))


; -----------------------------------------------------------------------------
; calulated multimethod

(def calculated-type
  (fn [keyword]
    (cond
      (= keyword "one") :one
      (= keyword "two") :two)))

(defmulti do-calculated calculated-type)

(defmethod do-calculated :one
  [keyword]
  (name keyword))

(defmethod do-calculated :two
  [keyword]
  (name keyword))

(test/testing "calculated multimethod"
  (test/is (= "one" (do-calculated "one"))))


; -----------------------------------------------------------------------------
; multimethod with overload

(def overload-type-fn
  (fn [keyword config]
    (cond
      (= keyword "one") :one
      (= keyword "two") :two)))

(defmulti do-overload overload-type-fn)

(defmethod do-overload :one
  [keyword config]
  (str config))

(defmethod do-overload :two
  [keyword config]
  (str config))

(test/testing "overload multimethod"
  (test/is (= "config" (do-overload "one" "config"))))