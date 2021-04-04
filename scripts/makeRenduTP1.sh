#!/bin/bash

javadoc -d ./javadoc ./Pacman/*/I[A-Z]*.java
zip -9 -r ./build/rendu-tp1.zip ./javadoc ./Pacman/*/I[A-Z]*.java
#7za a -r -spf ./build/rendu-tp1.7z ./javadoc ./Pacman/*/I[A-Z]*.java
