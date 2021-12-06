#!/usr/bin/env bb

(defn reducer [old new]
  (let [meas-val (first new)
        meas-names (rest new)]
    (assoc old meas-val meas-names)))

(let [lines (str/split (slurp "./day-1/part-2.txt") #"\n")
      lines (map #(str/split % #"\s+") lines)
      data (reduce reducer {} lines)]
  (println data))
