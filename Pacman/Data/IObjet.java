package Pacman.Data;

import Pacman.Logic.Objet;

/**
 * L'interfacte IObjet permet à la Data d'obtenir les informations concernant
 * les différents Objet pouvant se trouver dans les Cases (à savoir les gommes
 * et les Fruit)
 * 
 * @author Louis-Baptiste Sobolewski
 */
public interface IObjet {
    /**
     * Permet d'obtenir la valeur en points d'un Objet (gommes et Fruit)
     * 
     * @param objet Objet duquel on veut la valeur en points
     * @return entier représentant la valeur en points de l'Objet passé
     */
    public int getPoints(Objet objet);
}
