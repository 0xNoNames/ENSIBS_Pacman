package Pacman.Logic;

/**
 * Classe représentant l'entité Fantome
 * 
 * @author François JULLION
 */
public class Fantome extends Entite {

    /**
     * Variable représentant le statut du fantome
     */
    private EStatutFantome statut;
    
    /**
     * Variable représentant la couleur du fantome
     */
    protected ECouleur couleur;

    /**
     * Constructeur de la classe Fantome
     * @param x, la coordonnée en x
     * @param y, la coordonnée en y
     */
    public Fantome(double x, double y){
        this.posX = x;
        this.posY = y;
        this.statut = EStatutFantome.CHASSEUR;
    }

    /**
     * Permet de récupérer les coordonnées du fantome
     * @return tableau de double, en [0] x et en [1] y
     */
    public double[] getPosition() {
        double[] res = new double[2];
        res[0] = this.getposX();
        res[1] = this.getposY();
        return res;
    }

    /**
     * Permet de récupérer le statut du fantome
     * @return le statut du fantome sous forme d'énumération
     */
    public EStatutFantome getStatut() {
        return this.statut;
    }

    /**
     * Permet de définir le statut actuel du fantome
     * @param s, un statut de type Enumeration
     */
    public void setStatut(EStatutFantome s) {
        this.statut = s;
    }

    /**
     * Permet de récupérer la couleur du fantom
     * @return la couleur du fantome
     */
    public ECouleur getCouleur() {
        return this.couleur;
    }

    /**
     * Permet de faire mourir le fantome et de le ramener à sa position initiale
     */
    public void meurt() {
        this.statut = EStatutFantome.MORT;
        Pacman p = new Pacman();
        p.posX = Partie.d.getPositionInitialePacman()[0];
        p.posY = Partie.d.getPositionInitialePacman()[1];
        while(this.posX != p.posX && this.posY != p.posY) {
            directionVoulueVersPacman(p);
        }
        this.statut = EStatutFantome.CHASSEUR;
    }

    /**
     * Permet de définir la direction voulue afin de se déplacer vers Pacman
     * @param p, l'entité pacman
     * @return la direction voulue
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
     * Permet de se déplacer vers Pacman
     * @param p, l'entité Pacman
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
