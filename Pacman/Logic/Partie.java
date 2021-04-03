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
	
	/**
	 * 
	 */
	private int temps_partie;

	/*
	 * 
	 */
	public Partie() {
		DataForLogic d = new DataForLogic();
		this.Grille = d.getGrilleInitiale();
		this.Score = 0;
		this.Niveau = 0;
		this.temps_partie = 300;
		this.EtatPartie = EStatutPartie.EN_PAUSE;
	}

	/**
     * Permet d'avancer dans le temps.
     */
    public void tick() {
		Pacman pac = this.Grille.getPacman();
		Blinky blinky = this.Grille.getBlinky();
		Inky inky = this.Grille.getInky();
		Clyde clyde = this.Grille.getClyde();
		Pinky pinky = this.Grille.getPinky();
		while(temps_partie!=0 && this.getVies()>0) {
			pac.deplacer();
			pinky.deplacer(pac);
			inky.deplacer(pac);
			blinky.deplacer(pac);
			clyde.deplacer();
			
		}
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
		return this.Grille.getPacman().getVie();
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
		return this.Grille.getCases();
	}
}
