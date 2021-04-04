#!/bin/bash

rm ./Pacman/*.class ./Pacman/*/*.class ./org/json/simple/*.class org/json/simple/parser/*.class 2>/dev/null
javac -nowarn ./Pacman/Data/Test.java
jar cfe build/DataTest.jar Pacman.Data.Test Pacman/*/*.class Pacman/Data/config.json org/json/simple/*.class org/json/simple/parser/*.class
rm ./Pacman/*.class ./Pacman/*/*.class ./org/json/simple/*.class org/json/simple/parser/*.class 2>/dev/null
java -jar build/DataTest.jar
