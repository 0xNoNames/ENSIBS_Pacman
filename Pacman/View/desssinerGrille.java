package Pacman.View;

import Pacman.Data.DataForView;
import Pacman.Logic.Case;
import Pacman.Logic.Jouable;

import java.awt.Graphics2D;

/**
 * La classe dessinerGrille permet de déssiner les différents sprites liés à la
 * grille (fruits et gommes).
 * 
 * @author Arthur Pêtre
 */
public class desssinerGrille {

    /**
     * Dessine les différents éléments de la grille.
     * 
     * @param grille matrice représentant la grille avec ses éléments.
     * @param g2d    Graphics2D permettant de mettre à jour les sprites
     * @param data   permet de récuperer les sprites depuis Data.
     */
    public static void dessiner(Case[][] grille, Graphics2D g2d, DataForView data) {

        // Parcours de la grille case par case.
        for (int i = 0; i < (grille.length); i++) {
            for (int j = 0; j < (grille[i].length); j++) {

                // Si la case est de la classe Jouable alors elle peut contenir un fruit ou une
                // gomme.
                if (grille[i][j] instanceof Jouable) {
                    Jouable caseJ = (Jouable) grille[i][j];

                    // Si la case contient un objet on le dessine.
                    if (caseJ.getObjet() != null) {

                        // Selon l'objet dans la case on l'affiche.
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
