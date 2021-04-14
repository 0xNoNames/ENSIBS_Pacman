package Pacman.View;

import java.awt.*;

import javax.swing.*;

import Pacman.Data.DataForView;
import Pacman.Logic.Grille;
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
    private Grille grille;
    private entreeClavier clavier;
    private dessinerFantome Blinky;
    private dessinerFantome Clyde;
    private dessinerFantome Inky;
    private dessinerFantome Pinky;

    public Plateau(Partie partie, double scale) {
        // Permet de récupérer les sprites depuis la Data.
        data = new DataForView();

        // Initialisation des attributs de la classe.
        this.scale = scale;
        this.partie = partie;
        this.grille = partie.getGrille();
        this.clavier = new entreeClavier(grille);

        this.Blinky = new dessinerFantome(grille.getBlinky(), Plateau.data);
        this.Clyde = new dessinerFantome(grille.getClyde(), Plateau.data);
        this.Inky = new dessinerFantome(grille.getInky(), Plateau.data);
        this.Pinky = new dessinerFantome(grille.getPinky(), Plateau.data);

        // Ajout du listener pour récupérer les entrées utilisateur.
        addKeyListener(this.clavier);
        // Permet le focus de la fenêtre (pour récupérer les entrées utilisateur).
        setFocusable(true);
        // Rend le fond noir pour nos petits yeux.
        setBackground(Color.black);

        // Initialisation de la partie depuis Logic.
        partie.initialisation();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        dessiner(g);
    }

    private void dessiner(Graphics g) {
        // Toolkit.getDefaultToolkit().sync();

        Graphics2D g2d = (Graphics2D) g;

        // Donne l'échelle définie par la fenêtre.
        g2d.scale(this.scale, this.scale);

        // Affichage des murs.
        g2d.drawImage(Plateau.data.getGrille(), 0, 28, this);

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
            Thread.sleep(16);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // Affiche un message spécifiant que la partie est en pause.
    private void enPause(Graphics2D g2d) {
        String s1 = "Appuyez sur 'ESPACE'";
        String s2 = "pour demarrer/pause";

        g2d.setColor(Color.white);
        g2d.drawString(s1, 50, 90);
        g2d.drawString(s2, 55, 105);
    }

    // Affiche les éléments de la grille lorsque la partie est en cours.
    private void enJeu(Graphics2D g2d) {

        // if (pacmant.getstatus() = mort) {
        // animemort();
        // } else {

        // Affiche le score et les vies.
        // dessinerATH.dessiner(partie.getScore(), g2d, data);

        // Affiche toutes les gommes.
        desssinerGrille.dessiner(grille.getCases(), g2d, data);

        // Affiche Pacman en rond au début.

        // Affiche Pacman.
        dessinerPacman.dessiner(grille.getPacman(), g2d, data);

        // Affiche les Fantômes.
        Blinky.dessiner(g2d);
        Clyde.dessiner(g2d);
        Inky.dessiner(g2d);
        Pinky.dessiner(g2d);

        // Avance de 1 tick la partie.
        partie.tick();
    }

    // Retourne la valeur de l'échelle actuelle.
    public double getScale() {
        return this.scale;
    }

    // Permet de spécifier l'échelle utilisée.
    public void setScale(double scale) {
        this.scale = scale;
    }

}
