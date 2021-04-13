package Pacman.Logic;

/**
 * Le classe Blinky permet de représenter un des quatres fantomes du jeu
 * 
 * @author François JULLION
 */
public class Blinky extends Fantome {
    
    /**
     * Constructeur de la classe Blinky
     */
    public Blinky(double x, double y) {
        super(x,y);
        this.couleur = ECouleur.ROUGE;
        this.dirCourante = EDirection.OUEST;
    }

    /**
     * Permet de déplacer Blinky en fonction de pacman
     * @param p, l'entité Pacman
     */
    public void deplacer(Pacman p) {
        this.deplacerVersPacman(p);
    }
}
