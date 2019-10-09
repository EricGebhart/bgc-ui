(ns bgc-ui.events
  (:require
   [re-frame.core :as rf]
   [bgc-ui.db :as db]
   [bike-gear-calc.core :as bgc]
   [day8.re-frame.tracing :refer-macros [fn-traced defn-traced]]
   ))

(defn get-in-bike
  [db key]
  (get-in db [:any-bike key]))

(rf/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
            db/default-db))

(rf/reg-event-db
 ::selected-type
 (fn-traced [db [_ type]]
            (assoc-in db [:any-bike :type] type)))

(rf/reg-event-db
 ::ring-changed
 (fn-traced [db [_ ring]]
            (assoc-in db [:any-bike :ring] ring)))

(rf/reg-event-db
 ::sprocket-changed
 (fn-traced [db [_ sprocket]]
            (assoc-in db [:any-bike :sprocket] sprocket)))

(rf/reg-event-db
 ::rings-changed
 (fn-traced [db [_ qty index]]
            (let [rings (get-in db [:any-bike :rings])]
              (assoc-in db [:any-bike :rings]
                        (update rings index qty)))))
