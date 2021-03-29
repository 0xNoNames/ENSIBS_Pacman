package Pacman.Logic;
import Pacman.Data.DataForLogic;

/**
 * 
 * 
 * @author François JULLION
 */
public class Partie implements IPartie{

	/*
	 *
	 */
	public static DataForLogic d;

	/*
	 * 
	 */
	private Grille Grille;
	
	/*
	 * 
	 */
	private int Score;
	
	/*
	 * 
	 */
	private int Niveau;
	
	/*
	 * 
	 */
	private EStatutPartie EtatPartie;
	
	/*
	 * 
	 */
	public Partie() {
		DataForLogic d = new DataForLogic();
		this.Grille = d.getGrilleInitiale();
		this.Score = 0;
		this.Niveau = 0;
		this.EtatPartie = EStatutPartie.EN_PAUSE;
	}

	/**
     * Permet d'avancer dans le temps.
     */
    public void tick() {
		/* TODO */
	}

    /**
     * Permet d'initialiser la partie.
     */
    public void initialisation() {
		this.Grille = d.getGrilleInitiale();
		this.Niveau ++;
		this.EtatPartie = EStatutPartie.EN_COURS;
	}

    /**
     * Permet de récupérer à quel niveau actuel le joueur est.
     *
     * @return retourne un entier représentant le niveau.
     */
    public int getNiveau() {
		return this.Niveau;
	}

    /**
     * Permet de récupérer le nombre de vies restante du joueur.
     *
     * @return retourne un entier représentant les vies du joueurs.
     */
    public int getVies() {
		/* TODO */
		return 0;
	}

    /**
     * Permet de récupérer le score actuel du joueur.
     *
     * @return retourne un entier représentant le score du joueur.
     */
    public int getScore() {
		return this.Score;
	}

    /**
     * Permet de récupérer l'état de la partie.
     *
     * @return retourne une valeur de type EStatusPartie.
     */
    public EStatutPartie getEtatPartie() {
		return this.EtatPartie;
	}

    /**
     * Permet de récupérer la grille actuelle.
     *
     * @return retourne une matrice de Case.
     */
    public Case[][] getGrille() {
		/* TODO */
		return this.Grille.get;
	}
}
