package Pacman.Logic;

/**
 * 
 * 
 * @author François JULLION
 */
public abstract class Entite implements IEntite{
    
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

    public abstract void meurt();

}
