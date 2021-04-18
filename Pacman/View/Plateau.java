package Pacman.View;

import java.awt.*;

import javax.swing.*;

import Pacman.Data.DataForView;
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
    private entreeClavier clavier;
    private dessinerFantome Blinky;
    private dessinerFantome Clyde;
    private dessinerFantome Inky;
    private dessinerFantome Pinky;
    private final int tick = 16;

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
        this.clavier = new entreeClavier(partie.getGrille());
        this.Blinky = new dessinerFantome(partie.getGrille().getBlinky(), Plateau.data);
        this.Clyde = new dessinerFantome(partie.getGrille().getClyde(), Plateau.data);
        this.Inky = new dessinerFantome(partie.getGrille().getInky(), Plateau.data);
        this.Pinky = new dessinerFantome(partie.getGrille().getPinky(), Plateau.data);

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
        dessinerATH.dessiner(partie, g2d, data, this.clavier.getinGame());

        // Lorsque le joueur appuie sur la touche de pause, la partie se met en pause et
        // vice-versa
        if (this.clavier.getinGame()) {
            enJeu(g2d);
        } else {
            enPause(g2d);
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
     * Affiche les éléments de la grille lorsque la partie est en cours.
     * 
     * @param g2d objet Graphics2D permettant de mettre à jour les sprites.
     */
    private void enJeu(Graphics2D g2d) {

        // if (pacmant.getstatus() = mort) {
        // animemort();
        // } else {

        // Affiche toutes les gommes.
        desssinerGrille.dessiner(partie.getGrille().getCases(), g2d, data);

        // Affiche Pacman en rond au début.

        // Affiche Pacman.
        dessinerPacman.dessiner(partie.getGrille().getPacman(), g2d, data);

        // Affiche les Fantômes.
        Blinky.dessiner(partie.getGrille().getBlinky(), g2d);
        Clyde.dessiner(partie.getGrille().getClyde(), g2d);
        Inky.dessiner(partie.getGrille().getInky(), g2d);
        Pinky.dessiner(partie.getGrille().getPinky(), g2d);

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
