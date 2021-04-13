package Pacman.Logic;

import Pacman.Data.DataForLogic;

/**
 * Classe représentant une partie de jeu
 * 
 * @author François JULLION
 */
public class Partie implements IPartie {

	/**
	 * Variable permettant de récuperer les outils de la couche Data
	 */
	public static DataForLogic d;

	/**
	 * Variable représentant le nombre entier de tick par Seconde
	 */
	public static int tickParSeconde = 60;

	/*
	 * Variable représentant la grille de jeu
	 */
	private Grille grille;

	/*
	 * Variable représentant le score actuel de la partie
	 */
	private int score;

	/*
	 * Variable représentant le niveau actuel de la partie
	 */
	private int niveau;

	/*
	 * Variable représentant l'état de la partie actuelle
	 */
	private EStatutPartie etatPartie;

	/**
	 * Variable représentant le nombre de tick total effectué pendant la partie
	 */
	private int compteurPartie;

	/**
	 * Variable représentant le pacman de la partie
	 */
	private Pacman pac;

	/**
	 * Constructeur de la classe Partie
	 */
	public Partie() {
		Partie.d = new DataForLogic();
		this.pac = new Pacman();
		this.grille = d.getGrilleInitiale(pac);
		this.score = 0;
		this.niveau = 0;
		this.compteurPartie = 0;
		this.etatPartie = EStatutPartie.EN_PAUSE;
	}

	/**
	 * Permet d'initialiser la partie.
	 */
	public void initialisation() {
		this.grille = d.getGrilleInitiale(pac);
		this.niveau++;
		this.etatPartie = EStatutPartie.EN_COURS;
	}

	/**
	 * Permet de récupérer à quel niveau actuel le joueur est.
	 *
	 * @return retourne un entier représentant le niveau.
	 */
	public int getNiveau() {
		return this.niveau;
	}

	/**
	 * Permet de récupérer le nombre de vies restante du joueur.
	 *
	 * @return retourne un entier représentant les vies du joueurs.
	 */
	public int getVies() {
		return this.grille.getPacman().getVie();
	}

	/**
	 * Permet de récupérer le score actuel du joueur.
	 *
	 * @return retourne un entier représentant le score du joueur.
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * Permet de récupérer l'état de la partie.
	 *
	 * @return retourne une valeur de type EStatusPartie.
	 */
	public EStatutPartie getEtatPartie() {
		return this.etatPartie;
	}

	/**
	 * Permet de récupérer la grille actuelle.
	 *
	 * @return retourne une matrice de Case.
	 */
	public Grille getGrille() {
		return this.grille;
	}

	/**
	 * Permet d'avancer dans le temps.
	 */
	public void tick() {
		if (etatPartie == EStatutPartie.EN_COURS) {
			/* Récupération des entités de la grille */
			Blinky blinky = this.grille.getBlinky();
			Inky inky = this.grille.getInky();
			Clyde clyde = this.grille.getClyde();
			Pinky pinky = this.grille.getPinky();
			/* Définition de la partie pour chaque entité */
			pac.setPartie(this);
			blinky.setPartie(this);
			inky.setPartie(this);
			clyde.setPartie(this);
			pinky.setPartie(this);
			/* Récupération du tableau de case de la grille */
			Case[][] tab = this.grille.getCases();
			/* Définition d'un tableau représentant l'ensemble des fantomes */
			Fantome[] fantomes = { inky, clyde, pinky, blinky };
			while (this.niveau <= 256 && this.getVies() > 0) {
				pac.deplacer();
				pinky.deplacer(pac);
				inky.deplacer(pac);
				blinky.deplacer(pac);
				clyde.deplacer();
				/* Pacman mange */
				int pacX = (int) pac.posX;
				int pacY = (int) pac.posY;
				Jouable pacCase = (Jouable) tab[pacX][pacY];
				if (pacCase.getObjet() != null) {
					Objet o = pacCase.getObjet();
					this.score += d.getPoints(o);
					if (o instanceof GrosseGomme) {
						for (Fantome f : fantomes) {
							f.setStatut(EStatutFantome.VULNERABLE);
						}
					}
				}
				/* Fantom meme case pacman */
				for (Fantome f : fantomes) {
					int fantomeX = (int) f.getposX();
					int fantomeY = (int) f.getposY();
					if (fantomeX == pacX && fantomeY == pacY) {
						if (f.getStatut() == EStatutFantome.CHASSEUR) {
							pac.meurt();
						} else if (f.getStatut() == EStatutFantome.VULNERABLE) {
							f.meurt();
							if (this.compteurPartie - pac.getTickDernierFantomeMange() < tickParSeconde * 1.5) {
								pac.setCompteurCombo(pac.getCompteurCombo() + 1);
							} else {
								pac.setCompteurCombo(1);
							}
							this.score += d.getPointsCombo(pac.getCompteurCombo());
							pac.setTickDernierFantomeMange(compteurPartie);
						}
					}
				}
				/* Grille contient encore des pacGommes */
				if (noGomme()) {
					this.etatPartie = EStatutPartie.EN_PAUSE;
					this.initialisation();
				}
				compteurPartie++;
			}
		}
	}

	/**
	 * Permet de savoir si il ne reste pas de gomme sur la grille
	 * 
	 * @return retourne un boolean indiquant si il n'y a plus de gommes sur la
	 *         grille
	 */
	private boolean noGomme() {
		Case[][] tab = this.grille.getCases();
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; i++) {
				if (tab[i][j] instanceof Jouable) {
					Jouable jouable = (Jouable) tab[i][j];
					if (jouable.getObjet() != null) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
