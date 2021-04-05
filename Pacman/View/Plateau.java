package Pacman.View;

import java.awt.*;

import javax.swing.*;

import Pacman.Data.DataForView;
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

    public Plateau() {
        addKeyListener(new entreeClavier());
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

        g2d.scale(2.0, 2.0);

        g2d.drawImage(data.getGrille(), 0, 20, this);
        g2d.drawImage(data.getPacmanSprites(EDirection.NORD)[0], 100, 100, this);
        g2d.drawImage(data.getFruitSprites()[0], 110, 100, this);

        // Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }

}
