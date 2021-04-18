package Pacman.Logic;

/**
 * Le classe Blinky permet de représenter un des quatres fantomes du jeu
 * 
 * @author François JULLION & Louis-Baptiste SOBOLEWSKI
 */
public class Clyde extends Fantome {
    
    /**
     * Constructeur de la classe Clyde
     */
    public Clyde(double x, double y) {
        super(x,y);
        this.couleur = ECouleur.ORANGE;
    }

    /**
     * Détermine la case cible de Clyde.
     * 
     * @param p Pacman
     * @return cible de Clyde
     */
    private double[] getCible(Pacman p)
    {
        double[] posP = p.getPosition();
        double[] posC = this.getPosition();
        double distPC = distance(posP[0], posP[1], posC[0], posC[1]);

        if (distPC > 8)
        {
            return posP;
        }
        else
        {
            /* si Clyde est trop proche de Pacman, il part se réfugier dans le
            coin sud ouest de la grille */
            double[] cible = {0, this.grille.getCases()[0].length - 1};
            return cible;
        }
    }

    /**
     * Permet de déplacer Clyde en fonction de pacman
     * @param p
     */
    public void deplacer(Pacman p)
    {
        if (this.getStatut() != EStatutFantome.DEBUTPARTIE)
        {
            this.deplacerSelonCible(this.getCible(p));
        }
        else
        {
            double[] scatter = {grille.getCases().length / 4 * 3, 0};
            this.deplacerSelonCible(scatter);
        }
    }
}
