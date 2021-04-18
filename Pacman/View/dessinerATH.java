package Pacman.View;

import java.awt.Graphics2D;

import Pacman.Data.DataForView;
import Pacman.Logic.EDirection;
import Pacman.Logic.EStatutPartie;
import Pacman.Logic.Partie;

/**
 * 
 * La classe dessinerATH (Affichage Tête Haute) permet de gérer les sprites du
 * menu etc.
 * 
 * @author Arthur Pêtre
 */
public class dessinerATH {

    // Le score, les vies ainsi que le GAME OVER ou READY
    public static void dessiner(Partie partie, Graphics2D g2d, DataForView data, EStatutPartie etat) {
        dessinerMurs(g2d, data);
        dessinerVies(partie, g2d, data);
        dessinerEtatPartie(partie, g2d, data, etat);
        dessinerNiveau(partie, g2d, data);
        dessinerScore(partie, g2d, data);
    }

    /**
     * Affiche les vies actuelle de pacman.
     * 
     * @param partie objet Partie permettant de récuprer le niveau actuel.
     * @param g2d    objet Graphics2D permettant de mettre à jour les sprites.
     * @param data   permet de récuperer les sprites depuis Data.
     */
    private static void dessinerVies(Partie partie, Graphics2D g2d, DataForView data) {
        for (int i = 1; i <= partie.getVies(); i++) {
            g2d.drawImage(data.getPacmanSprites(EDirection.OUEST)[0], 18 * i, 278, null);
        }
    }

    /**
     * Affiche les éléments "READY" et "GAME OVER" selon l'état de la partie.
     * 
     * @param partie objet Partie permettant de récuprer le niveau actuel.
     * @param g2d    objet Graphics2D permettant de mettre à jour les sprites.
     * @param data   permet de récuperer les sprites depuis Data.
     */
    public static void dessinerEtatPartie(Partie partie, Graphics2D g2d, DataForView data, EStatutPartie etat) {
        if (etat == EStatutPartie.EN_ANIMATION_DEBUT) {
            g2d.drawImage(data.getRGOSprite()[0], 89, 164, null);
        } else if (etat == EStatutPartie.EN_ANIMATION_GAME_OVER) {
            g2d.drawImage(data.getRGOSprite()[1], 71, 164, null);
        }
    }

    /**
     * Affiche le score actuel.
     * 
     * @param partie objet Partie permettant de récuprer le niveau actuel.
     * @param g2d    objet Graphics2D permettant de mettre à jour les sprites.
     * @param data   permet de récuperer les sprites depuis Data.
     */
    private static void dessinerScore(Partie partie, Graphics2D g2d, DataForView data) {
        g2d.drawImage(data.getRGOSprite()[3], 92, 4, null);

        // On récupère le score actuel et on met chaque chiffre dans un tableau.
        String score = Integer.toString(partie.getScore());
        int[] tableauScore = new int[score.length()];
        for (int i = 0; i < score.length(); i++) {
            tableauScore[i] = score.charAt(i) - '0';
        }

        // On décale chaque chiffre par rapport au nombre de chiffre pour centrer le
        // score.
        for (int i = 0; i < tableauScore.length; i++) {
            g2d.drawImage(data.getLettresChiffres()[tableauScore[i]], 113 - (5 * tableauScore.length) + 10 * i, 18,
                    null);
        }
    }

    private static void dessinerMurs(Graphics2D g2d, DataForView data) {
        g2d.drawImage(data.getGrille(), 0, 28, null);
    }

