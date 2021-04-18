package Pacman.Logic;

/**
 * EStatutFantome représente les différents états de la vie d'un Fantome
 * 
 * @author Louis-Baptiste Sobolewski
 */
public enum EStatutFantome {
    /**
     * Le Fantome est vivant, en recherche de Pacman
     */
    CHASSEUR,

    /**
     * Le Fantome est vulnérable, mangeable par Pacman
     */
    VULNERABLE,

    /**
     * Le Fantome a été mangé par Pacman et retourne à son camp
     */
    MORT,

    /**
     * La Fantome est dans le bloc au milieu de la grille en début de Partie
     */
    DEBUTPARTIE
}
