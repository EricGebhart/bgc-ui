(ns bgc-ui.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 ::type
 (fn [db]
   (get-in db [:anybike :type])))

(re-frame/reg-sub
 ::ring
 (fn [db]
   (get-in db [:anybike :ring])))

(re-frame/reg-sub
 ::sprocket
 (fn [db]
   (get-in db [:anybike :sprocket])))

(re-frame/reg-sub
 ::crank-length
 (fn [db]
   (get-in db [:anybike :crank-length])))

(re-frame/reg-sub
 ::wheel-diameter
 (fn [db]
   (get-in db [:anybike :wheel-diameter])))

(re-frame/reg-sub
 ::mph
 (fn [db]
   (get-in db [:anybike :mph])))
