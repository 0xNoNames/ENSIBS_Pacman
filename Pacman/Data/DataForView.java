package Pacman.Data;

import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import Pacman.Logic.ECouleur;
import Pacman.Logic.EDirection;

/**
 * DataForView stocke les différentes données susceptibles d'être demandées par
 * la View. Elle agit comme un cache.
 * 
 * @author Louis-Baptiste Sobolewski
 */
public class DataForView implements ISprites {
    /**
     * Chemin vers la spritemap
     */
    private static String cheminSpriteComplet = "sprites.png";

    /**
     * Spritemap sous forme de java.awt.image.BufferedImage
     */
    private BufferedImage spriteComplet;

    /**
     * Tableau des sprites de Pacman 0: gauche fermé, 1: gauche ouvert 2: droite
     * fermé, 3: droite ouvert 4: haut fermé, 5: haut ouvert 6: bas fermé, 7: bas
     * ouvert, 8: rond
     */
    private Image[] pacmanSprites;

    /**
     * Tableau des sprites de Pacman qui meurt (11 sprites)
     */
    private Image[] mortPacmanSprites;

    /**
     * Tableau des sprites des Fantomes 0: rouge haut arrondi, 1: rouge haut droit
     * 2: rouge bas arrondi, 3: rouge bas droit 4: rouge gauche arrondi, 5: rouge
     * gauche droit 6: rouge droite arrondi, 7: rouge droite droit 8: rose haut
     * arrondi, 9: rose haut droit 10: rose bas arrondi, 11: rose bas droit 12: rose
     * gauche arrondi, 13: rose gauche droit 14: rose droite arrondi, 15: rose
     * droite droit 16: bleu haut arrondi, 17: bleu haut droit 18: bleu bas arrondi,
     * 19: bleu bas droit 20: bleu gauche arrondi, 21: bleu gauche droit 22: bleu
     * droite arrondi, 23: bleu droite droit 24: jaune haut arrondi, 25: jaune haut
     * droit 26: jaune bas arrondi, 27: jaune bas droit 28: jaune gauche arrondi,
     * 29: jaune gauche droit 30: jaune droite arrondi, 31: jaune droite droit 32:
     * vulnérable arrondi, 33: vulnérable droit 34: vulnerable blanc arrondi,
     * 35: vulnerable blanc droit, 36: mort haut, 37: mort bas, 38: mort gauche,
     * 39: mort droit
     */
    private Image[] fantomesSprites;

    /**
     * Tableau des sprites des Gommes 0: petite gomme, 1: grosse gomme
     */
    private Image[] gommesSprites;

    /**
     * Tableau des sprites des Fruits 0: cerise, 1: fraise, 2: orange, 3: pomme 4:
     * melon, 5: galaxianboss, 6: cloche, 7: clé
     */
    private Image[] fruitSprites;

    /**
     * Tableau des sprites des points 0: 100, 1: 300, 2: 500, 3: 700, 4: 1000, 5:
     * 2000, 6: 3000, 7: 5000 8: 200, 9: 400, 10: 800, 11: 1600
     */
    private Image[] pointsSprites;

    /**
     * Tableau des sprites des chiffres et des lettres de 0 à 9
     */
    private Image[] lettresChiffresSprites;

    /**
     * Tableau des sprites, dans l'ordre, READY, GAME OVER, 1UP et SCORE
     */
    private Image[] rgoSprites;

    /**
     * Sprite de la grille
     */
    private Image grilleSprite;

    public DataForView() {
        try {
            spriteComplet = (BufferedImage) ImageIO.read(
                DataForView.class.getResourceAsStream(cheminSpriteComplet)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Image[] getPacmanSprites(EDirection direction) {
        // si ces sprites n'ont pas encore été demandés
        if (pacmanSprites == null) {
            pacmanSprites = new Image[9];

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 2; j++) {
                    pacmanSprites[2 * i + j] = spriteComplet.getSubimage(
                        1 + 20 * j, 4 + 20 * i, 16, 16
                    );
                }
            }

            pacmanSprites[8] = spriteComplet.getSubimage(41, 4, 16, 16);
        }

        // on trouve où sont les sprites qui nous intéressent
        int indice = 0;
        switch (direction) {
        case OUEST:
            // pour l'OUEST ça reste à 0
            break;
        case EST:
            indice += 2;
            break;
        case NORD:
            indice += 4;
            break;
        case SUD:
            indice += 6;
            break;
        }

        // on retourne
        Image[] retour = { pacmanSprites[indice], pacmanSprites[indice + 1],
            pacmanSprites[8] };
        return retour;
    }

    @Override
    public Image[] getMortPacmanSprites() {
        // si ces sprites n'ont pas encore été demandés
        if (mortPacmanSprites == null) {
            mortPacmanSprites = new Image[11];

            // tous ces sprites sont sur la même ligne
            for (int i = 0; i < mortPacmanSprites.length; i++) {
                mortPacmanSprites[i] = spriteComplet.getSubimage(
                    1 + 20 * i, 245, 16, 16
                );
            }
        }

        return mortPacmanSprites;
    }

    /**
     * Découpe tous les sprites des fantômes et les place dans fantomesSprites
     */
    private void chargerFantomesSprites() {
        fantomesSprites = new Image[40];

        // les fantomes normaux sont sur 4 lignes 8 colonnes
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                fantomesSprites[i * 8 + j] = spriteComplet.getSubimage(
                    1 + 20 * j, 84 + 20 * i, 16, 16
                );
            }
        }

