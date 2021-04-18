package Pacman.Logic;

/**
 * Permet de représenter toutes les entités présentes dans le jeu
 * 
 * @author François JULLION
 * @inv posX >=0 && posY >=0
 */
public abstract class Entite implements IEntite {

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
     * 
     * @return la direction Courante sous forme d'énumération
     */
    public EDirection getDirectionCourante() {
        return this.dirCourante;
    }

    /**
     * Permet de définir la direction courante de l'entité
     * 
     * @param d, la direction courante souhaitée
     */
    public void setDirectionCourante(EDirection d) {
        this.dirCourante = d;
    }

    /**
     * Permet de récupérer la direction Voulue
     * 
     * @return la direction Voulue sous forme d'énumération
     */
    public EDirection getDirectionVoulue() {
        return this.dirVoulue;
    }

    /**
     * Permet de définir la direction voulue de l'entité
     * 
     * @param d, la direction voulue souhaitée
     */
    public void setDirectionVoulue(EDirection d) {
        this.dirVoulue = d;
    }

    /**
     * Permet de récupérer la coordonnée en X de l'entité
     * 
     * @return la coordonnées X en double de l'entité
     */
    public double getposX() {
        return this.posX;
    }

    /**
     * Permet de récupérer la coordonnée en Y de l'entité
     * 
     * @return la coordonnées Y en double de l'entité
     */
    public double getposY() {
        return this.posY;
    }

    /**
     * Permet de définir la coordonnée X de l'entité
     * 
     * @param x, la futur coordonnée X de l'entité
     * @pre x >= 0
     */
    public void setPosX(double x) {
        this.posX = x;
    }

    /**
     * Permet de définir la coordonnée Y de l'entité
     * 
     * @param y, la futur coordonnée Y de l'entité
     * @pre y >= 0
     */
    public void setPosY(double y) {
        this.posY = y;
    }

    /**
     * Permet de définir la grille sur laquelle l'entité se situe
     * 
     * @param g, une grille de jeu
     * @pre g != null
     */
    public void setGrille(Grille g) {
        this.grille = g;
    }

    /**
     * Permet de définir la partie dans laquelle l'entité se situe
     * 
     * @param p, une partie de jeu
     * @pre p != null
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
     * Permet de calculer la future position d'une entité selon une direction et la
     * position actuelle
     * 
     * @param direction,   une direction de type enumération
     * @param posActuelle, tableau d'entiers représentant les coordonnées actuelles
     *                     de l'entité dans la grille
     * @return les coordonnées future de l'entité
     * @post posVoulue[0] == posActuelle[0]+1 || posVoulue[0] == posActuelle[0]-1 ||
     *       posVoulue[0] == posActuelle[0]
     * @post posVoulue[1] == posActuelle[1]+1 || posVoulue[1] == posActuelle[1]-11
     *       || posVoulue[1] == posActuelle[1]
     */
    protected int[] calculPosDirection(EDirection direction, int[] posActuelle) {
        int[] posVoulue = { 0, 0 };
        switch (direction) {
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
     * 
     * @param position, tableau d'entiers représentant les coordonnées de l'entité
     *                  dans la grille
     * @return vrai si position possible, faux sinon
     */
    protected boolean estPositionPossible(int[] position) {
        boolean positionPossible = false;
        if (position[0] < 0 || position[0] >= grille.getCases().length || position[1] < 0
                || position[1] >= grille.getCases()[0].length) {
            positionPossible = true;
        } else if (grille.getCases()[position[0]][position[1]] instanceof Jouable) {
            positionPossible = true;
        }
        return positionPossible;
    }

    /**
     * Permet de récupérer la position actuelle de l'entité dans la grille
     * 
     * @return tableau d'entiers contenant la position actuelle
     */
    protected int[] getPositionI() {
        int[] position = { (int) this.posX, (int) this.posY };
        return position;
    }

    /**
     * Vérifie que l'entité est au milieu d'une intersection
     * 
     * @return booléen qui indique si l'entité est au milieu d'une intersection
     * @pre vitesse > 0
     */
    protected boolean estMomentChangementDir(double vitesse) {
        double arrondi = vitesse / Partie.tickParSeconde;
        if (dirVoulue == EDirection.EST || dirVoulue == EDirection.OUEST) {
            // il faut qu'on soit à x = ~.5 ± arrondi pour changer de dir
            double calcul = this.posX - ((int) this.posX);
            if (calcul <= arrondi || calcul >= 1 - arrondi) {
                return true;
            }
        } else // NORD ou SUD
        {
            // il faut qu'on soit à y = ~.5 ± arrondi pour changer de dir
            double calcul = this.posY - ((int) this.posY);
            if (calcul <= arrondi || calcul >= 1 - arrondi) {
                return true;
            }
        }

        return false;
    }

    /**
     * Applique le changement de position après que les directions aient été
     * déterminées
     */
    protected void effectuerDeplacement() {
        double distDeplacement = getVitesse() / Partie.tickParSeconde;

        switch (dirCourante) {
        case NORD:
            this.posX = ((int) this.posX) + 0.0;
            this.posY -= distDeplacement;
            break;
        case SUD:
            this.posX = ((int) this.posX) + 0.0;
            this.posY += distDeplacement;
            break;
        case OUEST:
            this.posX -= distDeplacement;
            this.posY = ((int) this.posY) + 0.0;
            // passage du tunnel
            if (this.posX < 0 && getPositionI()[1] == 14) {
                System.out.println("pouet");
                this.posX += 28;
            }
            break;
        case EST:
            this.posX += distDeplacement;
            this.posY = ((int) this.posY) + 0.0;
            // passage du tunnel
            if (this.posX > 28 && getPositionI()[1] == 14) {
                System.out.println("pouet");
                this.posX -= 28;
            }
            break;
        }
    }

    public abstract double getVitesse();
}
