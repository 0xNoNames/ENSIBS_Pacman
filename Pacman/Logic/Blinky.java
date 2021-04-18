package Pacman.Logic;

import java.util.Arrays;

/**
 * Le classe Blinky permet de représenter un des quatres fantomes du jeu
 * 
 * @author François JULLION
 */
public class Blinky extends Fantome {
    
    /**
     * Constructeur de la classe Blinky
     */
    public Blinky(double x, double y) {
        super(x,y);
        this.couleur = ECouleur.ROUGE;
    }

    // --------------
    // Déplacement
    // --------------

    /**
     * Détermine la case cible de Blinky.
     * 
     * @param p Pacman
     * @return cible de Blinky
     */
    public double[] getCible(Pacman p) {
        // la cible de Blinky est la case où se trouve Pacman
        return p.getPosition();
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

    /**
     * Vérifie que l'entité est au milieu d'une intersection
     * 
     * @return booléen
     */
    protected boolean estMomentChangementDir()
    {
        double vitesse =
            Partie.d.getVitesseFantome(this.partie.getNiveau(), this.couleur);
        double arrondi = vitesse / Partie.tickParSeconde;
        if (dirVoulue == EDirection.EST || dirVoulue == EDirection.OUEST)
        {
            // il faut qu'on soit à y = ~.0 ± arrondi pour changer de dir
            if (this.posY - ((int) this.posY) <= arrondi)
            {
                return true;
            }
        }
        else // NORD ou SUD
        {
            // il faut qu'on soit à x = ~.0 ± arrondi pour changer de dir
            if (this.posX - ((int) this.posX) <= arrondi)
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Permet de déplacer Blinky en fonction de pacman
     * @param p, l'entité Pacman
     */
    public void deplacer(Pacman p) {
        double[] cible = this.getCible(p);
        int[][] casesPossibles =
            getCasesPossibles(this.getPosition(), this.getDirectionCourante());
        
        // on regarde quelle case possible est la plus proche de la cible
        int indexPlusCourt = indexCasePlusProche(cible, casesPossibles);
        
        // on détermine la direction voulue
        int[] caseVoulue = casesPossibles[indexPlusCourt];
        this.dirVoulue = calculDirectionPos(getPositionI(), caseVoulue);

        // on vérifie si c'est le moment de changer de direction
        if (dirCourante != dirVoulue && estMomentChangementDir())
        {
            dirCourante = dirVoulue;
        }

        // on déplace
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
}
