(ns leiningen.cssgenbuild
  (:require [cssgen :refer :all]
            [fs.core :as fs]))

(defn generate-stylesheet [project cssgen-file]
  (let [file-ns (:ns (meta (load-file (.getPath cssgen-file))))
        name (.getName cssgen-file)
        rule-seq (var-get (ns-resolve (ns-name file-ns) 'rule-sequence))
        dst-path (str (:destination-path (:cssgenbuild project)) name)]
    (apply css-file dst-path rule-seq)))

(defn once [project]
  (doall (map #(generate-stylesheet project %) (fs/find-files (:source-path (:cssgenbuild project)) #".+.clj"))))

(defn cssgenbuild
  "Generate stylesheets from cssgen."
  [project & args]
  (if (= (first args) "once")
    (once project)))

