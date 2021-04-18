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
	 * Pacman perd une vie, tous les personnages sont repositionnés à leurs places
	 * initiales mais les gommes mangées restent mangées.
	 */
	EN_ANIMATION_PACMORT,

	/**
	 * Lorsque un fantome meurt, une animation est réalisée.
	 */
	EN_ANIMATION_FANMORT,

	/**
	 * Animation au début du niveau.
	 */
	EN_ANIMATION_DEBUT,

	/**
	 * Animation à la fin d'un niveau.
	 */
	EN_ANIMATION_FIN,
	
	/**
	 * Fin de la partie lorsque pacman n'a plus de vies.
	 */
	EN_ANIMATION_GAME_OVER;

}
