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
    protected double posX;

    /**
     * 
     */
    protected double posY;

    /**
     * 
     */
    protected EDirection dirCourante;

    /**
     * 
     */
    protected EDirection dirVoulue;

    /**
     * 
     */
    protected Grille grille;

    /**
     * 
     * @return
     */
    public EDirection getDirectionCourante() {
        return this.dirCourante;
    }

    /**
     * 
     * @return
     */
    public EDirection getDirectionVoulue() {
        return this.dirVoulue;
    }

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

    /**
     * 
     * @param g
     */
    public void setGrille(Grille g) {
        this.grille = g;
    }

    public abstract void meurt();

}
