package Pacman.Data;

import java.util.HashMap;
import java.util.Map;

import Pacman.Logic.ECouleur;
import Pacman.Logic.Fruit;
import Pacman.Logic.Grille;
import Pacman.Logic.Objet;

/**
 * DataForLogic stocke les différentes données susceptibles d´être demandées
 * par la Logic. Elle agit comme un cache.
 * 
 * @author Louis-Baptiste Sobolewski
 */
public class DataForLogic implements IEntite, IFruit, IGrille, IObjet
{
    private double[] vitessePacman;
    private Map<ECouleur, double[]> vitesseFantome;
    private double[] posInitPacman;
    private double[] posInitBlinky, posInitInky, posInitPinky, posInitClyde;
    private Fruit[] fruitNiveau;
    private Grille grilleInitiale;
    private Map<String, Integer> pointsObjet;

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
        throw new UnsupportedOperationException();
    }

    @Override
    public double[] getPositionInitialeFantome(ECouleur couleur) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Fruit getFruitNiveau(int niveau) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Grille getGrilleInitiale() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getPoints(Objet objet) {
        throw new UnsupportedOperationException();
    }
}
