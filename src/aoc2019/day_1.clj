(ns aoc2019.day-1
  (:require [aoc2019.utils :refer :all]))

(defn part-1 []
  (println
    (sum (map #(- (quot (parse-int %) 3) 2) (read-lines "data/1-1.txt")))))

(defn fuel-for-module [mass]
  (let [fuel-mass (max 0 (- (quot mass 3) 2))]
    (if (> fuel-mass 0) (+ fuel-mass (fuel-for-module fuel-mass)) 0)))

(defn part-2 []
  (println
    (sum (map fuel-for-module (map parse-int (read-lines "data/1-1.txt"))))))
