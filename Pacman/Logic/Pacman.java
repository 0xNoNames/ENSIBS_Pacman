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
    private double posX;

    /**
     * 
     */
    private double posY;

    /**
     * 
     */
    private int vie;

    /**
     * 
     */
    private EDirection dist_courante;

    /**
     * 
     */
    private EDirection dist_voulue;

    /**
     * 
     *  
     */ 
    public Pacman() {
        this.posX = 0.0;
        this.posY = 0.0;
        this.vie = 3;
    }

    public void meurt() {
        vie --;
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

    public EDirection getDirectionCourante() {
        return this.dist_courante;
    }

    public EDirection getDirectionVoulue() {
        return this.dist_voulue;
    }

    public int getVie() {
        return this.vie;
    }

    public void setDirectionCourante(EDirection d) {
        this.dist_courante = d;
    }

    public void setDirectionVoulue(EDirection d) {
        this.dist_voulue = d;
    }

    public void deplacer() {
        
    }

}
