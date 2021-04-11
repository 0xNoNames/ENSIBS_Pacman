package Pacman.View;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Pacman.Logic.EDirection;
import Pacman.Logic.Grille;

/**
 * La classe Input permet de gérer les entrées utilisateur.
 * 
 * @author Arthur Pêtre
 */
public class entreeClavier extends KeyAdapter {
    boolean inGame;
    Grille grille;

    // Constructeur de la classe.
    public entreeClavier(Grille grille) {
        this.inGame = false;
        this.grille = grille;
    }

    // Méthode gérant la touche actuellement appuyée.
    @Override
    public void keyPressed(KeyEvent e) {

        int touche = e.getKeyCode();

        if (this.inGame) {
            if (touche == KeyEvent.VK_LEFT) {
                // grille.getPacman().setDirectionVoulue(EDirection.OUEST);
                grille.getPacman().setDirectionCourante(EDirection.OUEST);

                System.out.println("Gauche");
            } else if (touche == KeyEvent.VK_RIGHT) {
                // grille.getPacman().setDirectionVoulue(EDirection.EST);
                grille.getPacman().setDirectionCourante(EDirection.EST);
                System.out.println("Droite");
            } else if (touche == KeyEvent.VK_UP) {
                // grille.getPacman().setDirectionVoulue(EDirection.NORD);
                grille.getPacman().setDirectionCourante(EDirection.NORD);
                System.out.println("Haut");
            } else if (touche == KeyEvent.VK_DOWN) {
                // grille.getPacman().setDirectionVoulue(EDirection.SUD);
                grille.getPacman().setDirectionCourante(EDirection.SUD);
                System.out.println("Bas");
            }
        }
        if (touche == KeyEvent.VK_S) {
            if (!inGame) {
                System.out.println("Reprise");
                this.inGame = true;
            } else {
                System.out.println("Pause");
                this.inGame = false;
            }
            // start la game (init) avec espace.
        }
    }
}