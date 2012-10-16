# lein-cssgenbuild

A Leiningen plugin generate stylesheets from cssgen s-expressions.

## Installation

### Clojars

In your `:plugins`:

    [lein-cssgenbuild "0.2.0"]

### cssgen fork

In order to make this plugin work, you must use `[cssgen-rule-seq "0.2.8"]` instead of normal cssgen until the required code gets merged into the main repository.

## Usage

Wrap your rules around a `rule-seq` macro call:

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
  :cssgenbuild {:source-path "src/stylesheets/"
                :destination-path "resources/public/css/"}
```

Generate CSS files with:

    $ lein cssgenbuild once

## License

Copyright © 2012 Michael Drogalis

Distributed under the Eclipse Public License, the same as Clojure.