        // les fantomes vulnérables
        for (int i = 32; i < 36; i++) {
            fantomesSprites[i] = spriteComplet.getSubimage(
                1 + 20 * (i - 32), 164, 16, 16
            );
        }

        // les fantomes morts sont sur une ligne
        for (int i = 36; i < 40; i++) {
            fantomesSprites[i] = spriteComplet.getSubimage(
                1 + 20 * (i - 36), 205, 16, 16
            );
        }
    }

    @Override
    public Image[] getFantomesSprites(ECouleur couleur, EDirection direction) {
        // si ces sprites n'ont pas encore été demandés
        if (fantomesSprites == null) {
            chargerFantomesSprites();
        }

        // on trouve où sont les sprites qui nous intéressent
        int indice = 0;
        switch (couleur) {
        case ROUGE:
            // pour le ROUGE ça reste à 0
            break;
        case ROSE:
            indice += 8;
            break;
        case CYAN:
            indice += 16;
            break;
        case ORANGE:
            indice += 24;
            break;
        }
        switch (direction) {
        case NORD:
            // pour le NORD ça reste à 0
            break;
        case SUD:
            indice += 2;
            break;
        case OUEST:
            indice += 4;
            break;
        case EST:
            indice += 6;
            break;
        }

        // on retourne
        Image[] retour =
            { fantomesSprites[indice], fantomesSprites[indice + 1] };
        return retour;
    }

    @Override
    public Image[] getVulnerableFantomesSprites() {
        if (fantomesSprites == null) {
            chargerFantomesSprites();
        }

        Image[] retour =
            { fantomesSprites[32], fantomesSprites[33],
            fantomesSprites[34], fantomesSprites[35]};
        return retour;
    }

    @Override
    public Image getMortFantomeSprites(EDirection direction) {
        // si ces sprites n'ont pas encore été demandés
        if (fantomesSprites == null) {
            chargerFantomesSprites();
        }

        switch (direction)
        {
            case NORD:
                return fantomesSprites[36];
            case SUD:
                return fantomesSprites[37];
            case OUEST:
                return fantomesSprites[38];
            case EST:
                return fantomesSprites[39];
            /* toutes les valeurs de l'enum sont au dessus, on ne passera
            jamais ici */
            default:
                return null;
        }
    }

    @Override
    public Image[] getGommesSprites() {
        // si ces sprites n'ont pas encore été demandés
        if (gommesSprites == null) {
            gommesSprites = new Image[2];

            gommesSprites[0] = spriteComplet.getSubimage(112, 184, 7, 7);
            gommesSprites[1] = spriteComplet.getSubimage(1, 184, 8, 8);
        }

        return gommesSprites;
    }

    @Override
    public Image[] getFruitSprites() {
        // si ces sprites n'ont pas encore été demandés
        if (fruitSprites == null) {
            fruitSprites = new Image[8];

            // ces sprites sont répartis en 4 lignes 2 colonnes
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 2; j++) {
                    fruitSprites[i + 4 * j] = spriteComplet.getSubimage(
                        169 + 40 * j, 164 + 20 * i, 16, 16
                    );
                }
            }
        }

        return fruitSprites;
    }

    @Override
    public Image[] getLettresChiffres() {
        // si ces sprites n'ont pas encore été demandés
        if (lettresChiffresSprites == null) {
            lettresChiffresSprites = new Image[10];

            // ces sprites sont tous en ligne
            for (int i = 0; i < 10; i++) {
                lettresChiffresSprites[i] = spriteComplet.getSubimage(
                    12 + 10 * i, 184, 7, 7
                );
            }
        }

        return lettresChiffresSprites;
    }

    @Override
    public Image[] getPoints() {
        // si ces sprites n'ont pas encore été demandés
        if (pointsSprites == null) {
            pointsSprites = new Image[12];

            // ces sprites sont en partie en colonne...
            for (int i = 0; i < 8; i++) {
                pointsSprites[i] = spriteComplet.getSubimage(
                    166, 7 + i * 20, 22, 9
                );
            }

            // ...et en partie en ligne
            for (int i = 8; i < 12; i++) {
                pointsSprites[i] = spriteComplet.getSubimage(
                    1 + (i - 8) * 20, 227, 17, 9
                );
            }
        }

        return pointsSprites;
    }

    @Override
    public Image getGrille() {
        // si ce sprite n'a pas encore été demandé
        if (grilleSprite == null) {
            grilleSprite = spriteComplet.getSubimage(321, 28, 224, 248);
        }

        return grilleSprite;
    }

    @Override
    public Image[] getRGOSprite() {
        // si ces sprites n'ont pas encore été demandés
        if (rgoSprites == null) {
            rgoSprites = new Image[4];

            rgoSprites[0] = spriteComplet.getSubimage(201, 3, 48, 9);
            rgoSprites[1] = spriteComplet.getSubimage(11, 193, 81, 9);
            rgoSprites[2] = spriteComplet.getSubimage(214, 73, 24, 9);
            rgoSprites[3] = spriteComplet.getSubimage(433, 3, 41, 9);
        }

        return rgoSprites;
    }
}
