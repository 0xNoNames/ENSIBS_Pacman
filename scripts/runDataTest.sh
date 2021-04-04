rm ./Pacman/*.class ./Pacman/*/*.class ./org/json/simple/*.class org/json/simple/parser/*.class
javac ./Pacman/Data/Test.java
jar cfe build/DataTest.jar Pacman.Data.Test Pacman/*/*.class Pacman/Data/config.json org/json/simple/*.class org/json/simple/parser/*.class
rm ./Pacman/*.class ./Pacman/*/*.class ./org/json/simple/*.class org/json/simple/parser/*.class
java -jar build/DataTest.jar
