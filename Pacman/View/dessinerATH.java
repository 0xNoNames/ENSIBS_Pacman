package Pacman.View;

import java.awt.Graphics2D;
import Pacman.Data.DataForView;
import Pacman.Logic.Partie;

public class dessinerATH {

    // Le score, les vies ainsi que le GAME OVER ou READY
    public static void dessiner(Partie partie, Graphics2D g2d, DataForView data) {
        dessinerVies(partie, g2d, data);
    }

    private static void dessinerVies(Partie partie, Graphics2D g2d, DataForView data) {
        // Max 5 vies.
    }

    private static void dessinerEtatPartie(Partie partie, Graphics2D g2d, DataForView data) {

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
