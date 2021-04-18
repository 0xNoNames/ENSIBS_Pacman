#!/bin/bash

rm ./Pacman/*.class ./Pacman/*/*.class ./org/json/simple/*.class org/json/simple/parser/*.class 2>/dev/null
javac -nowarn ./Pacman/View/main.java
jar cfe build/ViewMain.jar Pacman.View.main Pacman/*/*.class Pacman/Data/config.json Pacman/Data/sprites.png org/json/simple/*.class org/json/simple/parser/*.class
rm ./Pacman/*.class ./Pacman/*/*.class ./org/json/simple/*.class org/json/simple/parser/*.class 2>/dev/null
