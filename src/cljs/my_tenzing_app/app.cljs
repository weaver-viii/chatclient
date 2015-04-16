(ns my-tenzing-app.app
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [sablono.core :as html :refer-macros [html]]))

(def app-model
  (atom
   {
    :messages []
    :user "alice"
    :room "Company-wide chat"
    :message-being-typed ""
    :friends [{:user "bob" :image "bob.jpg"}
              {:user "carl" :image "carl.jpg"}]

    }))

(defn widget [data owner]
  (reify
    om/IRender
    (render [this]
      (html
       [:div
        [:h1 "Hello"]
        [:h2 "Messages"]

        ])
      )))

(defn init []
  (om/root widget app-model
           {:target (. js/document (getElementById "container"))}))
