(defproject lein-cssgenbuild "0.2.1"
  :description "Leiningen plugin to generate stylesheets from cssgen"
  :url "https://github.com/MichaelDrogalis/lein-cssgenbuild"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[cssgen-rule-seq "0.2.8"]
                 [fs "1.3.2"]
                 [watchtower "0.1.1"]]
  :eval-in-leiningen true)

