(ns aoc2019.core
  (:require [aoc2019.day-1 :as d1]))

(def days {:d1 {:p1 d1/part-1 :p2 d1/part-2}})

(def validators [#(not (nil? %1))
                 #(= (count %1) 2)
                 #(re-matches #"d\d{1,2}p\d{1,2}" (apply str %1))])

(defn valid? [args] (reduce #(and %1 (%2 args)) true validators))

(defn has-fn? [day part] (boolean (get-in days [day part])))

(defn -main [& args]
  (if (valid? args)
    (let [[day part] (map keyword args)]
      (if (has-fn? day part)
        ((get-in days [day part]))
        (println "No corresponding function for" day part)))
    (println "Usage: lein run d{n} p{m}")))
