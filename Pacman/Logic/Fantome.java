package Pacman.Logic;

import java.security.spec.EdDSAParameterSpec;
import java.util.Arrays;

/**
 * Classe représentant l'entité Fantome
 * 
 * @author François JULLION & Louis-Baptiste SOBOLEWSKI
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
     * 
     * @param x, la coordonnée en x
     * @param y, la coordonnée en y
     */
    public Fantome(double x, double y) {
        this.posX = x;
        this.posY = y;
        this.statut = EStatutFantome.CHASSEUR;
    }

    /**
     * Permet de récupérer les coordonnées du fantome
     * 
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
     * 
     * @return le statut du fantome sous forme d'énumération
     */
    public EStatutFantome getStatut() {
        return this.statut;
    }

    /**
     * Permet de définir le statut actuel du fantome
     * 
     * @param s, un statut de type Enumeration
     */
    public void setStatut(EStatutFantome s) {
        this.statut = s;
    }

    public void setDirectionCourante(EDirection dircour) {
        this.dirCourante = dircour;
    }

    public EDirection getDirectionCourante() {
        return this.dirCourante;
    }

    /**
     * Permet de récupérer la couleur du fantom
     * 
     * @return la couleur du fantome
     */
    public ECouleur getCouleur() {
        return this.couleur;
    }

    public static void wait(int ms){
        try {
            Thread.sleep(ms);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    /**
     * Permet de faire mourir le fantome et de le ramener à sa position initiale
     */
    public void meurt() {
        this.statut = EStatutFantome.MORT;
        demiTour();
    }

    /**
     * Renvoie la direction opposée à celle passée en argument
     * 
     * @param dir direction
     * @return direction opposée
     */
    protected EDirection getDirectionOpposee(EDirection dir) {
        switch (dir)
        {
            case NORD:
                return EDirection.SUD;
            case SUD:
                return EDirection.NORD;
            case EST:
                return EDirection.OUEST;
            case OUEST:
                return EDirection.EST;
        }

        return null;
    }

    /**
     * Enlève une valeur d'un tableau de EDirection
     * 
     * @param tableau tableau duquel enlever la valeur
     * @param aEnlever valeur à enlever
     * @return tableau réduit d'une case
     */
    protected EDirection[] enleverDirectionTableau(EDirection[] tableau, EDirection aEnlever) {
        EDirection[] nTableau = new EDirection[tableau.length - 1];
        int indexOrig, indexN = 0;

        for (indexOrig = 0; indexOrig < tableau.length; indexOrig++)
        {
            if (tableau[indexOrig] != aEnlever)
            {
                nTableau[indexN] = tableau[indexOrig];
                indexN++;
            }
        }

        return nTableau;
    }

    /**
     * Détermine les cases où le fantôme peut se rendre.
     * 
     * @param posAct position actuelle du fantôme
     * @param dirAct direction actuelle du fantôme
     * @return liste de cases possibles
     */
    protected int[][] getCasesPossibles(double[] posAct, EDirection dirAct) {
        EDirection[] dirPossibles = {EDirection.NORD, EDirection.SUD,
            EDirection.EST, EDirection.OUEST};
        
        // un fantôme ne peut pas faire demi tour
        dirPossibles =
            enleverDirectionTableau(dirPossibles, getDirectionOpposee(dirAct));
        
        // un fantôme ne peut pas aller dans un mur
        EDirection[] dirPossiblesCpy =
            Arrays.copyOf(dirPossibles, dirPossibles.length);
        for (EDirection direction : dirPossiblesCpy)
        {
            int[] posVoulue = calculPosDirection(direction, getPositionI());
            if (!estPositionPossible(posVoulue))
            {
                dirPossibles =
                    enleverDirectionTableau(dirPossibles, direction);
            }
        }

        // on transforme les directions possibles en cases possibles
        int[][] casesPossibles = new int[dirPossibles.length][];
        for (int i = 0; i < dirPossibles.length; i++)
        {
            casesPossibles[i] =
                calculPosDirection(dirPossibles[i], getPositionI());
        }

        return casesPossibles;
    }

    /**
     * Calcule la distance "à vol d'oiseau" entre deux points
     * 
     * @param x1 abscisse du point 1
     * @param y1 ordonnée du point 1
     * @param x2 abscisse du point 2
     * @param y2 ordonnée du point 2
     * @return distance
     */
    protected double distance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    /**
     * Trouve le minimum dans un tableau de double
     * 
     * @param tableau tableau de double
     * @return valeur minimum dans le tableau
     */
    protected Double minimum(Double[] tableau)
    {
        Double minimum = tableau[0];

        for (Double valeur : tableau)
        {
            if (valeur < minimum)
            {
                minimum = valeur;
            }
        }

        return minimum;
    }

    /**
     * Trouve la direction à emprunter pour aller de pos1 à pos2, en admettant
     * que les 2 positions ne sont distantes que de 1
     * 
     * @param pos1 position 1
     * @param pos2 position 2
     * @return direction
     */
    protected EDirection calculDirectionPos(int[] pos1, int[] pos2)
    {
        int diffX = pos1[0] - pos2[0];
        if (diffX == 1)
        {
            return EDirection.OUEST;
        }
        else if (diffX == -1)
        {
            return EDirection.EST;
        }
        else
        {
            int diffY = pos1[1] - pos2[1];
            if (diffY == 1)
            {
                return EDirection.NORD;
            }
            else
            {
                return EDirection.SUD;
            }
        }
    }

    /**
     * Renvoie l'index de la case possible la plus intéressante
     * 
     * @param cible case par rapport à laquelle on calcule la distance
     * @param casesPossibles liste de cases de départ possibles
     * @return index de la case de départ la plus proche
     */
    protected int indexCasePlusProche(double[] cible, int[][] casesPossibles)
    {
        // Double et non double pour pouvoir faire indexOf dessus
        Double[] distances = new Double[casesPossibles.length];
        for (int i = 0; i < casesPossibles.length; i++)
        {
            distances[i] = distance(
                cible[0], cible[1],
                (double) casesPossibles[i][0], (double) casesPossibles[i][1]
            );
        }
        
        return Arrays.asList(distances).indexOf(minimum(distances));
    }

    private void effectuerDeplacement()
    {
        double distDeplacement =
            Partie.d.getVitesseFantome(this.partie.getNiveau(), this.couleur)
            / Partie.tickParSeconde;

        switch (dirCourante)
        {
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
                break;
            case EST:
                this.posX += distDeplacement;
                this.posY = ((int) this.posY) + 0.0;
                break;
        }
    }

    /**
     * Déplace le fantôme en fonction d'une case cible
     * 
     * @param cible coordonnées de la cible
     */
    protected void deplacerSelonCible(double[] cible)
    {
        // on vérifie si c'est le moment de changer de direction
        if (estMomentChangementDir(getVitesse()))
        {
            int[][] casesPossibles = getCasesPossibles(
                this.getPosition(), this.getDirectionCourante()
            );

            // on regarde quelle case possible est la plus proche de la cible
            int indexPlusCourt = indexCasePlusProche(cible, casesPossibles);

            // on détermine la direction voulue
            int[] caseVoulue = casesPossibles[indexPlusCourt];
            this.dirVoulue = calculDirectionPos(getPositionI(), caseVoulue);

            // si la nouvelle direction est différente, on switch
            if (dirCourante != dirVoulue)
            {
                dirCourante = dirVoulue;
            }
        }

        // on déplace
        this.effectuerDeplacement();
    }

    /**
     * Déplace le fantôme en fonction de l'aléatoire
     */
    protected void deplacerAleatoire()
    {
        // on vérifie si c'est le moment de changer de direction
        if (estMomentChangementDir(getVitesse()))
        {
            int[][] casesPossibles = getCasesPossibles(
                this.getPosition(), this.getDirectionCourante()
            );

            // on choisit aléatoirement la case qui nous intéresse
            int indexRnd =
                ((int) (Math.random() * 100)) % casesPossibles.length;

            // on détermine la direction voulue
            int[] caseVoulue = casesPossibles[indexRnd];
            this.dirVoulue = calculDirectionPos(getPositionI(), caseVoulue);

            // si la nouvelle direction est différente, on switch
            if (dirCourante != dirVoulue)
            {
                dirCourante = dirVoulue;
            }
        }

        // on déplace
        this.effectuerDeplacement();
    }

    /**
     * Quand un fantôme change de statut, il fait demi tour
     */
    public void demiTour()
    {
        this.dirCourante = getDirectionOpposee(this.dirCourante);
    }

    /**
     * Permet d'obtenir la vitesse actuelle du Fantome
     * 
     * @return vitesse en double
     */
    public double getVitesse()
    {
        return Partie.d.getVitesseFantome(
            this.partie.getNiveau(), this.couleur
        );
    }

    public boolean deplacementMort()
    {
        double[] cible = {14, 11};
        deplacerSelonCible(cible);

        int[] nPos = getPositionI();
        return (cible[0] == nPos[0] && cible[1] == nPos[1]);
    }
}
