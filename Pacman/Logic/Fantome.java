package Pacman.Logic;

/**
 * 
 * 
 * @author François JULLION
 */
public class Fantome extends Entite {

    /**
     * 
     */
    private EStatutFantome statut;
    
    /**
     * 
     */
    protected ECouleur couleur;

    public double[] getPosition() {
        double[] res = new double[2];
        res[0] = this.getposX();
        res[1] = this.getposY();
        return res;
    }

    /**
     * 
     * @return
     */
    public EStatutFantome getStatut() {
        return this.statut;
    }

    /**
     * 
     * @return
     */
    public ECouleur getCouleur() {
        return this.couleur;
    }

    /**
     * 
     * @return
     */
    public EDirection getDirectionCourante() {
        return null;
    }

    /**
     * 
     * @return
     */
    public EDirection getDirectionVoulue() {
        return null;
    }

    /**
     * 
     * @return
     */
    public void meurt() {
        this.statut = EStatutFantome.MORT;
    }
}
