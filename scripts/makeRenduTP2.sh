#!/bin/bash

zip -9 -r ./build/rendu-tp2-lbs.zip ./Pacman/Data/*.java
#7za a -r -spf ./build/rendu-tp2-lbs.7z ./Pacman/Data/*.java
zip -9 -r ./build/rendu-tp2-fj.zip ./Pacman/Logic/*.java
#7za a -r -spf ./build/rendu-tp2-fj.7z ./Pacman/Logic/*.java
zip -9 -r ./build/rendu-tp2-ap.zip ./Pacman/View/*.java
#7za a -r -spf ./build/rendu-tp2-ap.7z ./Pacman/View/*.java
