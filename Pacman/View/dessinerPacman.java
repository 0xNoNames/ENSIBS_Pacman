package Pacman.View;

import java.awt.Graphics2D;
import Pacman.Data.DataForView;
import Pacman.Logic.EDirection;
import Pacman.Logic.Pacman;

/**
 * La classe dessinerPacman permet de gérer les sprites de Pacman.
 * 
 * @author Arthur Pêtre
 */
public class dessinerPacman {
    private static int spriteActuel = 0;
    private static int offsetX = -4;
    private static int offsetY = 24;
    private static int waitSprite = 0;
    private static int spriteMort = 0;
    private static double[] anciennePos = { 0.0, 0.0 };

    /**
     * Met à jour le numéro de sprite actuel et dessine Pacman.
     * 
     * @param pacman objet Pacman que l'on va dessiner.
     * @param g2d    objet Graphics2D permettant de mettre à jour les sprites.
     * @param data   permet de récuperer les sprites depuis Data.
     */
    public static void dessiner(Pacman pacman, Graphics2D g2d, DataForView data) {
        dessinerSpritePacman(pacman, g2d, data);

        // Si pacman est en mouvement alors on change de sprite.
        if (estMouvement(pacman)) {
            // Permet de ne pas avoir trop de mise à jour des sprites.
            if (waitSprite == 3) {
                // Mise à jour du sprite actuel à selectionner.
                updateSprite();
                waitSprite = 0;
            } else {
                waitSprite++;
            }
        }

        // Fixe la position actuelle comme l'ancienne postion de pacman;
        anciennePos[0] = pacman.getPosition()[0];
        anciennePos[1] = pacman.getPosition()[1];
    }

    /**
     * Met à jour le numéro de sprite actuel.
     */
    private static void updateSprite() {
        if (spriteActuel == 1) {
            spriteActuel = 0;
        } else {
            spriteActuel = 1;
        }
    }

    /**
     * Retourne vrai ou faux selon si Pacman est en déplacement.
     * 
     * @param pacman objet Pacman que l'on va dessiner.
     * @return vrai si pacman est en mouvement, faux sinon.
     */
    private static boolean estMouvement(Pacman pacman) {
        return !(Double.compare(pacman.getPosition()[0], anciennePos[0]) == 0
                && Double.compare(pacman.getPosition()[1], anciennePos[1]) == 0);
    }

    /**
     * Dessine Pacman selon sa direction et son sprite actuel.
     * 
     * @param pacman Pacman que l'on va dessiner.
     * @param g2d    objet Graphics2D permettant de mettre à jour les sprites.
     * @param data   permet de récuperer les sprites depuis Data.
     */
    private static void dessinerSpritePacman(Pacman pacman, Graphics2D g2d, DataForView data) {
        switch (spriteActuel) {
        case 0:
            g2d.drawImage(data.getPacmanSprites(pacman.getDirectionCourante())[0],
                    (int) (pacman.getposX() * 8) + offsetX, (int) (pacman.getposY() * 8) + offsetY, null);
            break;

        case 1:
            g2d.drawImage(data.getPacmanSprites(pacman.getDirectionCourante())[1],
                    (int) (pacman.getposX() * 8) + offsetX, (int) (pacman.getposY() * 8) + offsetY, null);
            break;
        }
    }

    /**
     * Dessine Pacman tout rond pour l'animation de début de partie.
     * 
     * @param pacman Pacman que l'on va dessiner.
     * @param g2d    objet Graphics2D permettant de mettre à jour les sprites.
     * @param data   permet de récuperer les sprites depuis Data.
     */
    public static void dessinerPacmanRond(Graphics2D g2d, DataForView data) {
        g2d.drawImage(data.getPacmanSprites(EDirection.OUEST)[2], 105, 208, null);
    }

    /**
     * Dessine l'animation de mort de Pacman.
     * 
     * @param pacman Pacman que l'on va dessiner.
     * @param g2d    objet Graphics2D permettant de mettre à jour les sprites.
     * @param data   permet de récuperer les sprites depuis Data.
     */
    public static void dessinerMortPacman(Pacman pacman, Graphics2D g2d, DataForView data) {
        if (spriteMort < 11) {
            g2d.drawImage(data.getMortPacmanSprites()[spriteMort], (int) (pacman.getposX() * 8) + offsetX,
                    (int) (pacman.getposY() * 8) + offsetY, null);
        }
        if (waitSprite == 5) {
            // Mise à jour du sprite actuel à selectionner.
            spriteMort++;
            waitSprite = 0;
        } else {
            waitSprite++;
        }
    }

    /**
     * Permet de réinitialiser la mort de pacman.
     */
    public static void resetSpriteMort() {
        spriteMort = 0;
    }
}
