(ns sandbox.functions.maps)

(def test-map {:account-no 12345678 :lname "Jones" :fnam "Fred"})

; -----------------------------------------------------------------------------
; maps

(assoc test-map :fnam "Sue")


;;=> {:account-no 12345678, :lname "Jones", :fnam "Sue"}

;; notice that test-map is unchanged
test-map

(keyword "foo")



(def x {:whatever 1})

(when-let [value (:whatever x)]
  (println "x+1 = " (inc value)))

