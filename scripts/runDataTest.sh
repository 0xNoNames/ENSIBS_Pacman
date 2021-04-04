rm ./Pacman/*/*.class
javac ./Pacman/Data/Test.java
jar cfe build/DataTest.jar Pacman.Data.Test Pacman/*/*.class org/json/simple/*.class org/json/simple/parser/*.class
java -jar build/DataTest.jar