    /**
     * Affiche le niveau actuel sous forme de fruits.
     * 
     * @param partie objet Partie permettant de récuprer le niveau actuel.
     * @param g2d    objet Graphics2D permettant de mettre à jour les sprites.
     * @param data   permet de récuperer les sprites depuis Data.
     */
    private static void dessinerNiveau(Partie partie, Graphics2D g2d, DataForView data) {
        switch (partie.getNiveau()) {
        case 1:
            g2d.drawImage(data.getFruitSprites()[0], 192, 278, null);
            break;
        case 2:
            g2d.drawImage(data.getFruitSprites()[0], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[1], 180, 278, null);
            break;
        case 3:
            g2d.drawImage(data.getFruitSprites()[0], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[1], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[2], 168, 278, null);
            break;
        case 4:
            g2d.drawImage(data.getFruitSprites()[0], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[1], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[2], 168, 278, null);
            g2d.drawImage(data.getFruitSprites()[2], 156, 278, null);
            break;
        case 5:
            g2d.drawImage(data.getFruitSprites()[0], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[1], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[2], 168, 278, null);
            g2d.drawImage(data.getFruitSprites()[2], 156, 278, null);
            g2d.drawImage(data.getFruitSprites()[4], 144, 278, null);
            break;
        case 6:
            g2d.drawImage(data.getFruitSprites()[0], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[1], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[2], 168, 278, null);
            g2d.drawImage(data.getFruitSprites()[2], 156, 278, null);
            g2d.drawImage(data.getFruitSprites()[3], 144, 278, null);
            g2d.drawImage(data.getFruitSprites()[3], 132, 278, null);
            break;
        case 7:
            g2d.drawImage(data.getFruitSprites()[1], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[2], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[2], 168, 278, null);
            g2d.drawImage(data.getFruitSprites()[3], 156, 278, null);
            g2d.drawImage(data.getFruitSprites()[3], 144, 278, null);
            g2d.drawImage(data.getFruitSprites()[4], 132, 278, null);
            break;
        case 8:
            g2d.drawImage(data.getFruitSprites()[2], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[2], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[3], 168, 278, null);
            g2d.drawImage(data.getFruitSprites()[3], 156, 278, null);
            g2d.drawImage(data.getFruitSprites()[4], 144, 278, null);
            g2d.drawImage(data.getFruitSprites()[4], 132, 278, null);
            break;
        case 9:
            g2d.drawImage(data.getFruitSprites()[2], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[3], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[3], 168, 278, null);
            g2d.drawImage(data.getFruitSprites()[4], 156, 278, null);
            g2d.drawImage(data.getFruitSprites()[4], 144, 278, null);
            g2d.drawImage(data.getFruitSprites()[5], 132, 278, null);
            break;
        case 10:
            g2d.drawImage(data.getFruitSprites()[3], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[3], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[4], 168, 278, null);
            g2d.drawImage(data.getFruitSprites()[4], 156, 278, null);
            g2d.drawImage(data.getFruitSprites()[5], 144, 278, null);
            g2d.drawImage(data.getFruitSprites()[5], 132, 278, null);
            break;
        case 11:
            g2d.drawImage(data.getFruitSprites()[3], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[4], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[4], 168, 278, null);
            g2d.drawImage(data.getFruitSprites()[5], 156, 278, null);
            g2d.drawImage(data.getFruitSprites()[5], 144, 278, null);
            g2d.drawImage(data.getFruitSprites()[6], 132, 278, null);
            break;
        case 12:
            g2d.drawImage(data.getFruitSprites()[4], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[4], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[5], 168, 278, null);
            g2d.drawImage(data.getFruitSprites()[5], 156, 278, null);
            g2d.drawImage(data.getFruitSprites()[6], 144, 278, null);
            g2d.drawImage(data.getFruitSprites()[6], 132, 278, null);
            break;
        case 13:
            g2d.drawImage(data.getFruitSprites()[4], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[5], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[5], 168, 278, null);
            g2d.drawImage(data.getFruitSprites()[6], 156, 278, null);
            g2d.drawImage(data.getFruitSprites()[6], 144, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 132, 278, null);
            break;
        case 14:
            g2d.drawImage(data.getFruitSprites()[5], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[5], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[6], 168, 278, null);
            g2d.drawImage(data.getFruitSprites()[6], 156, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 144, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 132, 278, null);
            break;
        case 15:
            g2d.drawImage(data.getFruitSprites()[5], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[6], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[6], 168, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 156, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 144, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 132, 278, null);
            break;
        case 16:
            g2d.drawImage(data.getFruitSprites()[6], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[6], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 168, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 156, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 144, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 132, 278, null);
            break;
        case 17:
            g2d.drawImage(data.getFruitSprites()[6], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 168, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 156, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 144, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 132, 278, null);
            break;
        default:
            g2d.drawImage(data.getFruitSprites()[7], 192, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 180, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 168, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 156, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 144, 278, null);
            g2d.drawImage(data.getFruitSprites()[7], 132, 278, null);
            break;
        }
    }
}
