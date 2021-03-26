package Pacman.Logic;

/**
 * EStatutPartie représente l'état de la partie
 * 
 * @author Louis-Baptiste Sobolewski
 */
public enum EStatutPartie {
	/**
	 * La partie n'est ni en cours ni terminée : initialisation d'un niveau,
	 * animation de perte de vie de Pacman...
	 */
	EN_PAUSE,

	/**
	 * La partie est en cours, Pacman se déplace dans la Grille
	 */
	EN_COURS,

	/**
	 * Pacman a perdu toutes ses vies, la partie est terminée, on affiche les
	 * scores
	 */
	TERMINEE
}
