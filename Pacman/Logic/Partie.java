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
	 * Variable indiquant si les fantome sont vulnerable ou pas
	 */
	private boolean fantomeVulnerable;

	/**
	 * Variable représentant le nombre de tick pendant lequel les fantomes sont
	 * vulnerable
	 */
	private int compteurVulnerable;

	/**
	 * Variable indiquant le nombre de tick pendant lequel le fruit apparait
	 */
	private int tickSpawnFruit;

	/**
	 * Variable indiquant le nombre de gommes mangé par PacMan
	 */
	private int compteurGomme;

	/**
	 * Variable indiquant si le fruit est apparu
	 */
	private boolean fruitSpawn;

	/**
	 * Variable indiquant si pacman est mort
	 */
	private boolean mortPacman;

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
		this.etatPartie = EStatutPartie.EN_ANIMATION_DEBUT;
		this.fantomeVulnerable = false;
		this.compteurVulnerable = 0;
		this.tickSpawnFruit = 600;
	}

	/**
	 * Permet d'initialiser la partie.
	 */
	public void initialisation() {
		this.grille = d.getGrilleInitiale(pac);
		this.niveau++;
		this.etatPartie = EStatutPartie.EN_ANIMATION_DEBUT;
		this.compteurGomme = 0;
		this.compteurVulnerable = 0;
		this.fruitSpawn = false;
		this.fantomeVulnerable = false;
		this.mortPacman = false;
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
	 * Permet de fixer l'état de la partie.
	 * 
	 * @param etat l'état de la partie voulue
	 */
	public void setEtatPartie(EStatutPartie etat) {
		this.etatPartie = etat;
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
	 * Permet de récupérer le nombre de tick pendant lequel les fantomes sont
	 * vulnérable
	 * 
	 * @return entier
	 */
	public int getCompteurVulnerable() {
		return this.compteurVulnerable;
	}

	/**
	 * Permet d'avancer dans le temps.
	 */
	public void tick() {
		if (mortPacman) {
			int x = (int) d.getPositionInitialePacman()[0];
			int y = (int) d.getPositionInitialePacman()[1];
			pac.setPosX(x);
			pac.setPosY(y);
			pac.setDirectionCourante(EDirection.OUEST);
			pac.setDirectionVoulue(EDirection.OUEST);
			mortPacman = false;
		}
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
		/* Début d'un tick de jeu */
		if (this.niveau <= 256 && this.getVies() > 0) {
			/* Sortie du bloc */
			if (compteurPartie == 0) {
				for (Fantome f : fantomes) {
					f.setStatut(EStatutFantome.DEBUTPARTIE);
				}
			} else if (compteurPartie >= 3.5 * tickParSeconde) {
				for (Fantome f : fantomes) {
					f.setStatut(EStatutFantome.CHASSEUR);
				}
			}
			pac.deplacer();
			pinky.deplacer(pac);
			inky.deplacer(pac);
			blinky.deplacer(pac);
			clyde.deplacer(pac);
			/* Pacman mange si possible */
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
					fantomeVulnerable = true;
					compteurVulnerable = 0;
				}
				compteurGomme++;
				pacCase.deleteObjet();
			}
			/* Fantome sortent de l'état VULNERABLE */
			if (compteurVulnerable == 500) {
				for (Fantome f : fantomes) {
					f.setStatut(EStatutFantome.CHASSEUR);
					fantomeVulnerable = false;
					compteurVulnerable = 0;
				}
			}
			/* Fantom meme case pacman */
			for (Fantome f : fantomes) {
				int fantomeX = (int) f.getposX();
				int fantomeY = (int) f.getposY();
				if (fantomeX == pacX && fantomeY == pacY) {
					if (f.getStatut() == EStatutFantome.CHASSEUR) {
						pacMeurt();
						break;
					} else if (f.getStatut() == EStatutFantome.VULNERABLE) {
						f.meurt();
						if (this.compteurPartie - pac.getTickDernierFantomeMange() < tickParSeconde * 1.5) {
							pac.setCompteurCombo(pac.getCompteurCombo() + 1);
						} else {
							pac.setCompteurCombo(1);
						}
						this.score += d.getPointsCombo(pac.getCompteurCombo());
						pac.setTickDernierFantomeMange(compteurPartie);
						this.etatPartie = EStatutPartie.EN_ANIMATION_FANMORT;
					}
				}
			}
			/* Spawn de fruit */
			if (compteurGomme == 80 || compteurGomme == 160) {
				int x = (int) d.getPositionFruit()[0];
				int y = (int) d.getPositionFruit()[1];
				Jouable j = (Jouable) tab[x][y];
				Fruit f = d.getFruitNiveau(this.niveau);
				j.setObjet(f);
				tickSpawnFruit = 600;
				fruitSpawn = true;
			}
			/* Grille ne contient plus de Gommes */
			if (noGomme()) {
				this.etatPartie = EStatutPartie.EN_ANIMATION_FIN;
				this.initialisation();
			}
			/*
			 * Incrémentation du compteur de tick durant lequel les fantomes sont
			 * vulnerables
			 */
			if (this.fantomeVulnerable) {
				this.compteurVulnerable++;
			}
			/*
			 * Incrémentation du compteur de tick durant lequel le fruit est présent sur la
			 * grille
			 */
			if (fruitSpawn) {
				tickSpawnFruit--;
			}
			/* Suppresion du fruit si le compteur de tick est à 0 */
			if (tickSpawnFruit == 0) {
				int x = (int) d.getPositionInitialePacman()[0];
				int y = (int) d.getPositionInitialePacman()[1];
				Jouable j = (Jouable) tab[x][y];
				j.deleteObjet();
				fruitSpawn = false;
			}
			compteurPartie++;
		} else {
			this.etatPartie = EStatutPartie.EN_ANIMATION_GAME_OVER;
			this.niveau = 3;
			pac = 3;
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
			for (int j = 0; j < tab[0].length; j++) {
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

	/**
	 * 
	 */
	public void pacMeurt() {
		pac.meurt();
		this.etatPartie = EStatutPartie.EN_ANIMATION_PACMORT;
		mortPacman = true;
	}

}
