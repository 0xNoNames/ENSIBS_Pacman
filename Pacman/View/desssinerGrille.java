package Pacman.View;

import Pacman.Data.DataForView;
import Pacman.Logic.Case;
import Pacman.Logic.Cerise;
import Pacman.Logic.Jouable;
import Pacman.Logic.*;

import java.awt.Graphics2D;

/**
 * La classe dessinerGrille permet de déssiner les différents sprites liés à la
 * grille (fruits et gommes).
 * 
 * @author Arthur Pêtre
 */
public class desssinerGrille {

    // Dessine sur la JFrame les éléments de la grille.
    public static void dessiner(Case[][] grille, Graphics2D g2d, DataForView data) {

        for (int i = 0; i < (grille.length - 2); i++) {
            for (int j = 0; j < (grille[i].length - 2); j++) {

                if (grille[i][j] instanceof Jouable) {

                    Jouable caseJ = (Jouable) grille[i][j];

                    if (caseJ.getObjet() != null) {

                        switch (caseJ.getObjet().getClass().getSimpleName()) {
                        case "Cerise":
                            g2d.drawImage(data.getFruitSprites()[0], (i * 8) + 4, (8 * j) + 32, null);
                            break;

                        case "Fraise":
                            g2d.drawImage(data.getFruitSprites()[1], (i * 8) + 4, (8 * j) + 32, null);
                            break;

                        case "Orange":
                            g2d.drawImage(data.getFruitSprites()[2], (i * 8) + 4, (8 * j) + 32, null);
                            break;

                        case "Melon":
                            g2d.drawImage(data.getFruitSprites()[3], (i * 8) + 4, (8 * j) + 32, null);
                            break;

                        case "Galboss":
                            g2d.drawImage(data.getFruitSprites()[4], (i * 8) + 4, (8 * j) + 32, null);
                            break;

                        case "Cloche":
                            g2d.drawImage(data.getFruitSprites()[5], (i * 8) + 4, (8 * j) + 32, null);
                            break;

                        case "Clé":
                            g2d.drawImage(data.getFruitSprites()[6], (i * 8) + 4, (8 * j) + 32, null);
                            break;

                        case "PetiteGomme":
                            g2d.drawImage(data.getGommesSprites()[0], (i * 8) + 1, (8 * j) + 29, null);
                            break;

                        case "GrosseGomme":
                            g2d.drawImage(data.getGommesSprites()[1], (i * 8), (8 * j) + 28, null);
                            break;
                        }
                    }
                }
            }
        }
    }
}
