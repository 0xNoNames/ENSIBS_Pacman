package Pacman.Data;

import java.util.HashMap;

import Pacman.Logic.Blinky;
import Pacman.Logic.Clyde;
import Pacman.Logic.ECouleur;
import Pacman.Logic.EDirection;
import Pacman.Logic.Fruit;
import Pacman.Logic.Grille;
import Pacman.Logic.Inky;
import Pacman.Logic.Objet;
import Pacman.Logic.Pacman;
import Pacman.Logic.Pinky;

/**
 * DataForLogic stocke les différentes données susceptibles d´être demandées
 * par la Logic. Elle agit comme un cache.
 * 
 * @author Louis-Baptiste Sobolewski
 */
public class DataForLogic implements IEntite, IFruit, IGrille, IObjet
{
    private double[] vitessePacman;
    private HashMap<ECouleur, double[]> vitesseFantome;
    private double[] posInitPacman;
    private HashMap<ECouleur, double[]> posInitFantome;
    private Fruit[] fruitNiveau;
    private HashMap<String, Integer> pointsObjet;
    private int[] pointsCombo;

    @Override
    public double getVitessePacman(int niveau) {
        // si vitessePacman n'a pas encore été calculé
        if (vitessePacman == null)
        {
            // récupération des données
            int vitesseBase = ParseConfig.getVitesseBase();
            double[] coefsVitesse = ParseConfig.getCoefsVitessePacman();

            // calcul des vitesses
            vitessePacman = new double[256];
            for (int i = 0; i < vitessePacman.length; i++)
            {
                vitessePacman[i] = vitesseBase * coefsVitesse[i];
            }
        }
        
        return vitessePacman[niveau - 1];
    }

    @Override
    public double getVitesseFantome(int niveau, ECouleur couleur) {
        // si aucune vitesse n'a pas encore été calculée
        if (vitesseFantome == null)
        {
            vitesseFantome = new HashMap<ECouleur, double[]>();
        }

        // si la vitesse du fantome demandé n'a pas encore été calculée
        if (vitesseFantome.get(couleur) == null)
        {
            // récupération des données
            int vitesseBase = ParseConfig.getVitesseBase();
            double[] coefsVitesse =
                ParseConfig.getCoefsVitesseFantome(couleur);

            // calcul des vitesses
            double[] vitesseFantomeTab = new double[256];
            for (int i = 0; i < vitesseFantomeTab.length; i++)
            {
                vitesseFantomeTab[i] = vitesseBase * coefsVitesse[i];
            }
            vitesseFantome.put(couleur, vitesseFantomeTab);
        }

        return vitesseFantome.get(couleur)[niveau];
    }

    @Override
    public double[] getPositionInitialePacman() {
        // si la position initiale de pacman n'a encore jamais été demandée
        if (posInitPacman == null)
        {
            posInitPacman = ParseConfig.getPositionInitialePacman();
        }

        return posInitPacman;
    }

    @Override
    public double[] getPositionInitialeFantome(ECouleur couleur) {
        // si aucune position initiale n'a encore été demandée
        if (posInitFantome == null)
        {
            posInitFantome = new HashMap<ECouleur, double[]>();
        }

        // si la pos init du fantome demandé n'a pas encore été demandée
        if (posInitFantome.get(couleur) == null)
        {
            double[] posInit =
                ParseConfig.getPositionInitialeFantome(couleur);
            posInitFantome.put(couleur, posInit);
        }

        return posInitFantome.get(couleur);
    }

    @Override
    public Fruit getFruitNiveau(int niveau) {
        // si aucun fruit n'a encore été demandé
        if (fruitNiveau == null)
        {
            fruitNiveau = ParseConfig.getFruitNiveau();
        }

        return fruitNiveau[niveau - 1];
    }

    @Override
    public int getPoints(Objet objet) {
        // si aucun nombre de points n'a encore été demandé
        if (pointsObjet == null)
        {
            pointsObjet = ParseConfig.getPointsObjet();
        }

        // on trouve la clé correspondante à l'objet envoyé
        String cle = objet.getClass().toString();
        String[] cleSplittee = cle.split("\\.");
        cle = cleSplittee[cleSplittee.length - 1];
        
        // on enlève les accents
        if (cle.equals("Cle")) cle = "Clé";

        return pointsObjet.get(cle);
    }

    @Override
    public Grille getGrilleInitiale(Pacman pacman) {
        /* afin d'éviter tout problème de confusion de Grille avec leurs
         * références, on ne mettra pas en place de stratégie de cache ici */
        Grille grille = ParseConfig.getGrilleInitiale();
        
        // on ajoute aussi les entités aux bonnes positions
        double[] posInit;

        posInit = getPositionInitialePacman();
        pacman.setPosX(posInit[0]);
        pacman.setPosY(posInit[1]);
        pacman.setDirectionCourante(EDirection.OUEST);
        pacman.setDirectionVoulue(EDirection.OUEST);
        pacman.setGrille(grille);
        grille.setPacman(pacman);

        posInit = getPositionInitialeFantome(ECouleur.ROUGE);
        Blinky blinky = new Blinky(posInit[0], posInit[1]);
        blinky.setDirectionCourante(EDirection.OUEST);
        blinky.setGrille(grille);
        grille.setBlinky(blinky);

        posInit = getPositionInitialeFantome(ECouleur.ROSE);
        Pinky pinky = new Pinky(posInit[0], posInit[1]);
        pinky.setDirectionCourante(EDirection.SUD);
        pinky.setGrille(grille);
        grille.setPinky(pinky);

        posInit = getPositionInitialeFantome(ECouleur.CYAN);
        Inky inky = new Inky(posInit[0], posInit[1]);
        inky.setDirectionCourante(EDirection.NORD);
        inky.setGrille(grille);
        grille.setInky(inky);

        posInit = getPositionInitialeFantome(ECouleur.ORANGE);
        Clyde clyde = new Clyde(posInit[0], posInit[1]);
        clyde.setDirectionCourante(EDirection.NORD);
        clyde.setGrille(grille);
        grille.setClyde(clyde);

        return grille;
    }

    @Override
    public int getPointsCombo(int nbrFantomesManges)
    {
        // si aucun nombre de points n'a encore été mangé
        if (pointsCombo == null)
        {
            pointsCombo = ParseConfig.getPointsCombo();
        }

        return pointsCombo[nbrFantomesManges - 1];
    }
}
