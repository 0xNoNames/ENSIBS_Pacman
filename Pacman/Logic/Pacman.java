package Pacman.Logic;

/**
 * 
 * 
 * @author François JULLION
 */
public class Pacman extends Entite {
    

    /**
     * 
     */
    private int vies;

    /**
     * 
     *  
     */ 
    public Pacman() {
        this.posX = 0.0;
        this.posY = 0.0;
        this.vies = 3;
    }

    public void meurt() {
        vies --;
    }

    public double[] getPosition() {
        double[] res = new double[2];
        res[0] = this.getposX();
        res[1] = this.getposY();
        return res;
    }

    public EStatutFantome getStatut() {
        return null;
    }

    public ECouleur getCouleur() {
        return null;
    }

    public int getVie() {
        return this.vies;
    }

    public void deplacer() {
        
    }

}
