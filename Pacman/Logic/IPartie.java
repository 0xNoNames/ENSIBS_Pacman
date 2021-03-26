package Pacman.Logic;

/**
 * L'interface IPartie permet à la View d'obtenir les informations concernant
 * les états d'une partie en cours.
 *
 * @author Arthur Pêtre
 */
public interface IPartie {
    /**
     * Permet d'avancer dans le temps.
     */
    public void tick();

    /**
     * Permet d'initialiser la partie.
     */
    public void initialisation();

    /**
     * Permet de récupérer à quel niveau actuel le joueur est.
     *
     * @return retourne un entier représentant le niveau.
     */
    public int getNiveau();

    /**
     * Permet de récupérer le nombre de vies restante du joueur.
     *
     * @return retourne un entier représentant les vies du joueurs.
     */
    public int getVies();

    /**
     * Permet de récupérer le score actuel du joueur.
     *
     * @return retourne un entier représentant le score du joueur.
     */
    public int getScore();

    /**
     * Permet de récupérer l'état de la partie.
     *
     * @return retourne une valeur de type EStatusPartie.
     */
    public EStatutPartie getEtatPartie();

    /**
     * Permet de récupérer la grille actuelle.
     *
     * @return retourne une matrice de Case.
     */
    public Case[][] getGrille();
}