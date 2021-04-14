package Pacman.View;

import java.awt.*;

import javax.swing.*;

import Pacman.Data.DataForView;
import Pacman.Logic.EDirection;
import Pacman.Logic.Grille;
import Pacman.Logic.Partie;

/**
 * 
 * La classe Plateau permet de créer la surface de jeu (les sprites) et
 * d'ajouter le controleur d'entrée.
 * 
 * @author Arthur Pêtre
 */
public class Plateau extends JPanel {
    private static DataForView data;
    private double scale;
    private Partie partie;
    private Grille grille;
    private entreeClavier clavier;
    private dessinerFantome Blinky;
    private dessinerFantome Clyde;
    private dessinerFantome Inky;
    private dessinerFantome Pinky;

    public Plateau(Partie partie, double scale) {
        this.scale = scale;
        this.partie = partie;
        this.grille = partie.getGrille();
        this.clavier = new entreeClavier(grille);
        data = new DataForView();

        this.Blinky = new dessinerFantome(grille.getBlinky(), data);
        this.Clyde = new dessinerFantome(grille.getClyde(), data);
        this.Inky = new dessinerFantome(grille.getInky(), data);
        this.Pinky = new dessinerFantome(grille.getPinky(), data);

        partie.initialisation();

        addKeyListener(this.clavier);
        setFocusable(true);
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        dessiner(g);
    }

    private void dessiner(Graphics g) {
        // g2d.dispose();
        // Toolkit.getDefaultToolkit().sync();

        Graphics2D g2d = (Graphics2D) g;

        // Donne l'échelle définie à la fenêtre
        g2d.scale(this.scale, this.scale);

        // Affichage du labyrinthe en fond
        g2d.drawImage(data.getGrille(), 0, 28, this);

        if (this.clavier.getinGame()) {
            jouer(g2d);
        } else {
            pause(g2d);
        }

        // Redessine toutes les 16 ms
        repaint();
        try {
            Thread.sleep(16);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private void pause(Graphics2D g2d) {
        String s1 = "Appuyez sur 'ESPACE'";
        String s2 = "pour demarrer/pause";

        g2d.setColor(Color.white);
        g2d.drawString(s1, 50, 90);
        g2d.drawString(s2, 55, 105);

    }

    private void jouer(Graphics2D g2d) {

        // if (pacmant.getstatus() = mort) {
        // animemort();
        // } else {

        // Affichage du score et des vies
        // dessinerATH.dessiner(partie.getScore(), g2d, data);

        // Affichage de toutes les gommes
        desssinerGrille.dessiner(grille.getCases(), g2d, data);

        // Affichage de Pacman en rond au début

        // Affichage de Pacman
        dessinerPacman.dessiner(grille.getPacman(), g2d, data);

        // Affichage des Fantômes
        Blinky.dessiner(g2d);
        Clyde.dessiner(g2d);
        Inky.dessiner(g2d);
        Pinky.dessiner(g2d);

        partie.tick();
    }

    public double getScale() {
        return this.scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

}
