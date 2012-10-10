(ns leiningen.cssgenbuild
  (:require [cssgen :refer :all]
            [stylesheets.theme :refer [*rule-list*]]
            [fs.core :as fs]))

(defn generate-stylesheet [cssgen-file]
  (let [file-ns (:ns (meta (load-file (.getPath cssgen-file))))]
    (in-ns (ns-name file-ns))
    (apply css-file "out.css" *rule-list*)))

(defn once []
  (doall (map generate-stylesheet (fs/find-files "src/stylesheets" #".+.clj"))))

(defn cssgenbuild
  "Generate stylesheets from cssgen."
  [project & args]
  (if (= (first args) "once")
    (once)))