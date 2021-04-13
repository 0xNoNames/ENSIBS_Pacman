package Pacman.Logic;

/**
 * Le classe Pinky permet de représenter un des quatres fantomes du jeu
 * 
 * @author François JULLION
 */
public class Pinky extends Fantome {
    
    /**
     * Constructeur de la classe Pinky
     */
    public Pinky(double x, double y) {
        super(x,y);
        this.couleur = ECouleur.ROSE;
        this.dirCourante = EDirection.SUD;
    }

    /**
     * Permet de déplacer Blinky en fonction de pacman
     * @param p, l'entité Pacman
     */
    public void deplacer(Pacman p) {
        this.deplacerVersPacman(p);
    }
}
