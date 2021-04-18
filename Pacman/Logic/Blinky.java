package Pacman.Logic;

/**
 * Le classe Blinky permet de représenter un des quatres fantomes du jeu
 * 
 * @author François JULLION & Louis-Baptiste SOBOLEWSKI
 */
public class Blinky extends Fantome {
    
    /**
     * Constructeur de la classe Blinky
     */
    public Blinky(double x, double y) {
        super(x,y);
        this.couleur = ECouleur.ROUGE;
    }

    /**
     * Détermine la case cible de Blinky.
     * 
     * @param p Pacman
     * @return cible de Blinky
     */
    private double[] getCible(Pacman p) {
        // la cible de Blinky est la case où se trouve Pacman
        return p.getPosition();
    }

    /**
     * Permet de déplacer Blinky en fonction de pacman
     * @param p, l'entité Pacman
     */
    public void deplacer(Pacman p) {
        this.deplacerSelonCible(this.getCible(p));
    }
}
