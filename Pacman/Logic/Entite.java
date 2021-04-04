package Pacman.Logic;

/**
 * Permet de représenter toutes les entités présentes dans le jeu
 * 
 * @author François JULLION
 */
public abstract class Entite implements IEntite{
    
    /**
     * Coordonnée en X de l'entité
     */
    protected double posX;

    /**
     * Coordonnée en Y de l'entité
     */
    protected double posY;

    /**
     * Direction courante de l'entité
     */
    protected EDirection dirCourante;

    /**
     * Direction voulue de l'entité
     */
    protected EDirection dirVoulue;

    /**
     * Grille de jeu
     */
    protected Grille grille;

    /**
     * Partie dans laquelle l'entité se trouve
     */
    protected Partie partie;

    /**
     * Permet de récupérer la direction courante
     * @return la direction Courante sous forme d'énumération
     */
    public EDirection getDirectionCourante() {
        return this.dirCourante;
    }

    /**
     * Permet de récupérer la direction Voulue
     * @return la direction Voulue sous forme d'énumération
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

    public void setPartie(Partie p) {
        this.partie = p;
    }
    public abstract void meurt();

}
