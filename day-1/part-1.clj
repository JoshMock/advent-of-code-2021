#!/usr/bin/env bb

(defn lt [[a b]] (if (< a b) 1 0))

(let [lines (str/split (slurp "./day-1/part-1.txt") #"\n")
      nums (map #(Integer/parseInt %) lines)]
  (println (apply + (map lt (partition 2 1 nums)))))
