package Pacman.Logic;

/**
 * Le classe Inky permet de représenter un des quatres fantomes du jeu
 * 
 * @author François JULLION & Louis-Baptiste SOBOLEWSKI
 */
public class Inky extends Fantome {
    
    /**
     * Constructeur de la classe Clyde
     */
    public Inky(double x, double y) {
        super(x,y);
        this.couleur = ECouleur.CYAN;
    }

    /**
     * Détermine la case cible d'Inky.
     * @param p Pacman
     * @param b Blinky
     * @return cible d'Inky
     */
    private double[] getCible(Pacman p, Blinky b) {
        // la cible d'Inky est Pacman - (diff entre Pacman et Blinky)
        double[] posP = p.getPosition();
        double[] posB = b.getPosition();
        double[] diffPB = {posP[0] - posB[0], posP[1] - posB[1]};
        double[] cible = {posP[0] - diffPB[0], posP[1] - diffPB[1]};
        return cible;
    }

    /**
     * Permet de déplacer Inky en fonction de pacman
     * @param p, l'entité Pacman
     */
    public void deplacer(Pacman p) {
        this.deplacerSelonCible(getCible(p, this.grille.getBlinky()));
    }
}
