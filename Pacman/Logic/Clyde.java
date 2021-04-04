package Pacman.Logic;

/**
 * Le classe Blinky permet de représenter un des quatres fantomes du jeu
 * 
 * @author François JULLION
 */
public class Clyde extends Fantome {
    
    /**
     * Constructeur de la classe Clyde
     */
    public Clyde() {
        this.couleur = ECouleur.ORANGE;
    }

    /**
     * Permet de déplacer aléatoirement Clyde
     */
    public void deplacer() {
        // TODO choisir une directionvoulue aléatoirement tous les x ticks
    }
}
