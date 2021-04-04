package Pacman.Data;

import Pacman.Logic.Grille;
import Pacman.Logic.Pacman;

/**
 * L'interface IGrille permet au Model d'obtenir les informations concernant la
 * Grille de jeu.
 * 
 * @author Louis-Baptiste Sobolewski
 */
public interface IGrille {
    /**
     * Permet d'obtenir la Grille initalisée contenant toutes les Gommes ainsi
     * que Pacman et les 4 Fantomes à leurs positions initiales.
     * 
     * @param pacman le Pacman est passé en argument pour pouvoir conserver ses
     * attributs, notamment le nombre de vies. C'est une erreur de notre
     * modélisation.
     * @return Grille représentant l'instant 0 d'un niveau et dont tous les
     * attributs sont instanciés
     */
    public Grille getGrilleInitiale(Pacman pacman);
}
