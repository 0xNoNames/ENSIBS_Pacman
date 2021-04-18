package Pacman.Logic;

/**
 * Le classe Pinky permet de représenter un des quatres fantomes du jeu
 * 
 * @author François JULLION & Louis-Baptiste SOBOLEWSKI
 * @inv this.couleur == ECouleur.ROSE
 */
public class Pinky extends Fantome {
    
    /**
     * Constructeur de la classe Pinky
     */
    public Pinky(double x, double y) {
        super(x,y);
        this.couleur = ECouleur.ROSE;
    }

    /**
     * Détemrine la case cible de Pinky.
     * 
     * @param p Pacman
     * @return cible de Pinky
     * @post cible[0] >= 0 && cible[1] >= 0
     */
    private double[] getCible(Pacman p) {
        double[] posP = p.getPosition();
        double[] cible = {posP[0], posP[1]};

        switch (p.getDirectionCourante())
        {
            case NORD:
                cible[1] -= 4;
            case SUD:
                cible[1] += 4;
            case OUEST:
                cible[0] -= 4;
            case EST:
                cible[0] += 4;
        }

        return cible;
    }

    /**
     * Permet de déplacer Blinky en fonction de pacman
     * @param p, l'entité Pacman
     */
    public void deplacer(Pacman p) {
        switch (this.getStatut())
        {
            case CHASSEUR:
                this.deplacerSelonCible(this.getCible(p));
                break;
            case DEBUTPARTIE:
                this.setPosX(13.5);
                this.setPosY(11.5);
                this.setStatut(EStatutFantome.CHASSEUR);
                break;
            case VULNERABLE:
                this.deplacerAleatoire();
                break;
            case MORT:
                if (deplacementMort())
                {
                    setStatut(EStatutFantome.CHASSEUR);
                }
                break;
        }
    }
}
