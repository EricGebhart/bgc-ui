(ns bgc-ui.views
  (:require
   [re-frame.core :as rf]
   [re-com.core :as rc]
   [bgc-ui.events :as events]
   [bgc-ui.subs :as subs]
   ))

(defn title []
  (let [name (rf/subscribe [::subs/name])]
    [rc/title
     :label (str "Hello from " @name)
     :level :level1]))

(defn select-type
  "provide a radio button to choose between bicycle gear types."
  []
  (let [type (rf/subscribe [::subs/type])]
    (fn []
      [rc/v-box
       :width "500px"
       :align :center
       :children [[title :level :level2 :label "Bike gear type"]
                  [rc/v-box
                   :children
                   [(doall (for [type-button ["Fixie" "Internal" "Deraileur" ]]
                             ^{:key type-button}   ;; key should be unique among siblings
                             [rc/radio-button
                              :label       type-button
                              :value       type-button
                              :model       type
                              :label-style (if (= type-button @type) {:font-weight "bold"})
                              :on-change   #(rf/dispatch [::events/selected-type %])]))]]]])))


(defn array-number-input
  [var event index]
  [:div
   [:input {:type :number
            :value (get var index)
            :on-change #(rf/dispatch [event
                                      (-> % .-target .-value index)])}]])

(defn array-number-field
  "Input a number, provide the array subscription. ::subs/rings,
  the index of the element, and the event ::events/ring-change."
  [sub index event]
  (let [array (rf/subscribe [sub])]
    (fn []
      (array-number-input @array event index))))

(defn number-input
  [var event]
  [:div
   [:input {:type :number
            :value var
            :on-change #(rf/dispatch [event
                                      (-> % .-target .-value)])}]])

(defn input-Ring
  "Input a single ring gear size"
  []
  (let [ring (rf/subscribe [::subs/ring])]
    (fn []
      (number-input @ring ::events/ring-changed))))

(defn input-sprocket
  "Input a sprocket size"
  []
  (let [sprocket (rf/subscribe [::subs/sprocket])]
    (fn []
      (number-input @sprocket ::events/ring-changed))))

(defn input-rings
  "input up to 3 ring sizes"
  []
  (let [rings (rf/subscribe [::subs/rings])]
    (fn []
      (map #(array-number-input @rings ::events/rings-changed %) (range 3)))))

(defn main-panel []
  [rc/v-box
   :height "100%"
   :children [[title]
              ]])
