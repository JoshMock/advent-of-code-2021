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
      (reset! x (filter #(= (Integer/parseInt (nth % @idx)) (nth a @idx)) @x))
      (swap! idx inc))
    (first @x)))

(let [cmds (map #(str/split % #"") (str/split (slurp "./day-3/part-1.txt") #"\n"))
      most (most-common cmds)
      least (least-common cmds)
      most-sim-bin (apply str (similar most cmds))
      most-sim-int (Integer/parseInt most-sim-bin 2)
      least-sim-bin (apply str (similar least cmds))
      least-sim-int (Integer/parseInt least-sim-bin 2)]
  (prn (apply str most))
  (prn most-sim-bin)
  (prn (apply str least))
  (prn least-sim-bin)
  (prn (* most-sim-int least-sim-int)))
