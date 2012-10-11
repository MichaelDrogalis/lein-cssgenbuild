(defproject lein-cssgenbuild "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[cssgen-rule-seq "0.2.7-SNAPSHOT"]
                 [fs "1.3.2"]]
  :eval-in-leiningen true
  :cssgenbuild {:source-path "src/stylesheets/"
                :destination-path "resources/public/css/"})