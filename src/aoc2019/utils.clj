(ns aoc2019.utils
  (:require [clojure.string :as s]))

(defn read-lines [f] (s/split-lines (slurp f)))

(defn parse-int [string]
  (try (Integer/parseInt string)
    (catch Exception exc nil)))

(defn sum [coll] (reduce + coll))

(defn abs [n] (max n (- n)))
