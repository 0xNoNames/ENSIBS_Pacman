package Pacman.Data;

import java.awt.Image;
import Pacman.Logic.ECouleur;
import Pacman.Logic.EDirection;

/**
 * L'interface ISprites permet à la View d'obtenir les sprites des différentes
 * éléments à partir de la Data.
 * 
 * @author Arthur Pêtre
 */
public interface ISprites {
    /**
     * Permet d'obtenir un tableau des sprites de Pacman, dans l'ordre :
     * 0: plein
     * 1: gauche fermé, 2: gauche ouvert
     * 3: droite fermé, 4: droite ouvert
     * 5:   haut fermé, 6:   haut ouvert
     * 7:    bas fermé, 8:    bas ouvert
     * 
     * @return Tableau d'Image
     */
    public Image[] getPacmanSprites();

    /**
     * Permet d'obtenir un tableau des sprites de l'animation de mort de Pacman
     * Du plus gros au plus "décrépi", total 11 sprites
     * 
     * @return Tableau d'Image
     */
    public Image[] getMortPacmanSprites();

    /**
     * Permet d'obtenir un tableau des sprites d'un Fantome (les derniers sprites
     * sont ceux l'état de vulnérable bleu), dans l'ordre :
     *  0: rouge   haut arrondi,  1:   rouge haut droit
     *  2: rouge    bas arrondi,  3:   rouge  bas droit
     *  4: rouge gauche arrondi,  5: rouge gauche droit
     *  6: rouge droite arrondi,  7: rouge droite droit
     *  8:  rose   haut arrondi,  9:  rose   haut droit
     * 10:  rose    bas arrondi, 11:  rose    bas droit
     * 12:  rose gauche arrondi, 13:  rose gauche droit
     * 14:  rose droite arrondi, 15:  rose droite droit
     * 16:  bleu   haut arrondi, 17:  bleu   haut droit
     * 18:  bleu    bas arrondi, 19:  bleu    bas droit
     * 20:  bleu gauche arrondi, 21:  bleu gauche droit
     * 22:  bleu droite arrondi, 23:  bleu droite droit
     * 24: jaune   haut arrondi, 25: jaune   haut droit
     * 26: jaune    bas arrondi, 27: jaune    bas droit
     * 28: jaune gauche arrondi, 29: jaune gauche droit
     * 30: jaune droite arrondi, 31: jaune droite droit
     * 32: vulnérable   arrondi, 33: vulnérable   droit
     * 
     * @param couleur couleur du fantôme demandé
     * @return Tableau d'Image
     */
    public Image[] getFantomesSprites(ECouleur couleur, EDirection direction);

    public Image[] getVulnerableFantomesSprites();

    /**
     * Permet d'obtenir un tableau des sprites de l'animation de mort d'un Fantome
     * 0: mort arrondi, 1: mort droit
     * @return Tableau d'Image
     */
    public Image[] getMortFantomeSprites();

    /**
     * Permet d'obtenir un tableau des sprites des Gommes (grosse ou petite)
     * 0: petite gomme, 1: grosse gomme
     * 
     * @return Tableau d'Image
     */
    public Image[] getGommesSprites();

    /**
     * Permet d'obtenir un tableau des sprites des différents fruits (du plus commun
     * au plus rare)
     * 0: cerise, 1:       fraise, 2: orange, 3: pomme
     * 4:  melon, 5: galaxianboss, 6: cloche, 7:   clé
     * 
     * @return Tableau d'Image
     */
    public Image[] getFruitSprites();

    /**
     * Permet d'obtenir un tableau des sprites des différentes lettres et chiffres
     * de 0: 0 à 9: 9
     * 
     * @return Tableau d'Image
     */
    public Image[] getLettresChiffres();

    /**
     * Permet d'obtenir un tableau des sprites des différents points, dans l'ordre :
     * 0: 100, 1: 300,  2: 500,  3:  700, 4: 1000, 5: 2000, 6: 3000, 7: 5000
     * 8: 200, 9: 400, 10: 800, 11: 1600
     * 
     * @return Tableau d'Image
     */
    public Image[] getPoints();

    /**
     * Permet d'obtenir le sprite de la grille
     * 
     * @return Image
     */
    public Image getGrille();

    /**
     * Permet d'obtenir le sprite du READY, du GAME OVER et du 1UP
     * 
     * @return Tableau d'Image
     */
    public Image[] getRGOSprite();

}
