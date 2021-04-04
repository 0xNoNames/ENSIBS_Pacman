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
     * 0: fermé, 1: ouvert
     * @return Tableau d'Image
     */
    public Image[] getPacmanSprites(EDirection direction);

    /**
     * Permet d'obtenir un tableau des sprites de l'animation de mort de Pacman
     * Du plus gros au plus "décrépi", total 11 sprites
     * 
     * @return Tableau d'Image
     */
    public Image[] getMortPacmanSprites();

    /**
     * Permet d'obtenir un tableau des sprites d'un Fantome dans l'ordre :
     * 0: arrondi
     * 1: droit
     * 
     * @param couleur couleur du fantôme demandé
     * @return Tableau d'Image
     */
    public Image[] getFantomesSprites(ECouleur couleur, EDirection direction);

    /**
     * Permet d'obtenir un tableau des sprites d'un Fantome vulnérable
     * 0: arrondi
     * 1: droit
     * 
     * @return Tableau d'image
     */
    public Image[] getVulnerableFantomesSprites();

    /**
     * Permet d'obtenir un tableau des sprites de l'animation de mort d'un Fantome
     * 0: arrondi
     * 1:droit
     * 
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
