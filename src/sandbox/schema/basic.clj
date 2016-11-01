(ns sandbox.schema.basic
  (:require [schema.core :as s]))

; -----------------------------------------------------------------------------
; basic schema

(def user
  "A schema for a user"
  {:firstName s/Str
   :lastName s/Str})


(s/validate
  user {:firstName "Christopher"
        :lastName "Town"})

