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


    // ------------------------------------------
    // Méthodes utiles pour les déplacements
    // ------------------------------------------

    /**
     * 
     * @param direction
     * @param posActuelle
     * @return
     */
    protected int[] calculPosDirection(EDirection direction, int[] posActuelle)
    {
        int[] posVoulue = {0,0};
        switch(dirVoulue) {
            case EST:
                posVoulue[0] = posActuelle[0] + 1;
                posVoulue[1] = posActuelle[1];
                break;
            case OUEST:
                posVoulue[0] = posActuelle[0] - 1;
                posVoulue[1] = posActuelle[1];
                break;
            case NORD:
                posVoulue[0] = posActuelle[0];
                posVoulue[1] = posActuelle[1] - 1;
                break;
            case SUD:
                posVoulue[0] = posActuelle[0];
                posVoulue[1] = posActuelle[1] + 1;
                break;
        }

        return posVoulue;
    }

    /**
     * 
     * @param position
     * @return
     */
    protected boolean estPositionPossible(int[] position)
    {
        boolean positionPossible = false;
        if(false) {
            // TODO
        } else if(position[0]<0 || position[0]>=grille.getCases().length || position[1]<0 || position[1]>=grille.getCases()[0].length) {
            positionPossible = true;
        } else if(grille.getCases()[position[0]][position[1]] instanceof Jouable){
            positionPossible = true;        
        }

        return positionPossible;
    }

    /**
     * 
     * @return
     */
    protected int[] getPositionActuelle()
    {
        int[] position = {(int)this.posX, (int)this.posY};
        return position;
    }
}
