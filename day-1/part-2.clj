#!/usr/bin/env bb
(ns part-2
  (:require [clojure.string :as str]))

(defn reducer [old new]
  (let [meas-val (Integer/parseInt (first new))
        meas-names (rest new)
        pivot (zipmap meas-names (repeat [meas-val]))]
    (merge-with concat old pivot)))

(defn lt [[[_ a] [_ b]]] (if (< a b) 1 0))

(let [lines (str/split (slurp "./day-1/part-2.txt") #"\n")
      lines (map #(str/split % #"\s+") lines)
      pivoted (reduce reducer {} lines)
      summed (map (fn [[k v]] [k (apply + v)]) pivoted)]
  (println (apply + (map lt (partition 2 1 summed)))))
