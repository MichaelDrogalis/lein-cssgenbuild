(ns leiningen.theme
  (:require [cssgen :refer :all]))

(defmacro rules [& rules]
  `(def ^:dynamic *rule-list* [~@rules]))

(rules
 (rule "ul.nav, ol"
       :color :black)
 (rule "a"
       :color :red))

