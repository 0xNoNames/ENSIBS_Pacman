package Pacman.Logic;


/**
 * L'interface ICase permet à la View d'obtenir les informations concernant
 * la case actuelle.
 *
 * @author Arthur Pêtre
 */
public interface ICase {
    /**
     * Permet de récupérer ce qui ce trouve dans la case actuellement.
     *
     * @return retourne un type Objet.
     */
    public Objet getObjet();
}