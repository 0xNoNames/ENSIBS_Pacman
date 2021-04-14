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

    // Getter de l'état de la partie (si l'utilisateur a mis pause ou non).
    public boolean getinGame() {
        return this.inGame;
    }

    // Méthode gérant la touche actuellement appuyée.
    @Override
    public void keyPressed(KeyEvent e) {

        int touche = e.getKeyCode();

        // Si l'utilisateur appuis sur 'espace', la partie démarre/se met en pause.
        if (touche == KeyEvent.VK_SPACE) {
            if (!inGame) {
                this.inGame = true;
            } else {
                this.inGame = false;
            }
        }

        // Si la partie est en cours, on récupère les entrées flèches directionnelles
        // et/ou zqsd
        if (this.inGame) {
            switch (touche) {
            case KeyEvent.VK_UP:
                grille.getPacman().setDirectionVoulue(EDirection.NORD);
                break;
            case KeyEvent.VK_Z:
                grille.getPacman().setDirectionVoulue(EDirection.NORD);
                break;
            case KeyEvent.VK_LEFT:
                grille.getPacman().setDirectionVoulue(EDirection.OUEST);
                break;
            case KeyEvent.VK_Q:
                grille.getPacman().setDirectionVoulue(EDirection.OUEST);
                break;
            case KeyEvent.VK_DOWN:
                grille.getPacman().setDirectionVoulue(EDirection.SUD);
                break;
            case KeyEvent.VK_S:
                grille.getPacman().setDirectionVoulue(EDirection.SUD);
                break;
            case KeyEvent.VK_RIGHT:
                grille.getPacman().setDirectionVoulue(EDirection.EST);
                break;
            case KeyEvent.VK_D:
                grille.getPacman().setDirectionVoulue(EDirection.EST);
                break;
            }
        }
    }
}