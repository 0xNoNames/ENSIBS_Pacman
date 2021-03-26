package Pacman.IModelData;

import Pacman.Model.Fruit;

/**
 * L'interface IFruit permet au Model d'obtenir des informations concernant
 * l'apparition de Fruit dans les niveaux.
 * 
 * @author Louis-Baptiste Sobolewski
 */
public interface IFruit {
    /**
     * Permet d'obtenir le Fruit à faire apparaitre en fonction du numéro du
     * niveau actuel (puisqu'à chaque niveau correspond un type de Fruit).
     * 
     * @param niveau niveau pour lequel on veut obtenir le Fruit correspondant
     * @return Fruit correspondant au niveau passé
     */
    public Fruit getFruitNiveau(int niveau);
}
