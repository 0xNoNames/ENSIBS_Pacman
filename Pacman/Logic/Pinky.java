package Pacman.Logic;

/**
 * 
 * 
 * @author François JULLION
 */
public class Pinky extends Fantome {
    
    /**
     * 
     */
    public Pinky() {
        this.couleur = ECouleur.ROSE;
    }

    /**
     * 
     */
    public void deplacer(Pacman p) {
        this.deplacerVersPacman(p);
    }
}
