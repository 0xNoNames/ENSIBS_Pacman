package Pacman.Data;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Pacman.Logic.Case;
import Pacman.Logic.Cerise;
import Pacman.Logic.Cle;
import Pacman.Logic.Cloche;
import Pacman.Logic.ECouleur;
import Pacman.Logic.Fraise;
import Pacman.Logic.Fruit;
import Pacman.Logic.GalaxianBoss;
import Pacman.Logic.Grille;
import Pacman.Logic.GrosseGomme;
import Pacman.Logic.Jouable;
import Pacman.Logic.Melon;
import Pacman.Logic.Mur;
import Pacman.Logic.Orange;
import Pacman.Logic.PetiteGomme;
import Pacman.Logic.Pomme;

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
     * Chemin du fichier config.json dans le .jar.
     */
    private static String cheminConfig = "config.json";
    
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
                InputStream input = ParseConfig.class.getResourceAsStream(cheminConfig);
                reader = new BufferedReader(new InputStreamReader(input));
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

    // --------------------------------------------
    // Concernant la vitesse des entités
    // --------------------------------------------

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

    // --------------------------------------------
    // Concernant la position initiale des entités
    // --------------------------------------------

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

    // --------------------------------------------
    // Concernant quel fruit apparait à quel niveau
    // --------------------------------------------

    /**
     * Prend un JSONObject dans lequel les palliers de fruits sont indiqués,
     * et en fait un tableau
     * 
     * @param tableauObj JSONObject indiquant les d ifférents palliers auxquels
     * le fruit à faire apparaitre est différent.
     * @return tableau de Fruit comprenant 256 cases dont seules celles
     * représentant un pallier sont remplies (tout le reste est null).
     */
    private static Fruit[] parcoursObjetFruit(JSONObject tableauObj)
    {
        Fruit[] tableau = new Fruit[256];

        for (Object cleObj : tableauObj.keySet())
        {
            String cleStr = (String) cleObj;
            int cle = Integer.parseInt(cleStr);
            
            Fruit fruit = null;
            switch ((String) tableauObj.get(cleObj))
            {
                case "Cerise":
                    fruit = new Cerise();
                    break;
                case "Fraise":
                    fruit = new Fraise();
                    break;
                case "Orange":
                    fruit = new Orange();
                    break;
                case "Pomme":
                    fruit = new Pomme();
                    break;
                case "Melon":
                    fruit = new Melon();
                    break;
                case "GalaxianBoss":
                    fruit = new GalaxianBoss();
                    break;
                case "Cloche":
                    fruit = new Cloche();
                    break;
                case "Clé":
                    fruit = new Cle();
                    break;
            }

            tableau[cle - 1] = fruit;
        }

        return tableau;
    }

    /* Existe déjà pour un tableau de double, on aurait pu la faire en
     * générique, mais il aurait fallu convertir les double en Double...
     * pas rentable
     */
    /**
     * Prend un tableau dont seuls les palliers sont remplis, et remplit le
     * reste du tableau (pas de return, fonctionne par référence).
     * 
     * @param tableau tableau avec uniquement les palliers
     */
    private static void remplissageTableauFruit(Fruit[] tableau)
    {
        Fruit precedent = null;
        for (int i = 0; i < tableau.length; i++)
        {
            if (tableau[i] == null)
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
     * Renvoie un tableau de Fruit permettant de savoir quel Fruit utiliser
     * pour quel niveau.
     * 
     * @return tableau de 256 Fruit
     */
    public static Fruit[] getFruitNiveau()
    {
        // on récupère l'objet des fruits par niveau
        JSONObject niveauFruitCompact =
            (JSONObject) getJson().get("niveauFruit");

        // on parcourt l'objet json pour en trouver les valeurs clés
        Fruit[] fruitNiveau = parcoursObjetFruit(niveauFruitCompact);

        // on a stocké seulement les changements, maintenant on remplit tout
        remplissageTableauFruit(fruitNiveau);

        return fruitNiveau;
    }

    // --------------------------------------------
    // Concernant le nombre de points qu'apporte un Objet
    // --------------------------------------------
    
    /**
     * Permet de savoir combien de points rapporte un Objet
     * 
     * @return HashMap faisant correspondre le nom d'un Objet avec le nombre de
     * points qu'il rapporte
     */
    public static HashMap<String, Integer> getPointsObjet()
    {
        // on récupère l'objet des points par objet
        JSONObject pointsObjetJson = (JSONObject) getJson().get("pointsObjet");

        // on transforme en hashmap
        HashMap<String, Integer> pointsObjet = new HashMap<String, Integer>();
        for (Object cleObj : pointsObjetJson.keySet())
        {
            String cleStr = (String) cleObj;
            Long valeurL = (Long) pointsObjetJson.get(cleObj);
            Integer valeur = valeurL.intValue();
            pointsObjet.put(cleStr, valeur);
        }

        return pointsObjet;
    }

    /**
     * Permet de savoir combien de points rapporte un combo.
     * 
     * @return tableau d'entiers indiquant le nombre de points pour chaque
     * niveau de combo.
     */
    public static int[] getPointsCombo()
    {
        // on récupère le tableau des points par combo
        JSONArray pointsComboJson = (JSONArray) getJson().get("pointsCombo");

        // on transforme en int[]
        int[] pointsCombo = new int[4];
        for (int i = 0; i < 4; i++)
        {
            Long pointsComboInt = (Long) pointsComboJson.toArray()[i];
            pointsCombo[i] = pointsComboInt.intValue();
        }

        return pointsCombo;
    }

    // --------------------------------------------
    // Concernant la Grille initiale
    // --------------------------------------------

    /**
     * Prend un JSONArray de JSONArray de String, et le transforme en un
     * tableau de tableaux de String.
     * 
     * @param jsonArray grille issue de la config.
     * @return grille d'instructions (attention, format [y][x] puisque x est
     * variable selon la ligne de la config)
     */
    private static String[][] jsonArrayToInstr(JSONArray jsonArray)
    {
        Object[] instrGrilleJsonArr = jsonArray.toArray();

        // on récupère toutes les lignes du tableau
        int nbrLignes = instrGrilleJsonArr.length;
        JSONArray[] instrLigneGrilleJson = new JSONArray[nbrLignes];
        for (int i = 0; i < nbrLignes; i++)
        {
            instrLigneGrilleJson[i] = (JSONArray) instrGrilleJsonArr[i];
        }

        // on transforme tout ça en tableau de tableau de String
        String[][] instructionsGrille = new String[nbrLignes][];
        for (int i = 0; i < nbrLignes; i++)
        {
            // on transforme le JSONArray i en tableau d'Object
            Object[] ligneInstr = instrLigneGrilleJson[i].toArray();

            // puis on cast chaque Object en String
            instructionsGrille[i] = new String[ligneInstr.length];
            for (int j = 0; j < ligneInstr.length; j++)
            {
                instructionsGrille[i][j] = (String) ligneInstr[j];
            }
        }

        return instructionsGrille;
    }

    /**
     * Décode une instruction en un ArrayList de Case.
     * 
     * @param instr instruction à décoder (type "28m").
     * @return liste de Case instanciées.
     */
    private static ArrayList<Case> decoderInstr(String instr)
    {
        String nbrCasesS = instr.substring(0, instr.length() - 1);
        int nbrCases = Integer.parseInt(nbrCasesS);
        String typeCase = instr.substring(instr.length() - 1);
        ArrayList<Case> cases = new ArrayList<Case>();

        /* on répète le for, mais vaut mieux écrire 4x "for" que vérifier
        nbrCases fois la condition niveau performances */
        switch(typeCase)
        {
            case "m": // mur
                for (int i = 0; i < nbrCases; i++)
                {
                    cases.add(new Mur());
                }
                break;
            case "p": // petite gomme
                for (int i = 0; i < nbrCases; i++)
                {
                    Jouable nCase = new Jouable();
                    nCase.setObjet(new PetiteGomme());
                    cases.add(nCase);
                }
                break;
            case "G": // grosse gomme
                for (int i = 0; i < nbrCases; i++)
                {
                    Jouable nCase = new Jouable();
                    nCase.setObjet(new GrosseGomme());
                    cases.add(nCase);
                }
                break;
            case "v": // vide
                for (int i = 0; i < nbrCases; i++)
                {
                    cases.add(new Jouable());
                }
                break;
        }

        return cases;
    }

    /**
     * Prend une ligne d'instructions de la config, et instancie les cases
     * correspondantes.
     * 
     * @param ligneInstr tableau d'instructions (type ["1m", "12p", ...])
     * @return tableau de Case instanciées
     */
    private static Case[] decoderLigne(String[] ligneInstr)
    {
        // un ArrayList est plus simple qu'un [] pour fusionner
        ArrayList<Case> casesList = new ArrayList<Case>();
        for (String instruction : ligneInstr)
        {
            casesList.addAll(decoderInstr(instruction));
        }

        // on transforme l'ArrayList<Case> en Case[]
        Case[] cases = new Case[casesList.size()];
        for (int i = 0; i < cases.length; i++)
        {
            cases[i] = (Case) casesList.get(i);
        }

        return cases;
    }

    /**
     * Retourne un tableau de Case [y][x] en un tableau [x][y].
     * 
     * @param grille grille dans le "mauvais sens"
     * @return grille dans le "bon sens"
     */
    private static Case[][] retournerGrille(Case[][] grille)
    {
        Case[][] nGrille = new Case[grille[0].length][grille.length];

        for (int i = 0; i < grille.length; i++)
        {
            for (int j = 0; j < grille[0].length; j++)
            {
                nGrille[j][i] = grille[i][j];
            }
        }

        return nGrille;
    }

    /**
     * Récupère la grille de la config, et la transforme étape par étape pour
     * finir à une grille de début de niveau toute instanciée.
     * 
     * @return grille prête à jouer, sans entités
     */
    public static Grille getGrilleInitiale()
    {
        // on récupère le tableau représentant la grille en json
        JSONArray instrGrilleJson = (JSONArray) getJson().get("grille");

        // on transforme ça en tableau de tableau de String
        String[][] instructions = jsonArrayToInstr(instrGrilleJson);

        // on décode les instructions
        Case[][] cases = new Case[instructions.length][];
        for (int i = 0; i < instructions.length; i++)
        {
            cases[i] = decoderLigne(instructions[i]);
        }

        // jsonArrayToInstr retourne du [y][x], on transforme en [x][y]
        cases = retournerGrille(cases);

        return new Grille(cases);
    }
}
