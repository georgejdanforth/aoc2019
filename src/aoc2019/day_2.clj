(ns aoc2019.day-2
  (:require [aoc2019.utils :refer :all]))

(defn read-input [f] (vec (map parse-int (re-seq #"\d+" (slurp f)))))

(def init-values (read-input "data/2-1.txt"))

(defn do-op [values i]
  (let [j (values (values (+ 1 i))) k (values (values (+ 2 i))) h (values (+ 3 i))]
    (case (values i)
      1 (assoc values h (+ j k))
      2 (assoc values h (* j k)))))

(defn do-ops
  ([values] (do-ops values 0))
  ([values i] (case (values i)
                (1 2) (do-ops (do-op values i) (+ 4 i))
                99 values)))

(defn compute [noun verb]
  (first (do-ops (assoc init-values 1 noun 2 verb))))

(defn part-1 [] (println (compute 12 2)))

(defn find-verb [noun target lo hi]
  (let [verb (quot (+ lo hi) 2) result (compute noun verb)]
    (cond
      (= result target) verb 
      (<= (- hi lo) 1) nil
      :else (let [[new-lo new-hi] (if (> result target) [lo verb] [verb hi])]
              (find-verb noun target new-lo new-hi)))))

(def -target 19690720)

(defn part-2 [] 
  (loop [noun 0]
    (let [verb (find-verb noun -target 0 100)]
      (if verb
        (println (+ (* 100 noun) verb))
        (recur (+ noun 1))))))
