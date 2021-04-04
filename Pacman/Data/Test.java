package Pacman.Data;

import Pacman.Logic.*;

public class Test {
    public static void main(String args[]) {
        DataForLogic dataL = new DataForLogic();
        dataL.getFruitNiveau(5);
        dataL.getGrilleInitiale(new Pacman());
        dataL.getPoints(new Cerise());
        dataL.getPointsCombo(3);
        dataL.getPositionInitialeFantome(ECouleur.ORANGE);
        dataL.getPositionInitialePacman();
        dataL.getVitesseFantome(56, ECouleur.CYAN);
        dataL.getVitessePacman(200);

        DataForView dataV = new DataForView();
        dataV.getFantomesSprites(ECouleur.ROSE, EDirection.NORD);
        dataV.getVulnerableFantomesSprites();
        dataV.getMortPacmanSprites();
        dataV.getFruitSprites();
        dataV.getGommesSprites();
        dataV.getGrille();
        dataV.getLettresChiffres();
        dataV.getMortFantomeSprites();
        dataV.getMortPacmanSprites();
        dataV.getPacmanSprites(EDirection.EST);
        dataV.getPoints();
        dataV.getRGOSprite();
    }
}
