(ns tic_tac_toe.core
	(:gen-class)
	(:use tic_tac_toe.winner)
	(:require clojure.java.io))
	
(def board (atom(vector "0" "1" "2" "3" "4" "5" "6" "7" "8")))
(def player_one (atom 1))
(def player_two (atom 2))
(def number_of_occupied_boxes (atom 0))
(def player_playing (atom @player_one))
(def winner? (atom "false"))
(def box (atom 0))

(defn read-int []
  (try (Integer/parseInt (read-line))
    (catch NumberFormatException e nil)))
	
(defn end_of_game []
		(if(= @player_playing @player_one)
			(println "Congratulations player 2 you won")
			(println "Congratulations player 1 you won"))
		  )

(defn find_if_winner? [symbol]
 (if(= true (resetwinner @board symbol))
        (do(reset! winner? "true")
		(end_of_game))
        (reset! winner? "false")
        ))
	
(defn printline [numb1 numb2 numb3]
  (println(@board numb1) "|" (@board numb2)"|" (@board numb3)))

(defn printboard []
  (printline 0 1 2)
  (println "----------")
  (printline 3 4 5)
  (println "----------")
  (printline 6 7 8)
  )

(defn make_movement [box symbol]
  (swap! board assoc box symbol)
  )

(defn play [box]
	(if(= @player_playing @player_one)
          (do 
           (make_movement box "X")
           (reset! player_playing @player_two )
		   (find_if_winner? "X"));(find_if_winner? "X")
          (do 
           (make_movement box "O")
           (reset! player_playing @player_one )
		   (find_if_winner? "O")));(find_if_winner? "O")
	(printboard))
	
(defn ask_for_box []
  (println "Digit the number of the box player" @player_playing)
  (let [input (read-int)]
    (if (and (>= input 0) (<= input 8))
		(do
		(if (and (not= (get @board box) "X") (not= (get @board box) "O") )
			(reset! box input) ;box sino askforbox
			(ask_for_box))))
    )
  )

(defn start_game_player_against_player []
  (while(<= @number_of_occupied_boxes 8)
        (do
          (if(= @winner? "false")
		  (do(ask_for_box)
		  (play @box)))
          (swap! number_of_occupied_boxes inc))
        )
		(System/exit 0))
	
(defn go_to_play []
 (printboard)
 (start_game_player_against_player))

(defn go_to_instructions []
 (println "INSTRUCTIONS:")
 (println "To play just digit the number of the box in which one you wanna move")
 (println "For example:  if you have the board")
 (println "0 | 1 | 2")
 (println "---------")
 (println "3 | 4 | 5")
 (println "---------")
 (println "7 | 8 | 9")
 (println "And you wanna move in the center when the instruction Digit the number of the box, you digit 4")
 )	
	
(defn go_to_option [option]
	(if (= option 1)
		(go_to_instructions)
		(if(= option 2)
			(go_to_play)
			(if(= option 3)
				(System/exit 0)))))
	
(defn menu_options[]
	(println "Menu:")
	(println "1.Instructions")
	(println "2.Play")
	(println "3.Exit")
	(println "Select an option")
	(let [input (read-int)]
	  (if(and(> input 0) (< input 4))
			(do(go_to_option input))));
	(menu_options))	
	
(defn printmenu []
	(println "Welcome!!")
	(println "This is a simple tic_tac_toe in clojure")
	(menu_options))
	
(defn -main []
    (printmenu))