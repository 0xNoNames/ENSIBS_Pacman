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
    private static int offsetX = 0;
    private static int offsetY = 24;

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

    // Met à jour le décalage X et Y des images.
    private static void updateOffsets(Pacman pacman) {
        double[] position = pacman.getPosition();
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

    // Dessine Pacman.
    private static void dessinerSpritePacman(Pacman pacman, Graphics2D g2d, DataForView data) {
        switch (spriteActuel) {
        case 0:
            g2d.drawImage(data.getPacmanSprites(pacman.getDirectionCourante())[0],
                    ((int) pacman.getposX()) * 8 + offsetX, ((int) pacman.getposY()) * 8 + offsetY, null);
            break;

        case 1:
            g2d.drawImage(data.getPacmanSprites(pacman.getDirectionCourante())[1],
                    ((int) pacman.getposX()) * 8 + offsetX, ((int) pacman.getposY()) * 8 + offsetY, null);
            break;
        }
    }

    // Dessine la mort de Pacman.
    private void dessinerMortPacman(Pacman pacman, Graphics2D g2d, DataForView data) {
        // 11 sprites + 1 bouche fermée.
    }
}
