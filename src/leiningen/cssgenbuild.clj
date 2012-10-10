(ns leiningen.cssgenbuild
  (:require [cssgen :refer :all]
            [stylesheets.theme :refer [*rule-list*]]
            [fs.core :as fs]))

(defn generate-stylesheet [project cssgen-file]
  (let [file-ns (:ns (meta (load-file (.getPath cssgen-file))))
        name (.getName cssgen-file)]
    (in-ns (ns-name file-ns))
    (apply css-file (str (:destination-path (:cssgenbuild project)) name) *rule-list*)))

(defn once [project]
  (doall (map #(generate-stylesheet project %) (fs/find-files (:source-path (:cssgenbuild project)) #".+.clj"))))

(defn cssgenbuild
  "Generate stylesheets from cssgen."
  [project & args]
  (if (= (first args) "once")
    (once project)))