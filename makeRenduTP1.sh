#!/bin/bash

javadoc -d ./javadoc ./Pacman/*/I[A-Z]*.java
zip -9 -r ./rendu-tp1.zip ./javadoc ./Pacman/*/I[A-Z]*.java
#7za a -r -spf ./rendu-tp1.7z ./javadoc ./Pacman/*/I[A-Z]*.java
