(ns rei-hino.core
  (:gen-class)
  (:require [clojure.java.shell :as shell]))

(defn cowprint [speak]
  (->> (shell/sh "cowsay" speak) :out print))

; This is awful practice
(defn mjpegtime []
  (future
   (shell/sh "mjpg_streamer" "-i" "input_uvc.so" "-o" "output_http.so" "&")))

(defn -main
 "I don't do a whole lot ... yet."
 [& args]
 (cowprint "Jetson Time!")
 (mjpegtime)
 (shutdown-agents))
