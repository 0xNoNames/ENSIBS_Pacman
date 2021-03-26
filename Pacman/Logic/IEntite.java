package Pacman.Logic;

/**
 * L'interface IEntite permet à la View d'obtenir les informations concernant
 * les entités de la grille.
 *
 * @author Arthur Pêtre
 */
public interface IEntite {

    /**
     * Permet de récupérer la position actuelle de l'entité.
     *
     * @return un tableau de double de dimension 2.
     */
    public double[] getPosition();

    /**
     * Permet de récupérer l'état d'un Fantome.
     *
     * @return retourne une valeur de type EStatusFantome.
     */
    public EStatutFantome getStatut();

    /**
     * Permet de récupérer la couleur d'un Fantome.
     *
     * @return retourne une valeur de type ECouleur.
     */
    public ECouleur getCouleur();

    /**
     * Permet de récupérer la direction courante du joueur.
     *
     * @return retourne une valeur de type EDirection.
     */
    public EDirection getDirectionCourante();

    /**
     * Permet de récupérer la direction voulue du joueur.
     *
     * @return retourne une valeur de type EDirection.
     */
    public EDirection getDirectionVoulue();
}
