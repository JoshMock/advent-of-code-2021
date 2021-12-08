#!/usr/bin/env bb
(ns part-1
  (:require [clojure.string :as str]))

(defn parse-cmd [[dir size]]
  (let [size (Integer/parseInt size)]
    (cond
      (= dir "forward") {:x size}
      (= dir "down") {:y size}
      (= dir "up") {:y (* -1 size)}
      :else nil)))

(let [cmds (map #(str/split % #"\s+") (str/split (slurp "./day-2/part-1.txt") #"\n"))
      parsed (map parse-cmd cmds)
      merged (apply merge-with + parsed)]
  (println merged)
  (println (* (:x merged) (:y merged))))
