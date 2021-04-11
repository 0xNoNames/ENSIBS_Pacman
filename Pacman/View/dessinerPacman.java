package Pacman.View;

import java.awt.Graphics2D;
import Pacman.Data.DataForView;
import Pacman.Logic.Pacman;

/**
 * La classe dessinerPacman permet de gérer les sprites de Pacman.
 * 
 * @author Arthur Pêtre
 */
public class dessinerPacman {
    private static int spriteActuel;

    // Met à jour le numéro de sprite actuel et dessine Pacman.
    public static void dessiner(Pacman pacman, Graphics2D g2d, DataForView data) {
        dessinerSpritePacman(pacman, g2d, data);
        updateSprite();
    }

    // Met à jour le numéro de sprite actuel.
    private static void updateSprite() {
        if (spriteActuel == 3) {
            spriteActuel = 1;
        } else {
            spriteActuel += 1;
        }
    }

    // Dessine Pacman.
    private static void dessinerSpritePacman(Pacman pacman, Graphics2D g2d, DataForView data) {
        switch (spriteActuel) {
        case 1:
            g2d.drawImage(data.getPacmanSprites(pacman.getDirectionCourante())[0], (int) pacman.getposX(),
                    (int) pacman.getposY(), null);
            break;

        case 2:
            g2d.drawImage(data.getPacmanSprites(pacman.getDirectionCourante())[1], (int) pacman.getposX(),
                    (int) pacman.getposY(), null);
            break;

        case 3:
            g2d.drawImage(data.getPacmanSprites(pacman.getDirectionCourante())[2], (int) pacman.getposX(),
                    (int) pacman.getposY(), null);
            break;
        }
    }

    // Dessine la mort de Pacman.
    private void dessinerMortPacman(Pacman pacman, Graphics2D g2d, DataForView data) {
        // 11 sprites + 1 bouche fermée.
    }
}
