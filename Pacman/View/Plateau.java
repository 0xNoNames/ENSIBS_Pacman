package Pacman.View;

import java.awt.*;

import javax.swing.*;

import Pacman.Data.DataForView;
import Pacman.Logic.EStatutFantome;
import Pacman.Logic.EStatutPartie;
import Pacman.Logic.Partie;

/**
 * 
 * La classe Plateau permet de gérer l'affichage des sprites selon l'état de la
 * partie.
 * 
 * @author Arthur Pêtre
 */
public class Plateau extends JPanel {
    private static DataForView data;
    private double scale;
    private Partie partie;
    private int mortTick;
    private entreeClavier clavier;
    private dessinerFantome Blinky;
    private dessinerFantome Clyde;
    private dessinerFantome Inky;
    private dessinerFantome Pinky;
    private final int tick = 16;
    private int tickADebut = 80;
    private int tickAFin = 300;
    private int tickAFanMort = 15;
    private int tickAPacMort = 250;

    /**
     * Constructeur de la classe.
     * 
     * @param partie la partie en cours.
     * @param scale  l'échelle voulue d'affichage.
     */
    public Plateau(Partie partie, double scale) {
        // Permet de récupérer les sprites depuis la Data.
        data = new DataForView();

        // Initialisation des attributs de la classe.
        this.scale = scale;
        this.partie = partie;
        this.mortTick = 1;
        this.clavier = new entreeClavier(partie);
        this.Blinky = new dessinerFantome(partie.getGrille().getBlinky(), partie, Plateau.data);
        this.Clyde = new dessinerFantome(partie.getGrille().getClyde(), partie, Plateau.data);
        this.Inky = new dessinerFantome(partie.getGrille().getInky(), partie, Plateau.data);
        this.Pinky = new dessinerFantome(partie.getGrille().getPinky(), partie, Plateau.data);

        // Ajout du listener pour récupérer les entrées utilisateur.
        addKeyListener(this.clavier);
        // Permet le focus de la fenêtre (pour récupérer les entrées utilisateur).
        setFocusable(true);
        // Rend le fond noir pour nos petits yeux.
        setBackground(Color.black);

        // Initialisation de la partie depuis Logic.
        partie.initialisation();
    }

