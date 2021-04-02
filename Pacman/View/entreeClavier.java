package Pacman.View;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

/**
 * La classe Input permet de gérer les entrées utilisateur.
 * 
 * @author Arthur Pêtre
 */
public class entreeClavier extends KeyAdapter {
    boolean inGame;

    public entreeClavier() {
        this.inGame = true;
    }

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
            } else if (touche == KeyEvent.VK_ESCAPE) {
                System.out.println("Echap");
                // if en cours -> pause sinon start.
            }
        } else {
            if (touche == KeyEvent.VK_ENTER) {
                // start la game (init).
            }
        }
    }

        // JFrame frame = new JFrame("FrameDemo");

        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // frame.pack();

        // frame.setVisible(true);

        // System.out.println("Démarrage");
        // frame.addKeyListener(new entreeClavier());
        // // addKeyListener(new entreeClavier());
}