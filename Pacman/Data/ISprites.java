package Pacman.Data;

import java.awt.Image;
import Pacman.Logic.ECouleur;

/**
 * L'interface ISprites permet à la View d'obtenir les sprites des différentes
 * éléments à partir de la Data.
 * 
 * @author Arthur Pêtre
 */
public interface ISprites {
    /**
     * Permet d'obtenir un tableau des sprites de Pacman
     * 
     * @return Tableau d'Image
     */
    public Image[] getPacmanSprites();

    /**
     * Permet d'obtenir un tableau des sprites de l'animation de mort de Pacman
     * 
     * @return Tableau d'Image
     */
    public Image[] getMortPacmanSprites();

    /**
     * Permet d'obtenir un tableau des sprites d'un Fantome (les derniers sprites
     * sont ceux l'état de vulnérable bleu)
     * 
     * @param couleur couleur du fantôme demandé
     * @return Tableau d'Image
     */
    public Image[] getFantomesSprites(ECouleur couleur);

    /**
     * Permet d'obtenir un tableau des sprites de l'animation de mort d'un Fantome
     * 
     * @return Tableau d'Image
     */
    public Image[] getMortFantomeSprites();

    /**
     * Permet d'obtenir un tableau des sprites des Gommes (grosse ou petite)
     * 
     * @return Tableau d'Image
     */
    public Image[] getGommesSprites();

    /**
     * Permet d'obtenir un tableau des sprites des différents fruits (du plus commun
     * au plus rare)
     * 
     * @return Tableau d'Image
     */
    public Image[] getFruitSprites();

    /**
     * Permet d'obtenir un tableau des sprites des différentes lettres et chiffres
     * 
     * @return Tableau d'Image
     */
    public Image[] getLettresChiffres();

    /**
     * Permet d'obtenir un tableau des sprites des différents points (100, 300, 500, 700, 1000, 2000, 3000, 5000)
     * 
     * @return Tableau d'Image
     */
    public Image[] getPoints();

    /**
     * Permet d'obtenir un tableau des sprites des murs
     * 
     * @return Tableau d'Image
     */
    public Image[] getMur();

    /**
     * Permet d'obtenir le sprite du READY, du GAME OVER et du 1UP 
     * 
     * @return Tableau d'Image
     */
    public Image[] getRGOSprite();

}