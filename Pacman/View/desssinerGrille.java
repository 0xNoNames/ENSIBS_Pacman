package Pacman.View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Pacman.Data.DataForView;
import Pacman.Logic.Case;
import Pacman.Logic.Jouable;

/**
 * La classe dessinerGrille permet de déssiner les différents sprites liés à la
 * grille (fruits et gommes).
 * 
 * @author Arthur Pêtre
 */
public class desssinerGrille {

    // Dessine les éléments de la grille.
    public void desssinerGrille(Case[][] grille, JFrame fenetre, DataForView data) {
        JLabel imageLabel;
        for (Case[] ligne : grille) {
            for (Case cases : ligne) {
                if (cases instanceof Jouable) {
                    Jouable caseJ = (Jouable) cases;
                    if (caseJ.getObjet() != null) {
                        switch (caseJ.getObjet().toString()) {
                        case "Cerise":
                            imageLabel = new JLabel(new ImageIcon(data.getFruitSprites()[0]));
                            fenetre.add(imageLabel);
                            break;

                        case "Fraise":
                            imageLabel = new JLabel(new ImageIcon(data.getFruitSprites()[1]));
                            fenetre.add(imageLabel);
                            break;

                        case "Orange":
                            imageLabel = new JLabel(new ImageIcon(data.getFruitSprites()[2]));
                            fenetre.add(imageLabel);
                            break;

                        case "Melon":
                            imageLabel = new JLabel(new ImageIcon(data.getFruitSprites()[3]));
                            fenetre.add(imageLabel);
                            break;

                        case "Galboss":
                            imageLabel = new JLabel(new ImageIcon(data.getFruitSprites()[4]));
                            fenetre.add(imageLabel);
                            break;

                        case "Cloche":
                            imageLabel = new JLabel(new ImageIcon(data.getFruitSprites()[5]));
                            fenetre.add(imageLabel);
                            break;

                        case "Clé":
                            imageLabel = new JLabel(new ImageIcon(data.getFruitSprites()[6]));
                            fenetre.add(imageLabel);

                        case "PetiteGomme":
                            imageLabel = new JLabel(new ImageIcon(data.getGommesSprites()[0]));
                            fenetre.add(imageLabel);

                        case "GrosseGomme":
                            imageLabel = new JLabel(new ImageIcon(data.getGommesSprites()[1]));
                            fenetre.add(imageLabel);
                        }
                    }
                }
            }
        }
    }
}
