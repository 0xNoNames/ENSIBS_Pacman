package Pacman.Data;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
    private static String cheminConfig = "./Pacman/Data/config.json";
    private static JSONObject objetJson = null;

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

    public static int getVitesseBase()
    {
        Long vitesseBaseL = (Long) getJson().get("vitesseBase");
        return vitesseBaseL.intValue();
    }

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
}
