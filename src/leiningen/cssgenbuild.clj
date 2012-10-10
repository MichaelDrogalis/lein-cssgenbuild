(ns leiningen.cssgenbuild
  (:require [cssgen :refer :all]
            [leiningen.theme :refer [*rule-list*]]))

(defn once []
  (apply css-file "out.css" *rule-list*))

(defn cssgenbuild
  "Generate stylesheets from cssgen."
  [project & args]
  (if (= (first args) "once")
    (once)))