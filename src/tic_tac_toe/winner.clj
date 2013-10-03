(ns tic_tac_toe.winner)
	
(def winner1 (atom "false"))

(defn checkrow [table symbol box]
  (if(and (= (table box) symbol) (= (table (+ box 1)) symbol)(= (table (+ box 2)) symbol))
          (reset! winner1 "true"))
  )

(defn checkcolumn [table symbol box]
  (if(and (= (table box) symbol) (= (table (+ box 3)) symbol)(= (table (+ box 6)) symbol))
          (reset! winner1 "true"))
  )

(defn checkdiagonal [table symbol box box2]
  (if(and (= (table box) symbol) (= (table 4) symbol)(= (table box2) symbol))
          (reset! winner1 "true"))
  )

(defn check_rows [table symbol box]
  (checkrow table symbol box)
  (if(= @winner1 "false")
        (checkrow table symbol (+ box 3)))
  (if(= @winner1 "false")
              (checkrow table symbol (+ box 6))))

(defn check_columns [table symbol box]
  (checkcolumn table symbol box)
  (if(= @winner1 "false")
        (checkcolumn table symbol (+ box 1)))
  (if(= @winner1 "false")
        (checkcolumn table symbol (+ box 2))))

(defn check_diagonals [table symbol box]
  (checkdiagonal table symbol box 8)
  (if(= @winner1 "false")
        (checkdiagonal table symbol (+ box 2) 6)
        ))

(defn is_there_a_winner? [table symbol]
  (check_rows table symbol 0)
  (check_columns table symbol 0)
  (check_diagonals table symbol 0))
  
(defn resetwinner [table symbol]
  (is_there_a_winner? table symbol)
  (if(= "true" @winner1)
        true
        false))