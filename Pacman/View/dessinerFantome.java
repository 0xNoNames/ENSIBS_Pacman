package Pacman.View;

import java.awt.Graphics2D;
import Pacman.Data.DataForView;
import Pacman.Logic.EDirection;
import Pacman.Logic.EStatutFantome;
import Pacman.Logic.Fantome;

/**
 * 
 * La classe dessinerFantome permet de gérer les sprites des Fantomes.
 * 
 * @author Arthur Pêtre
 */
public class dessinerFantome {
    private static int spriteActuel = 1;
    private static int offsetX = 0;
    private static int offsetY = 24;

    // Met à jour le numéro de sprite actuel et dessine le Fantome voulu.
    public static void dessiner(Fantome fantome, Graphics2D g2d, DataForView data) {
        System.out.println("Il s'agit du fantome suivant : " + fantome.getClass());
        dessinerSpriteFantome(fantome, g2d, data);
        updateOffsets(fantome);
        updateSprite();
    }

    // Met à jour le numéro de sprite actuel.
    private static void updateSprite() {
        if (spriteActuel == 2) {
            spriteActuel = 0;
        } else {
            spriteActuel = 1;
        }
    }

    // Met à jour le décalage X et Y des images.
    private static void updateOffsets(Fantome fantome) {
        double[] position = fantome.getPosition();
        if (position[0] >= 0 && position[0] < 0.11) {
            offsetX = 0;
        } else if (position[0] >= 0.11 && position[0] < 0.22) {
            offsetX = 1;
        } else if (position[0] >= 0.22 && position[0] < 0.33) {
            offsetX = 2;
        } else if (position[0] >= 0.33 && position[0] < 0.44) {
            offsetX = 3;
        } else if (position[0] >= 0.44 && position[0] < 0.55) {
            offsetX = 4;
        } else if (position[0] >= 0.55 && position[0] < 0.66) {
            offsetX = 5;
        } else if (position[0] >= 0.66 && position[0] < 0.77) {
            offsetX = 6;
        } else if (position[0] >= 0.77 && position[0] < 0.88) {
            offsetX = 7;
        } else if (position[0] >= 0.88 && position[0] < 0) {
            offsetX = 8;
        }

        if (position[1] >= 0 && position[1] < 0.11) {
            offsetY = 24;
        } else if (position[1] >= 0.11 && position[1] < 0.22) {
            offsetY = 25;
        } else if (position[1] >= 0.22 && position[1] < 0.33) {
            offsetY = 26;
        } else if (position[1] >= 0.33 && position[1] < 0.44) {
            offsetY = 27;
        } else if (position[1] >= 0.44 && position[1] < 0.55) {
            offsetY = 28;
        } else if (position[1] >= 0.55 && position[1] < 0.66) {
            offsetY = 29;
        } else if (position[1] >= 0.66 && position[1] < 0.77) {
            offsetY = 30;
        } else if (position[1] >= 0.77 && position[1] < 0.88) {
            offsetY = 31;
        } else if (position[1] >= 0.88 && position[1] < 0) {
            offsetY = 32;
        }
    }

    // Dessine le Fantome voulu selon son état.
    private static void dessinerSpriteFantome(Fantome fantome, Graphics2D g2d, DataForView data) {
        switch (spriteActuel) {
        case 1:
            switch (fantome.getStatut()) {
            case CHASSEUR:
                System.out.println(fantome.getCouleur() + " est chasseur");
                g2d.drawImage(
                        data.getFantomesSprites(fantome.getCouleur(),
                                EDirection.NORD/* fantome.getDirectionCourante() */)[0],
                        ((int) fantome.getposX()) * 8 + offsetX, ((int) fantome.getposY()) * 8 + offsetY, null);
                break;

            case VULNERABLE:
                System.out.println(fantome.getCouleur() + " est vulnérable");
                g2d.drawImage(data.getVulnerableFantomesSprites()[0], ((int) fantome.getposX()) * 8 + offsetX,
                        ((int) fantome.getposY()) * 8 + offsetY, null);
                break;

            case MORT:
                System.out.println(fantome.getCouleur() + " est mort");

                g2d.drawImage(data.getMortFantomeSprites()[0], ((int) fantome.getposX()) * 8 + offsetX,
                        ((int) fantome.getposY()) * 8 + offsetY, null);
                break;

            default:
                System.out.println(fantome.getCouleur() + " est jsp");
                break;
            }
            break;

        case 2:
            switch (fantome.getStatut()) {
            case CHASSEUR:
                System.out.println(fantome.getCouleur() + " est chasseur");
                g2d.drawImage(
                        data.getFantomesSprites(fantome.getCouleur(),
                                EDirection.NORD /* fantome.getDirectionCourante() */)[1],
                        ((int) fantome.getposX()) * 8 + offsetX, ((int) fantome.getposY()) * 8 + offsetY, null);
                break;

            case VULNERABLE:
                System.out.println(fantome.getCouleur() + " est vulnérable");
                g2d.drawImage(data.getVulnerableFantomesSprites()[1], ((int) fantome.getposX()) * 8 + offsetX,
                        ((int) fantome.getposY()) * 8 + offsetY, null);
                break;

            case MORT:
                System.out.println(fantome.getCouleur() + " est mort");
                g2d.drawImage(data.getMortFantomeSprites()[1], ((int) fantome.getposX()) * 8 + offsetX,
                        ((int) fantome.getposY()) * 8 + offsetY, null);
                break;
            }
            break;
        }
    }
}
