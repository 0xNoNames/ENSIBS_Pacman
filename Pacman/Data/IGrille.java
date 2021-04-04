package Pacman.Data;

import Pacman.Logic.Grille;

/**
 * L'interface IGrille permet au Model d'obtenir les informations concernant la
 * Grille de jeu.
 * 
 * @author Louis-Baptiste Sobolewski
 */
public interface IGrille {
    /**
     * Permet d'obtenir la Grille initalisée contenant toutes les Gommes ainsi
     * que Pacman et les 4 Fantomes à leurs positions initiales. // TODO vérifier
     * 
     * @return Grille représentant l'instant 0 d'un niveau et dont tous les
     * attributs sont instanciés
     */
    public Grille getGrilleInitiale();
}
