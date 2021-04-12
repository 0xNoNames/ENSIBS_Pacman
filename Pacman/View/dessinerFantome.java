package Pacman.View;

import java.awt.Graphics2D;
import Pacman.Data.DataForView;
import Pacman.Logic.EStatutFantome;
import Pacman.Logic.Fantome;

/**
 * 
 * La classe dessinerFantome permet de gérer les sprites des Fantomes.
 * 
 * @author Arthur Pêtre
 */
public class dessinerFantome {
    private static int spriteActuel = 0;

    // Met à jour le numéro de sprite actuel et dessine le Fantome voulu.
    public static void dessiner(Fantome fantome, Graphics2D g2d, DataForView data) {
        dessinerSpriteFantome(fantome, g2d, data);
        updateSprite();
    }

    // Met à jour le numéro de sprite actuel.
    private static void updateSprite() {
        if (spriteActuel == 2) {
            spriteActuel = 1;
        } else {
            spriteActuel += 1;
        }
    }

    // Dessine le Fantome voulu selon son état.
    private static void dessinerSpriteFantome(Fantome fantome, Graphics2D g2d, DataForView data) {
        switch (spriteActuel) {
        case 1:
            switch (fantome.getStatut()) {
            case CHASSEUR:
                g2d.drawImage(data.getFantomesSprites(fantome.getCouleur(), fantome.getDirectionCourante())[0],
                        ((int) fantome.getposX()) * 8 + 4, ((int) fantome.getposY()) * 8 + 24, null);
                break;

            case VULNERABLE:
                g2d.drawImage(data.getVulnerableFantomesSprites()[0], ((int) fantome.getposX()) * 8 + 4,
                        ((int) fantome.getposY()) * 8 + 24, null);
                break;

            case MORT:
                g2d.drawImage(data.getMortFantomeSprites()[0], ((int) fantome.getposX()) * 8 + 4,
                        ((int) fantome.getposY()) * 8 + 24, null);
                break;
            }
            break;

        case 2:
            switch (fantome.getStatut()) {
            case CHASSEUR:
                g2d.drawImage(data.getFantomesSprites(fantome.getCouleur(), fantome.getDirectionCourante())[1],
                        ((int) fantome.getposX()) * 8 + 4, ((int) fantome.getposY()) * 8 + 24, null);
                break;

            case VULNERABLE:
                g2d.drawImage(data.getVulnerableFantomesSprites()[1], ((int) fantome.getposX()) * 8 + 4,
                        ((int) fantome.getposY()) * 8 + 24, null);
                break;

            case MORT:
                g2d.drawImage(data.getMortFantomeSprites()[1], ((int) fantome.getposX()) * 8 + 4,
                        ((int) fantome.getposY()) * 8 + 24, null);
                break;
            }
            break;
        }
    }
}
