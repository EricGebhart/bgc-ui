(ns bgc-ui.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [bgc-ui.core-test]))

(doo-tests 'bgc-ui.core-test)
