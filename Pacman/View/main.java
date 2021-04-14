package Pacman.View;

import Pacman.Logic.Partie;


public class main {

    public static void main(String[] args) {

        // Ajoute l'objet Partie venant de Logic.
        Partie partie = new Partie();

        // Ajout l'objet fenêtre lié à la Partie en cours.
        Fenetre fenetre = new Fenetre(partie);

        // Affiche la fenêtre principale.
        fenetre.setVisible(true);

    }
}
