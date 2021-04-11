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
    private static int spriteActuel = 0;

    // Met à jour le numéro de sprite actuel et dessine Pacman.
    public static void dessiner(Pacman pacman, Graphics2D g2d, DataForView data) {
        dessinerSpritePacman(pacman, g2d, data);
        updateSprite();
    }

    // Met à jour le numéro de sprite actuel.
    private static void updateSprite() {
        if (spriteActuel == 1) {
            spriteActuel = 0;
        } else {
            spriteActuel = 1;
        }
    }

    // Dessine Pacman.
    private static void dessinerSpritePacman(Pacman pacman, Graphics2D g2d, DataForView data) {
        switch (spriteActuel) {
        case 0:
            g2d.drawImage(data.getPacmanSprites(pacman.getDirectionCourante())[0], ((int) pacman.getposX()) * 8 + 4,
                    ((int) pacman.getposY()) * 8 + 24, null);
            break;

        case 1:
            g2d.drawImage(data.getPacmanSprites(pacman.getDirectionCourante())[1], (int) (pacman.getposX() + 4),
                    (int) (pacman.getposY() + 32), null);
            break;
        }
    }

    // Dessine la mort de Pacman.
    private void dessinerMortPacman(Pacman pacman, Graphics2D g2d, DataForView data) {
        // 11 sprites + 1 bouche fermée.
    }
}
