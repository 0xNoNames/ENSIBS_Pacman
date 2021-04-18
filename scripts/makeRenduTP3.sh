#!/bin/bash

rm ./build/rendu-tp3.zip
./scripts/buildViewMain.sh
cp ./build/ViewMain.jar ./build/Pacman.jar
zip -9 -r ./build/rendu-tp3.zip build/Pacman.jar ./Pacman/* ./org/* ./README.md
rm ./build/Pacman.jar
