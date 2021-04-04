package Pacman.Logic;

/**
 * Classe représentant PacMan, l'entité du jeu que le joueur joue
 * 
 * @author François JULLION
 */
public class Pacman extends Entite {
    

    /**
     * Entier représentant le nombre de vie de Pacman
     */
    private int vies;

    /**
     * 
     */
    private int tickDernierFantomeMange;

    /**
     * 
     */
    private int compteurCombo;

    /**
     * Constructeur de la classe Pacman
     */ 
    public Pacman() {
        this.vies = 3;
        this.tickDernierFantomeMange = 0;
    }

    /**
     * Permet de renvoyer le nombre de vie de Pacman
     * @return un entier représentant le nombre de vie de Pacman
     */
    public int getVie() {
        return this.vies;
    }

    public int getTickDernierFantomeMange() {
        return this.tickDernierFantomeMange;
    }

    public void setTickDernierFantomeMange(int t) {
        this.tickDernierFantomeMange = t;
    }

    public int getCompteurCombo() {
        return this.compteurCombo;
    }

    public void setCompteurCombo(int c) {
        this.compteurCombo = c;
    }
    /**
     * Permet de faire mourir Pacman, il perd donc une vie
     */
    public void meurt() {
        vies --;
    }

    /**
     * Permet de renvoyer les coordonnées de Pacman
     * @return un tableau de double, avec en [0] son x et en[1] son y
     */
    public double[] getPosition() {
        double[] res = new double[2];
        res[0] = this.getposX();
        res[1] = this.getposY();
        return res;
    }

    /**
     * Permet de déplacer Pacman
     */
    public void deplacer() {
        /* Calcul de la direction Voulue */
        int[] posActuelle = getPositionActuelle();
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
            this.posX += Partie.d.getVitessePacman(this.partie.getNiveau()) * (1/Partie.tickParSeconde);
            this.posY += Partie.d.getVitessePacman(this.partie.getNiveau()) * (1/Partie.tickParSeconde);
        } else if(deplacementCourantPossible) {
            this.posX += Partie.d.getVitessePacman(this.partie.getNiveau()) * (1/Partie.tickParSeconde);
            this.posY += Partie.d.getVitessePacman(this.partie.getNiveau()) * (1/Partie.tickParSeconde);
        }
    }


    /**
     * Fonction inutile pour Pacman car pas de Statut
     */
    public EStatutFantome getStatut() {
        return null;
    }

    /**
     * Fonction inutile pour Pacman car pas de Couleur
     */
    public ECouleur getCouleur() {
        return null;
    }

}
