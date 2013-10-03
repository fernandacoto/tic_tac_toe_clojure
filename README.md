Tic tac toe in Clojure
======================
This repository contains a simple tic tac toe made in clojure. 
There are 2 folders:
* src:
    Into here, there's another folder named tic_tac_toe, in that folder there are 2 files:
      * core.clj : This manages the logic of the game and menu.
      * winner.clj : This contains the logic of how a player can win
* target:
    This folder contains the .jar file, which is the executable

Also there's a file called project.clj, well this file contains the "main", it is from here that you can run the program
and generate the jar file.

To run this program you should have installed Lein, if you haven't go to : http://zef.me/2470/building-clojure-projects-with-leiningen
The steps to run this are:
* Open cmd and go to the directory *tic_tac_toe_clojure*
* Write in the cmd *lein uberjar*
* After that go to the target folder that has been created and write *java -jar name_of_the_jar_file_generated*


----
Fernanda Coto
