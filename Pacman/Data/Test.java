package Pacman.Data;

import Pacman.Logic.*;

public class Test {
    private static void afficherGrille(Case[][] grille)
    {
        for (int y = 0; y < grille[0].length; y++)
        {
            String ligne = "";
            for (int x = 0; x < grille.length; x++)
            {
                if (grille[x][y] instanceof Mur)
                {
                    ligne += "X ";
                }
                else
                {
                    Jouable casej = (Jouable) grille[x][y];
                    if (casej.getObjet() == null)
                    {
                        ligne += "  ";
                    }
                    else if (casej.getObjet() instanceof PetiteGomme)
                    {
                        ligne += ". ";
                    }
                    else
                    {
                        ligne += "o ";
                    }
                }
            }
            System.out.println(ligne);
        }
    }

    public static void main(String args[]) {
        // appel de toutes les fonctions de DataForLogic
        DataForLogic dataL = new DataForLogic();
        dataL.getFruitNiveau(5);
        dataL.getGrilleInitiale(new Pacman());
        dataL.getPoints(new Cerise());
        dataL.getPointsCombo(3);
        dataL.getPositionInitialeFantome(ECouleur.ORANGE);
        dataL.getPositionInitialePacman();
        dataL.getVitesseFantome(56, ECouleur.CYAN);
        dataL.getVitessePacman(200);

        // appel de toutes les fonctions de DataForView
        DataForView dataV = new DataForView();
        dataV.getFantomesSprites(ECouleur.ROSE, EDirection.NORD);
        dataV.getVulnerableFantomesSprites();
        dataV.getMortPacmanSprites();
        dataV.getFruitSprites();
        dataV.getGommesSprites();
        dataV.getGrille();
        dataV.getLettresChiffres();
        dataV.getMortFantomeSprites();
        dataV.getPacmanSprites(EDirection.EST);
        dataV.getPoints();
        dataV.getRGOSprite();

        // affichage des sprites pour vérifier leur découpage
        /* on ne stocke pas en variable, car vu qu'on ne l'utilise pas, on a
        un warning */
        new FenetreTest(
            dataV.getPacmanSprites(EDirection.EST)[0]
        );

        afficherGrille(dataL.getGrilleInitiale(new Pacman()).getCases());
    }
}
