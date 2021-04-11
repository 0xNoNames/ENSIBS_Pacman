package Pacman.View;

import Pacman.Logic.Partie;

public class main {
    // entreeClavier keyboard;

    // Test des fonctions
    public static void main(String[] args) {
        System.out.println("Démarrage...");
        Partie partie = new Partie();
        Fenetre fenetre = new Fenetre(partie);

        fenetre.setVisible(true);

    }
}
