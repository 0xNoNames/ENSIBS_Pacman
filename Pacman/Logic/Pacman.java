package Pacman.Logic;

/**
 * Classe représentant PacMan, l'entité du jeu que le joueur joue
 * 
 * @author François JULLION
 * @inv this.vies >= 0
 */
public class Pacman extends Entite {

    /**
     * Entier représentant le nombre de vie de Pacman
     */
    private int vies;

    /**
     * Entier représentant le dernier tick durant lequel pacman a mangé un fantome
     */
    private int tickDernierFantomeMange;

    /**
     * Entier représentant le combo (Nombre de fantome mangé d'affilé)
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
     * 
     * @return un entier représentant le nombre de vie de Pacman
     */
    public int getVie() {
        return this.vies;
    }

    /**
     * Permet de définir le nombre de vie de Pacman
     * 
     * @return un entier représentant le nombre de vie de Pacman
     */
    public void setVies(int vies) {
        this.vies = vies;
    }

    /**
     * Permet de récupérer le dernier tick durant lequel pacman a mangé un fantome
     * 
     * @return un entier représentant le tick durant lequel pacman a mangé un fantome
     */
    public int getTickDernierFantomeMange() {
        return this.tickDernierFantomeMange;
    }

    /**
     * Permet de définir le dernier tick durant lequel pacman a mangé un fantome
     * 
     * @param t, entier représentant un tick
     */
    public void setTickDernierFantomeMange(int t) {
        this.tickDernierFantomeMange = t;
    }

    /**
     * Permet de récupérer le combo actuel de pacman
     * 
     * @return un entier représentant le combo actuel de pacman
     */
    public int getCompteurCombo() {
        return this.compteurCombo;
    }

    /**
     * Permet de déterminer le combo actuel de pacman
     * 
     * @param c, en entier représentant un compteur de combo
     * @pre c >= 0
     */
    public void setCompteurCombo(int c) {
        this.compteurCombo = c;
    }

    /**
     * Permet de faire mourir Pacman, il perd donc une vie
     */
    public void meurt() {
        vies--;
    }

    /**
     * Permet de renvoyer les coordonnées de Pacman
     * 
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
        int[] posActuelle = getPositionI();
        int[] posVoulue = calculPosDirection(dirVoulue, posActuelle);

        /* Test si la direction voulue est possible */
        boolean deplacementVouluePossible =
            estPositionPossible(posVoulue);

        /* MAJ dirCourante si deplacement voulue possible */
        boolean deplacementCourantPossible = false;
        if (deplacementVouluePossible) {
            dirCourante = dirVoulue;
        } else {
            /* Sinon on vérifie si la direction courante est possible */
            posVoulue = calculPosDirection(dirCourante, posActuelle);
            deplacementCourantPossible = estPositionPossible(posVoulue);
        }

        /* Si une direction est possible on déplace */
        if (deplacementVouluePossible) {
            switch (dirVoulue) {
            case EST:
                this.posX += Partie.d.getVitessePacman(this.partie.getNiveau()) * (1.0 / Partie.tickParSeconde);
                break;
            case OUEST:
                this.posX -= Partie.d.getVitessePacman(this.partie.getNiveau()) * (1.0 / Partie.tickParSeconde);
                break;
            case SUD:
                this.posY += Partie.d.getVitessePacman(this.partie.getNiveau()) * (1.0 / Partie.tickParSeconde);
                break;
            case NORD:
                this.posY -= Partie.d.getVitessePacman(this.partie.getNiveau()) * (1.0 / Partie.tickParSeconde);
                break;
            }
        } else if (deplacementCourantPossible) {
            switch (dirCourante) {
            case EST:
                this.posX += Partie.d.getVitessePacman(this.partie.getNiveau()) * (1.0 / Partie.tickParSeconde);
                break;
            case OUEST:
                this.posX -= Partie.d.getVitessePacman(this.partie.getNiveau()) * (1.0 / Partie.tickParSeconde);
                break;
            case SUD:
                this.posY += Partie.d.getVitessePacman(this.partie.getNiveau()) * (1.0 / Partie.tickParSeconde);
                break;
            case NORD:
                this.posY -= Partie.d.getVitessePacman(this.partie.getNiveau()) * (1.0 / Partie.tickParSeconde);
                break;
            }
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

    /**
     * Permet d'obtenir la vitesse actuelle de Pacman
     * 
     * @return vitesse en double
     */
    public double getVitesse() {
        return Partie.d.getVitessePacman(this.partie.getNiveau());
    }
}
