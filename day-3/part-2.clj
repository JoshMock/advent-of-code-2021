#!/usr/bin/env bb
(ns part-2
  (:require [clojure.string :as str]))

(defn to-int [l]
  (for [x1 l] (Integer/parseInt x1)))

(defn most-common [cmds]
  (let [summed (apply map + (map to-int cmds))
        len (count cmds)]
    (for [x1 summed]
      (if (>= (/ x1 len) 0.5) 1 0))))

(defn least-common [cmds]
  (let [summed (apply map + (map to-int cmds))
        len (count cmds)]
    (for [x1 summed]
      (if (<= (/ x1 len) 0.5) 1 0))))

(defn similar [a cmds]
  (let [x (atom cmds)
        idx (atom 0)]
    (while (> (count @x) 1)
      (swap! x #(filter #(= (nth % idx) (nth a idx)) @x))
      (swap! idx inc)
      (prn (count @x))
      (prn @idx))
    @x))

(let [cmds (map #(str/split % #"") (str/split (slurp "./day-3/part-1.txt") #"\n"))
      most (most-common cmds)
      least (least-common cmds)]
  (prn most)
  (prn (count (similar most cmds))))
