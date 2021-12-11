#!/usr/bin/env bb
(ns part-2
  (:require [clojure.string :as str]))

(defn reducer [v1 v2]
  (let [[dir size] v2
        size (Integer/parseInt size)]
    (conj v1
          (cond
            (= dir "forward") {:x (+ (:x v1) size)
                               :y (+ (:y v1) (* (:a v1) size))}
            (= dir "down") {:a (+ (:a v1) size)}
            (= dir "up") {:a (- (:a v1) size)}))))

(let [cmds (map #(str/split % #"\s+") (str/split (slurp "./day-2/part-1.txt") #"\n"))
      final (reduce reducer {:x 0 :y 0 :a 0} cmds)]
  (println final)
  (println (* (:x final) (:y final))))
