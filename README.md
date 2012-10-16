# lein-cssgenbuild

A Leiningen plugin to generate stylesheets from cssgen s-expressions.

## Installation

### Clojars

In your `:plugins`:

    [lein-cssgenbuild "0.2.1"]

### cssgen fork

In order to make this plugin work, you must use `[cssgen-rule-seq "0.2.8"]` instead of normal cssgen until the required code gets merged into the main repository.

## Usage

Wrap your rules with a `rule-seq` macro call:

```clojure
(ns stylesheets.theme
  (:require [cssgen :refer :all]))

(rule-seq
 (rule "ul.nav, ol"
       :color :black)
 (rule "a"
       :color :red))
```

Configure `cssgenbuild` in your `project.clj`:

```clojure
  :cssgenbuild {:source-path "path/to/clj-stylesheets/"
                :destination-path "path/to/css/destination/files/"}
```

Generate CSS files with:

    $ lein cssgenbuild once

## License

Copyright © 2012 Michael Drogalis

Distributed under the Eclipse Public License, the same as Clojure.
