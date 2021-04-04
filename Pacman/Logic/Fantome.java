package Pacman.Logic;

/**
 * 
 * 
 * @author François JULLION
 */
public class Fantome extends Entite {

    /**
     * 
     */
    private EStatutFantome statut;
    
    /**
     * 
     */
    protected ECouleur couleur;

    public double[] getPosition() {
        double[] res = new double[2];
        res[0] = this.getposX();
        res[1] = this.getposY();
        return res;
    }

    /**
     * 
     * @return
     */
    public EStatutFantome getStatut() {
        return this.statut;
    }

    /**
     * 
     * @return
     */
    public ECouleur getCouleur() {
        return this.couleur;
    }

    /**
     * 
     * @return
     */
    public EDirection getDirectionCourante() {
        return null;
    }

    /**
     * 
     * @return
     */
    public EDirection getDirectionVoulue() {
        return null;
    }

    /**
     * 
     */
    public void setStatut(EStatutFantome s) {
        this.statut = s;
    }

    /**
     * 
     * @return
     */
    public void meurt() {
        this.statut = EStatutFantome.MORT;
    }

    /**
     * 
     * @param p
     * @return
     */
    protected EDirection directionVoulueVersPacman(Pacman p)
    {
        double diffX = p.getposX() - this.getposX();
        double diffY = p.getposY() - this.getposY();
        if(diffX > diffY){
            if(diffX > 0 ) {
                return EDirection.EST;
            } else {
                return EDirection.OUEST;
            }
        } else {
            if(diffY > 0){
                return EDirection.SUD;
            } else {
                return EDirection.NORD;
            }
        }
    }

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

    /**
     * 
     * @param p
     */
    protected void deplacerVersPacman(Pacman p)
    {
        /* Calcul de la direction Voulue */
        int[] posActuelle = getPositionActuelle();
        dirVoulue = directionVoulueVersPacman(p);
        int[] posVoulue = calculPosDirection(dirVoulue, posActuelle);

        /* Test si la direction voulue est possible */
        boolean deplacementVouluPossible = estPositionPossible(posVoulue);

        /* MAJ dirCourante si deplacement voulue possible*/
        boolean deplacementCourantPossible = false;
        if(deplacementVouluPossible) {
            dirCourante = dirVoulue;
        } else {
            /* Sinon on vérifie si la direction courante est possible */
            posVoulue = calculPosDirection(dirCourante, posActuelle);
            deplacementCourantPossible = estPositionPossible(posVoulue); 
        }
        
        /* Si une direction est possible on déplace */
        if(deplacementVouluPossible) {
            this.posX += Partie.d.getVitesseFantome(this.partie.getNiveau(),this.couleur) * (1/Partie.tickParSeconde);
            this.posY += Partie.d.getVitesseFantome(this.partie.getNiveau(),this.couleur) * (1/Partie.tickParSeconde);
        } else if(deplacementCourantPossible) {
            this.posX += Partie.d.getVitesseFantome(this.partie.getNiveau(),this.couleur) * (1/Partie.tickParSeconde);
            this.posY += Partie.d.getVitesseFantome(this.partie.getNiveau(),this.couleur) * (1/Partie.tickParSeconde);
        }
    }
}
