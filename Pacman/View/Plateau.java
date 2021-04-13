package Pacman.View;

import java.awt.*;

import javax.swing.*;

import Pacman.Data.DataForView;
import Pacman.Logic.ECouleur;
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
    private dessinerFantome Blinky;
    private dessinerFantome Clyde;
    private dessinerFantome Inky;
    private dessinerFantome Pinky;

    public Plateau(Partie partie, double scale) {
        this.scale = scale;
        this.partie = partie;
        this.grille = partie.getGrille();

        data = new DataForView();

        this.Blinky = new dessinerFantome(grille.getBlinky(), data);
        this.Clyde = new dessinerFantome(grille.getClyde(), data);
        this.Inky = new dessinerFantome(grille.getInky(), data);
        this.Pinky = new dessinerFantome(grille.getPinky(), data);

        addKeyListener(new entreeClavier(grille));
        setFocusable(true);
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.scale(this.scale, this.scale);

        // Affichage de le labyrinthe en fond
        g2d.drawImage(data.getGrille(), 0, 28, this);

        // Affichage de toutes les gommes
        desssinerGrille.dessiner(grille.getCases(), g2d, data);

        // Affichage de Pacman en rond au début
        // g2d.drawImage(data.getPacmanSprites(EDirection.EST)[2], 13, 28, this);

        // Affichage de Pacman
        dessinerPacman.dessiner(grille.getPacman(), g2d, data);

        // Affichage des Fantômes
        Blinky.dessiner(g2d);
        Clyde.dessiner(g2d);
        Inky.dessiner(g2d);
        Pinky.dessiner(g2d);

        partie.initialisation();

        System.out.println(grille.getPacman().getDirectionCourante());
        System.out.println(grille.getPacman().getDirectionVoulue());

        System.out.println(partie.getEtatPartie());

        // g2d.dispose();

        Toolkit.getDefaultToolkit().sync();

        partie.tick();

        repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        // desssinerGrille.dessiner(grille.getCases(), g2d, data);
        // dessinerScore.dessiner(partie.getScore(), g2d, data);
        // g2d.drawImage(data.getGommesSprites()[1], 8, 36, null);

        // g2d.drawImage(data.getGommesSprites()[0], 17, 45, null);

        // Début de la grille en jouable -> (4,32) (9,37) petites gommes & (8,36)
        // grosses gommes
        // Déplacement d'une case à l'autre -> +8
        // (case[0][0] : [4,32])
        // (case[1][1] : [12,40])
        // (case[2][2] : [20,48])

    }

    public double getScale() {
        return this.scale;
    }

}
