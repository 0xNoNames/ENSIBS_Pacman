package Pacman.View;

import java.awt.*;

import javax.swing.*;

import Pacman.Data.DataForView;
import Pacman.Logic.ECouleur;
import Pacman.Logic.EDirection;

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

    public Plateau(double scale) {
        addKeyListener(new entreeClavier());
        setFocusable(true);
        setBackground(Color.black);
        this.scale = scale;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        data = new DataForView();

        Graphics2D g2d = (Graphics2D) g;

        g2d.scale(this.scale, this.scale);

        // Début de la grille en jouable -> (4,32)
        // Déplacement d'une case à l'autre -> +8 
        // (case[0][0] : [4,32])
        // (case[1][1] : [12,40])
        // (case[2][2] : [20,48])

        // g2d.drawImage(data.getGrille(), 0, 28, this);
        // g2d.drawImage(data.getFantomesSprites(ECouleur.ROUGE, EDirection.OUEST)[0], 4, 32, this);
        // g2d.drawImage(data.getFantomesSprites(ECouleur.ROUGE, EDirection.OUEST)[0], 12, 40, this);
        // g2d.drawImage(data.getFantomesSprites(ECouleur.ROUGE, EDirection.OUEST)[0], 20, 48, this);

        g2d.dispose();

        // Toolkit.getDefaultToolkit().sync();
    }

    public double getScale() {
        return this.scale;
    }

}
