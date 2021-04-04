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
     * Permet de récupérer la coordonnée en X de l'entité
     * @return
     */
    public double getposX() {
        return this.posX;
    }

    /**
     * Permet de récupérer la coordonnée en Y de l'entité
     * @return
     */
    public double getposY() {
        return this.posY;
    }

    /**
     * Permet de définir la coordonnée X de l'entité
     * @param x, la futur coordonnée X de l'entité
     */
    public void setPosX(double x) {
        this.posX = x;
    }

    /**
     * Permet de définir la coordonnée Y de l'entité
     * @param y, la futur coordonnée Y de l'entité
     */
    public void setPosY(double y) {
        this.posY = y;
    }

    /**
     * Permet de définir la grille sur laquelle l'entité se situe
     * @param g, une grille de jeu
     */
    public void setGrille(Grille g) {
        this.grille = g;
    }

    /**
     * Permet de définir la partie dans laquelle l'entité se situe
     * @param p, une partie de jeu
     */
    public void setPartie(Partie p) {
        this.partie = p;
    }

    /**
     * Fonction abstraite permettant d'actionner la mort d'une entité
     */
    public abstract void meurt();


    // ------------------------------------------
    // Méthodes utiles pour les déplacements
    // ------------------------------------------

    /**
     * Permet de calculer la future position d'une entité selon une direction et la position actuelle
     * @param direction, une direction de type enumération
     * @param posActuelle, tableau d'entiers représentant les coordonnées actuelles de l'entité dans la grille
     * @return les coordonnées future de l'entité
     */
    protected int[] calculPosDirection(EDirection direction, int[] posActuelle) {
        int[] posVoulue = {0,0};
        switch(direction) {
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
     * Permet de savoir si la position est possible
     * @param position, tableau  d'entiers représentant les coordonnées de l'entité dans la grille
     * @return vrai si position possible, faux sinon
     */
    protected boolean estPositionPossible(int[] position) {
        boolean positionPossible = false;
        if(position[0]<0 || position[0]>=grille.getCases().length || position[1]<0 || position[1]>=grille.getCases()[0].length) {
            positionPossible = true;
        } else if(grille.getCases()[position[0]][position[1]] instanceof Jouable){
            positionPossible = true;        
        }
        return positionPossible;
    }

    /**
     * Permet de récupérer la position actuelle de l'entité dans la grille
     * @return tableau d'entiers contenant la position actuelle
     */
    protected int[] getPositionActuelle(){
        int[] position = {(int)this.posX, (int)this.posY};
        return position;
    }
}
