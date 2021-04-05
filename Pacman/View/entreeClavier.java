package Pacman.View;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * La classe Input permet de gérer les entrées utilisateur.
 * 
 * @author Arthur Pêtre
 */
public class entreeClavier extends KeyAdapter {
    boolean inGame;

    // Constructeur de la classe.
    public entreeClavier() {
        this.inGame = true;
    }

    // Méthode gérant la touche actuellement appuyée.
    @Override
    public void keyPressed(KeyEvent e) {

        int touche = e.getKeyCode();

        if (this.inGame) {
            if (touche == KeyEvent.VK_LEFT) {
                // direction souhaité -> gauche.
                System.out.println("Gauche");
            } else if (touche == KeyEvent.VK_RIGHT) {
                System.out.println("Droite");
            } else if (touche == KeyEvent.VK_UP) {
                System.out.println("Haut");
            } else if (touche == KeyEvent.VK_DOWN) {
                System.out.println("Bas");
            } else if (touche == KeyEvent.VK_S) {
                System.out.println("S");
                // if en cours -> pause sinon start.
            }
        } else {
            if (touche == KeyEvent.VK_SPACE) {
                // start la game (init) avec espace.
            }
        }
    }
}