    /**
     * Redéfinition nécéssaire de la méthode paintComponent de Graphics.
     * 
     * @param Graphics objet Graphics permettant de mettre à jour les sprites.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        dessiner(g);
    }

    /**
     * Dessine les différents composants du jeu selon si la partie est en pause ou
     * non et est rappelle la méthode mère paintComponent() grâce à repaint() toutes
     * les "tick" ms.
     * 
     * @param g objet Graphics permettant de mettre à jour les sprites.
     */
    private void dessiner(Graphics g) {
        // Toolkit.getDefaultToolkit().sync();

        Graphics2D g2d = (Graphics2D) g;

        // Donne l'échelle définie par la fenêtre.
        g2d.scale(this.scale, this.scale);

        // Affiche le labyrinthe, le score, le niveau actuel et les vies.
        dessinerATH.dessiner(partie, g2d, data, this.partie.getEtatPartie());

        // Gère l'affichage selon l'état de la partie.
        switch (this.partie.getEtatPartie()) {
        case EN_ANIMATION_PACMORT:
            // this.partie.setEtatPartie(EStatutPartie.EN_COURS);
            enAnimationPacMort(g2d);
            break;
        case EN_ANIMATION_FANMORT:
            this.partie.setEtatPartie(EStatutPartie.EN_COURS);
            // enAnimationFanMort(g2d);
            break;
        case EN_ANIMATION_DEBUT:
            // this.partie.setEtatPartie(EStatutPartie.EN_COURS);
            enAnimationDebut(g2d);
            break;
        case EN_ANIMATION_FIN:
            this.partie.setEtatPartie(EStatutPartie.EN_COURS);
            // enAnimationFin(g2d);
            break;
        case GAME_OVER:
            this.partie.setEtatPartie(EStatutPartie.EN_COURS);
            break;
        case EN_COURS:
            enJeu(g2d);
            break;
        case EN_PAUSE:
            enPause(g2d);
            break;
        }

        // Redessine (rappelle la fonction paintComponent()) toutes les 16 ms.
        repaint();
        try {
            Thread.sleep(this.tick);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Affiche un message spécifiant que la partie est en pause.
     * 
     * @param g2d objet Graphics2D permettant de mettre à jour les sprites.
     */
    private void enPause(Graphics2D g2d) {
        g2d.setColor(Color.decode("#000000"));
        g2d.fillRect(30, 70, 164, 50);
        String s1 = "Appuyez sur 'ESPACE'";
        String s2 = "pour demarrer/pause";
        Font police = new Font("Zen Dots", Font.PLAIN, 10);

        g2d.setColor(Color.decode("#f4ea27"));
        g2d.setFont(police);
        g2d.drawString(s1, 40, 90);
        g2d.drawString(s2, 42, 105);
    }

    /**
     * Affiche l'animation de mort de pacman.
     * 
     * @param g2d objet Graphics2D permettant de mettre à jour les sprites.
     */
    private void enAnimationPacMort(Graphics2D g2d) {
        // Démarre la partie au bout d'un petite moment.
        if (this.tickAPacMort == 0) {
            this.partie.setEtatPartie(EStatutPartie.EN_COURS);

            // Affiche la mort de pacman au bout de 0.5 secondes environ.
        } else if (this.tickAPacMort <= 240) {
            dessinerPacman.dessinerMortPacman(partie.getGrille().getPacman(), g2d, data);
            // Fixe l'image pendant 0.5 seconces environ.
        } else {
            // Affiche Pacman.
            dessinerPacman.dessiner(partie.getGrille().getPacman(), g2d, data);

            // Affiche les Fantômes.
            Blinky.dessiner(partie.getGrille().getBlinky(), partie, g2d);
            Clyde.dessiner(partie.getGrille().getClyde(), partie, g2d);
            Inky.dessiner(partie.getGrille().getInky(), partie, g2d);
            Pinky.dessiner(partie.getGrille().getPinky(), partie, g2d);
        }

        this.tickAPacMort--;
    }

    /**
     * Affiche l'animation de mort d'un fantôme.
     * 
     * @param g2d objet Graphics2D permettant de mettre à jour les sprites.
     */
    private void enAnimationFanMort(Graphics2D g2d) {
        // Démarre la partie au bout d'un petite moment.
        if (this.tickAFanMort == 0) {
            this.partie.setEtatPartie(EStatutPartie.EN_ANIMATION_DEBUT);
        }

        // Affiche les Fantômes.
        Blinky.dessiner(partie.getGrille().getBlinky(), partie, g2d);
        Clyde.dessiner(partie.getGrille().getClyde(), partie, g2d);
        Inky.dessiner(partie.getGrille().getInky(), partie, g2d);
        Pinky.dessiner(partie.getGrille().getPinky(), partie, g2d);

        this.tickAFanMort--;
    }

    /**
     * Affiche l'animation de début du niveau.
     * 
     * @param g2d objet Graphics2D permettant de mettre à jour les sprites.
     */
    private void enAnimationDebut(Graphics2D g2d) {
        // Démarre la partie au bout d'un petite moment.
        if (this.tickADebut == 0) {
            this.partie.setEtatPartie(EStatutPartie.EN_COURS);
        }

        // Affiche les gommes.
        desssinerGrille.dessiner(partie.getGrille().getCases(), g2d, data, this.partie.getEtatPartie());

        // Affiche Pacman tout rond.
        dessinerPacman.dessinerPacmanRond(partie.getGrille().getPacman(), g2d, data);

        // Affiche les Fantômes.
        Blinky.dessiner(partie.getGrille().getBlinky(), partie, g2d);
        Clyde.dessiner(partie.getGrille().getClyde(), partie, g2d);
        Inky.dessiner(partie.getGrille().getInky(), partie, g2d);
        Pinky.dessiner(partie.getGrille().getPinky(), partie, g2d);

        this.tickADebut--;
    }

    /**
     * Affiche l'animation de fin du niveau.
     * 
     * @param g2d objet Graphics2D permettant de mettre à jour les sprites.
     */
    private void enAnimationFin(Graphics2D g2d) {
    }

    /**
     * Affiche les éléments de la grille lorsque la partie est en cours.
     * 
     * @param g2d objet Graphics2D permettant de mettre à jour les sprites.
     */
    private void enJeu(Graphics2D g2d) {
        // Affiche toutes les gommes.
        desssinerGrille.dessiner(partie.getGrille().getCases(), g2d, data, this.partie.getEtatPartie());

        // Affiche Pacman.
        dessinerPacman.dessiner(partie.getGrille().getPacman(), g2d, data);

        // Affiche les Fantômes.
        Blinky.dessiner(partie.getGrille().getBlinky(), partie, g2d);
        Clyde.dessiner(partie.getGrille().getClyde(), partie, g2d);
        Inky.dessiner(partie.getGrille().getInky(), partie, g2d);
        Pinky.dessiner(partie.getGrille().getPinky(), partie, g2d);

        // Avance de 1 tick la partie.
        partie.tick();
    }

    /**
     * Retourne la valeur de l'échelle actuelle.
     * 
     * @return double la valeur de l'échelle.
     */
    public double getScale() {
        return this.scale;
    }

    /**
     * Permet de spécifier l'échelle utilisée.
     * 
     * @param scale la valeur de l'échelle.
     */
    public void setScale(double scale) {
        this.scale = scale;
    }

}
