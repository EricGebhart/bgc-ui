(ns bgc-ui.db
  (:require
   [bike-gear-calc.core :refer [any-bike]]))

(def default-db
  {:name "bike-gear-calculator"
   :anybike (any-bike {})
   :bike-result nil})
