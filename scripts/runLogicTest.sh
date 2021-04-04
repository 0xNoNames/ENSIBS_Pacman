#!/bin/bash

rm ./Pacman/*.class ./Pacman/*/*.class ./org/json/simple/*.class org/json/simple/parser/*.class 2>/dev/null
javac -nowarn ./Pacman/Logic/Test.java
jar cfe build/LogicTest.jar Pacman.Logic.Test Pacman/*/*.class Pacman/Data/config.json Pacman/Data/sprites.png org/json/simple/*.class org/json/simple/parser/*.class
rm ./Pacman/*.class ./Pacman/*/*.class ./org/json/simple/*.class org/json/simple/parser/*.class 2>/dev/null
java -jar build/LogicTest.jar
