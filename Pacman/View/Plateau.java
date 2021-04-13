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

    public Plateau(Partie partie, double scale) {
        this.scale = scale;
        this.partie = partie;
        this.grille = partie.getGrille();

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
        data = new DataForView();

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
        dessinerFantome.dessiner(grille.getBlinky(), g2d, data);
        dessinerFantome.dessiner(grille.getClyde(), g2d, data);
        dessinerFantome.dessiner(grille.getInky(), g2d, data);
        dessinerFantome.dessiner(grille.getPinky(), g2d, data);

        System.out.println(partie.getEtatPartie());

        partie.initialisation();

        System.out.println(grille.getPacman().getDirectionCourante());
        System.out.println(grille.getPacman().getDirectionVoulue());

        System.out.println(partie.getEtatPartie());

        g2d.dispose();

        partie.tick();

        // repaint();

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

        Toolkit.getDefaultToolkit().sync();
    }

    public double getScale() {
        return this.scale;
    }

}
