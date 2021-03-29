package Pacman.Logic;

import Pacman.Data.DataForLogic;

/**
 * 
 * 
 * @author François JULLION
 */
public class Pacman extends Entite {
    
    /**
     * 
     */
    private DataForLogic d;
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
     */
    private int vie;

    public Pacman() {
        this.posX = 0.0;
        this.posY = 0.0;
        this.vitesseDeplacement = 0.0;;
        this.vie = 3;
    }

    public void meurt() {
        vie --;
    }
    

}
