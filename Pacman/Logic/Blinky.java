package Pacman.Logic;

/**
 * Le classe Blinky permet de représenter un des quatres fantomes du jeu
 * @author François JULLION
 */
public class Blinky extends Fantome {
    
    /**
     * Constructeur de la classe Blinky
     */
    public Blinky() {
        this.couleur = ECouleur.ROUGE;
    }

    /**
     * Permet de déplacer Blinky en fonction de pacman
     * @param p
     */
    public void deplacer(Pacman p) {
        this.deplacerVersPacman(p);
    }
}
