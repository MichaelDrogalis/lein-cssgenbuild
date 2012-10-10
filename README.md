# lein-cssgenbuild

A Leiningen plugin generate stylesheets from cssgen s-expressions.

## Installation

### Sser-level plugins

Put `[lein-cssgenbuild "0.1.0-SNAPSHOT"]` into the `:plugins` vector of your
`:user` profile, or if you are on Leiningen 1.x do `lein plugin install
lein-cssgenbuild 0.1.0-SNAPSHOT`.

### Project-level plugins

Put `[lein-cssgenbuild "0.1.0-SNAPSHOT"]` into the `:plugins` vector of your project.clj.

### Usage

    $ lein cssgenbuild once

## License

Copyright © 2012 Michael Drogalis

Distributed under the Eclipse Public License, the same as Clojure.
