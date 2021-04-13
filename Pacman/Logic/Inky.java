package Pacman.Logic;

/**
 * Le classe Inky permet de représenter un des quatres fantomes du jeu
 * 
 * @author François JULLION
 */
public class Inky extends Fantome {
    
    /**
     * Constructeur de la classe Clyde
     */
    public Inky(double x, double y) {
        super(x,y);
        this.couleur = ECouleur.CYAN;
        this.dirCourante = EDirection.NORD;
    }

    /**
     * Permet de déplacer Inky en fonction de pacman
     * @param p, l'entité Pacman
     */
    public void deplacer(Pacman p) {
        this.deplacerVersPacman(p);
    }
}
