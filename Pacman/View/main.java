package Pacman.View;

import java.awt.Color;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Pacman.Data.DataForView;
import Pacman.Logic.Pacman;

public class main {
    private static DataForView data;
    entreeClavier keyboard;

    // Test des fonctions
    public static void main(String[] args) throws IOException {
        System.out.println("Démarrage...");

        Fenetre fenetre = new Fenetre();
        dessinerPacman dessinerpacman = new dessinerPacman();
        data = new DataForView();

        JLabel grilleImage = new JLabel(new ImageIcon(data.getGrille()));
        fenetre.add(grilleImage);
        Pacman pacman = new Pacman();
        dessinerpacman.dessiner(pacman, fenetre, data);

        fenetre.setVisible(true);
        fenetre.getContentPane().setBackground(Color.BLACK);

        fenetre.addKeyListener(new entreeClavier());
        System.out.println("Done");
    }
}
