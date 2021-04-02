package Pacman.Data;

import java.io.Reader;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Pacman.Logic.ECouleur;

/**
 * Cette classe traduit le fichier "config.json" en objets Java
 * 
 * @author Louis-Baptiste Sobolewski
 */
class ParseConfig {
    // ------------------------------------------------------------------------
    // Attributs
    // ------------------------------------------------------------------------

    /**
     * Chemin du fichier config.json.
     */
    private static String cheminConfig = "./Pacman/Data/config.json";
    
    /**
     * Stocke config.json désérialisé afin de ne pas constamment le relire.
     */
    private static JSONObject objetJson = null;

    // ------------------------------------------------------------------------
    // Méthodes
    // ------------------------------------------------------------------------

    /**
     * Renvoie le JSONObject correspondant au fichier config.json dont le
     * chemin est précisé dans la variable cheminConfig.
     * 
     * @return JSONObject étant une désérialisation de config.json
     */
    private static JSONObject getJson()
    {
        if (objetJson != null)
        {
            return objetJson;
        }
        else
        {
            Reader reader;
            JSONParser parser = new JSONParser();
            
            try
            {
                reader = new FileReader(cheminConfig);
                objetJson = (JSONObject) parser.parse(reader);
            }
            catch (FileNotFoundException e)
            {
                // l'exception vient du FileReader
                e.printStackTrace();
            }
            catch (IOException | ParseException e)
            {
                // l'exception vient du JSONParser
                e.printStackTrace();
            }

            return objetJson;
        }
    }

    // -------------------------------------------
    // Concernant la vitesse des entités
    // -------------------------------------------

    /**
     * Renvoie la vitesse de base commune à toutes les entités
     * 
     * @return entier représentant une vitesse en cases par seconde
     */
    public static int getVitesseBase()
    {
        Long vitesseBaseL = (Long) getJson().get("vitesseBase");
        return vitesseBaseL.intValue();
    }

    /**
     * Prend un JSONObject dans lequel les palliers de vitesse sont indiqués,
     * et en fait un tableau.
     * 
     * @param tableauObj JSONObject indiquant les différents palliers de
     * vitesses au fur et à mesure des niveaux.
     * @return tableau de doubles comprenant 256 cases dont seules celles
     * représentant un pallier sont remplies (tout le reste est à 0.0).
     */
    private static double[] parcoursObjetVitesse(JSONObject tableauObj)
    {
        double[] tableau = new double[256];

        for (Object cleObj : tableauObj.keySet())
        {
            String cleStr = (String) cleObj;
            int cle = Integer.parseInt(cleStr);
            Double valeur = (Double) tableauObj.get(cleObj);
            
            // -1 car il s´agit de numéros de niveau, qui commencent à 1
            tableau[cle - 1] = valeur.doubleValue();
        }

        return tableau;
    }

    /**
     * Prend un tableau dont seuls les palliers sont remplis, et remplit le
     * reste du tableau (pas de return, fonctionne par référence).
     * 
     * @param tableau tableau avec uniquement les palliers
     */
    private static void remplissageTableauVitesse(double[] tableau)
    {
        double precedent = 0.0;
        for (int i = 0; i < tableau.length; i++)
        {
            if (tableau[i] == 0.0)
            {
                tableau[i] = precedent;
            }
            else
            {
                precedent = tableau[i];
            }
        }
    }

    /**
     * Renvoie un tableau indiquant le coefficient à appliquer à la vitesse de
     * base des entités pour chaque niveau de jeu, applicable à Pacman.
     * 
     * @return tableau de coefficients.
     */
    public static double[] getCoefsVitessePacman()
    {
        // on récupère l'objet des vitesses de pacman
        JSONObject coefsVitessePacmanCompact = 
            (JSONObject) getJson().get("vitessePacman");

        // on parcourt l'objet json pour en trouver les valeurs clés
        double[] coefsVitessePacman =
            parcoursObjetVitesse(coefsVitessePacmanCompact);

        // on a stocké seulement les changements, maintenant on remplit tout
        remplissageTableauVitesse(coefsVitessePacman);

        return coefsVitessePacman;
    }

    /**
     * Renvoie un tableau indiquant le coefficient à appliquer à la vitesse de
     * base des entités pour chaque niveau de jeu, applicable au fantôme dont
     * la couleur est précisée.
     * 
     * @param couleur couleur du fantôme pour lequel on veut les coefficients.
     * @return tableau de coefficients.
     */
    public static double[] getCoefsVitesseFantome(ECouleur couleur)
    {
        // on transforme la couleur en clé json
        String cleJson = "";
        switch (couleur)
        {
            case CYAN:
                cleJson = "vitesseInky";
                break;
            case ORANGE:
                cleJson = "vitesseClyde";
                break;
            case ROSE:
                cleJson = "vitessePinky";
                break;
            case ROUGE:
                cleJson = "vitesseBlinky";
                break;
        }

        // on récupère l'objet des vitesses correspondant
        JSONObject coefsVitesseFantomeCompact =
            (JSONObject) getJson().get(cleJson);
        
        // on parcourt l'objet json pour en trouver les valeurs´clés
        double[] coefsVitesseFantome =
            parcoursObjetVitesse(coefsVitesseFantomeCompact);

        // on a stocké seulement les changements, maintenant on remplit tout
        remplissageTableauVitesse(coefsVitesseFantome);

        return coefsVitesseFantome;
    }

    // -------------------------------------------
    // Concernant la position initiale des entités
    // -------------------------------------------

    /**
     * Transforme un JSONArray de deux valeurs (position initiale) en tableau
     * de double Java.
     * 
     * @param tableauJson JSONArray contenant deux doubles
     * @return tableau de deux double
     */
    private static double[] jsonArrayEnDouble(JSONArray tableauJson)
    {
        double[] tableau = new double[2];

        for (int i = 0; i < 2; i++)
        {
            tableau[i] = (double) tableauJson.toArray()[i];
        }

        return tableau;
    }

    /**
     * Retourne un tableau de forme [x, y] représentant les coordonnées
     * auxquelles Pacman se trouve en début de niveau.
     * 
     * @return tableau de deux double.
     */
    public static double[] getPositionInitialePacman()
    {
        // on récupère le tableau dans le json
        JSONArray posInitJson =
            (JSONArray) getJson().get("positionInitialePacman");

        // on retourne le JSONArray transformé en double[]
        return jsonArrayEnDouble(posInitJson);
    }

    /**
     * Retourne un tableau de forme [x, y] représentant les coordonnées
     * auxquelles le fantôme de couleur demandée se trouve en début de niveau.
     * 
     * @param couleur couleur du fantôme duquel on veut la position initiale.
     * @return tableau de deux double.
     */
    public static double[] getPositionInitialeFantome(ECouleur couleur)
    {
        // on transforme la couleur en clé json
        String cleJson = "";
        switch (couleur)
        {
            case CYAN:
                cleJson = "Inky";
                break;
            case ORANGE:
                cleJson = "Clyde";
                break;
            case ROSE:
                cleJson = "Pinky";
                break;
            case ROUGE:
                cleJson = "Blinky";
                break;
        }

        // on récupère l'objet qui stocke toutes les positions
        JSONObject toutesPosInitJson =
            (JSONObject) getJson().get("positionInitialeFantomes");

        // on extrait le bon tableau
        JSONArray posInitJson = (JSONArray) toutesPosInitJson.get(cleJson);

        // on retourne le JSONArray transformé en double[]
        return jsonArrayEnDouble(posInitJson);
    }
}
