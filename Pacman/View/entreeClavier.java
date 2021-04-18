package Pacman.View;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Pacman.Logic.EDirection;
import Pacman.Logic.EStatutPartie;
import Pacman.Logic.Grille;
import Pacman.Logic.Partie;

/**
 * La classe Input permet de gérer les entrées utilisateur.
 * 
 * @author Arthur Pêtre
 */
public class entreeClavier extends KeyAdapter {
    boolean inGame;
    Grille grille;
    Partie partie;

    /**
     * Constructeur de la classe.
     * 
     * @param grille qui va permettre de modifier les déplacements de pacman selon
     *               l'entrée utilisateur.
     */
    public entreeClavier(Partie partie) {
        this.partie = partie;
        this.grille = partie.getGrille();
    }

    /**
     * Redéfinition nécéssaire de la méthode keyPressed de KeyAdapter. Elle permet
     * de gérer la touche actuellement appuyée.
     * 
     * @param e évènement touche actuellement pressé.
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int touche = e.getKeyCode();

        // Si l'utilisateur appuis sur 'espace', la partie démarre/se met en pause.
        if (touche == KeyEvent.VK_SPACE) {
            if (this.partie.getEtatPartie() == EStatutPartie.EN_COURS) {
                this.partie.setEtatPartie(EStatutPartie.EN_PAUSE);
            } else {
                this.partie.setEtatPartie(EStatutPartie.EN_COURS);
            }
        }

        // Si la partie est en cours, on récupère les entrées flèches directionnelles
        // et/ou zqsd
        if (this.partie.getEtatPartie() == EStatutPartie.EN_COURS) {
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