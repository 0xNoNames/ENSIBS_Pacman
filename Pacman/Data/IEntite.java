package Pacman.Data;

import Pacman.Logic.ECouleur;

/**
 * L'interface IEntite permet à la Data d'obtenir les informations concernant
 * les entités.
 * 
 * @author Louis-Baptiste Sobolewski
 */
public interface IEntite {
    /**
     * Permet d'obtenir la vitesse de Pacman en fonction du niveau atteint.
     * 
     * @param niveau niveau pour lequel on désire la vitesse de Pacman
     * @return vitesse de Pacman en cases par seconde
     */
    public double getVitessePacman(int niveau);

    /**
     * Permet d'obtenir la vitesse des Fantome en fonction du niveau atteint.
     * 
     * @param niveau niveau pour lequel on désire la vitesse des Fantome
     * @return vitesse des Fantome en cases par seconde
     */
    public double getVitesseFantome(int niveau, ECouleur couleur);

    /**
     * Permet d'obtenir la position initiale de Pacman dans la Grille à
     * l'instant 0 d'un niveau
     * 
     * @return tableau de deux réels où [0] = posX et [1] = posY
     */
    public double[] getPositionInitialePacman();

    /**
     * Permet d'obtenir la position initiale des Fantome dans la Grille à
     * l'instant 0 d'un niveau
     * 
     * @return talbeau de deux réels où [0] = posX et [1] = posY
     */
    public double[] getPositionInitialeFantome();
}
