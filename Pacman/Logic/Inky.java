package Pacman.Logic;

/**
 * 
 * 
 * @author François JULLION
 */
public class Inky extends Fantome {
    
    /**
     * 
     */
    public Inky() {
        this.couleur = ECouleur.CYAN;
    }

    public void deplacer(Pacman p) {
        this.deplacerVersPacman(p);
    }
}
