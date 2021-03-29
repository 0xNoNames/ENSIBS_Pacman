package Pacman.Logic;

/**
 * 
 * 
 * @author François JULLION
 */
public abstract class Entite {
    
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
    private double vitesseDeplacement;

    /**
     * 
     * @return
     */
    public double getposX() {
        return this.posX;
    }

    /**
     * 
     * @return
     */
    public double getposY() {
        return this.posY;
    }

    public abstract double getvitesseDeplacement();

    public abstract void meurt();

}
