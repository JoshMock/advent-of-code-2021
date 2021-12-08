#!/usr/bin/env bb
(ns part-2
  (:require [clojure.string :as str]))

(defn lt [[a b]] (if (< a b) 1 0))

(let [lines (str/split (slurp "./day-1/part-1.txt") #"\n")
      measures (map #(Integer/parseInt %) lines)
      windows (partition 3 1 measures)
      totals (map #(apply + %) windows)]
  (println (apply + (map lt (partition 2 1 totals)))))
