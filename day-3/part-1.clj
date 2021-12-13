#!/usr/bin/env bb
(ns part-1
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
      (if (< (/ x1 len) 0.5) 1 0))))

(let [cmds (map #(str/split % #"") (str/split (slurp "./day-3/part-1.txt") #"\n"))
      gamma (most-common cmds)
      eps (least-common cmds)
      gamma-dec (Integer/parseInt (apply str gamma) 2)
      eps-dec (Integer/parseInt (apply str eps) 2)]
  (prn (apply str gamma))
  (prn gamma-dec)
  (prn (apply str eps))
  (prn eps-dec)
  (prn (* gamma-dec eps-dec)))
