(ns leiningen.cssgenbuild
  (:require [cssgen :refer :all]
            [watchtower.core :refer :all]
            [fs.core :as fs]))

(def file-ns
     (memoize
      (fn [file]
        (println file)
        (:ns (meta file)))))

(defn generate-stylesheet [project cssgen-file]
  (let [namespace (file-ns (load-file (.getPath cssgen-file)))
        name (.getName cssgen-file)
        rule-seq (var-get (ns-resolve (ns-name namespace) 'rule-sequence))
        dst-path (str (:destination-path (:cssgenbuild project)) name)]
    (do
      (println "Generating " css-file " to " dst-path)
      (apply css-file dst-path rule-seq))))

(defn once [project]
  (doall (map #(generate-stylesheet project %) (fs/find-files (:source-path (:cssgenbuild project)) #".+.clj"))))

(defn auto [project]
  @(watcher [(:source-path (:cssgenbuild project))]
            (rate 50)
            (file-filter ignore-dotfiles)
            (file-filter (extensions :clj))
            (on-change
             (fn [file]
               (println "Generating CSS for: " (first file))
               (generate-stylesheet project (first file))))))

(defn cssgenbuild
  "Generate stylesheets from cssgen."
  [project & args]
  (cond (= (first args) "once") (once project)
        (= (first args) "auto") (auto project)))

