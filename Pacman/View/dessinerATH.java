package Pacman.View;

import java.awt.Graphics2D;
import Pacman.Data.DataForView;
import Pacman.Logic.EDirection;
import Pacman.Logic.Partie;

public class dessinerATH {

    // Le score, les vies ainsi que le GAME OVER ou READY
    public static void dessiner(Partie partie, Graphics2D g2d, DataForView data, Boolean inGame) {
        dessinerVies(partie, g2d, data);
        dessinerEtatPartie(partie, g2d, data, inGame);
    }

    private static void dessinerVies(Partie partie, Graphics2D g2d, DataForView data) {
        for (int i = 1; i <= partie.getVies(); i++) {
            g2d.drawImage(data.getPacmanSprites(EDirection.OUEST)[0], 18 * i, 278, null);
        }
    }

    /**
     * Affiche les éléments "READY" et "GAME OVER".
     * 
     * @param partie
     * @param g2d
     * @param data
     */
    private static void dessinerEtatPartie(Partie partie, Graphics2D g2d, DataForView data, Boolean inGame) {
        if (!inGame) {
            g2d.drawImage(data.getRGOSprite()[0], 89, 164, null);
        }
    }

    private static void dessinerScore(Partie partie, Graphics2D g2d, DataForView data) {
        // En haut de l'écran.
    }

    private static void dessinerNiveau(Partie partie, Graphics2D g2d, DataForView data) {
        // Affiche vers la gauche et max 6 fruits
        // cerise -> fraise -> orange -> orange -> pomme -> pomme -> ananas -> ananas
        // (vert) -> Galaxian -> Galaxian -> Cloche -> Cloche -> full clé
    }
}
