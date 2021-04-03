package Pacman.View;

import java.awt.Color;

import javax.swing.JFrame;

/**
 * 
 * La classe Fenetre permet de générer la fenêtre ainsi que ses composants.
 * 
 * @author Arthur Pêtre
 */
public class Fenetre extends JFrame {

    public Fenetre() {
        setBackground(new Color(0, 0, 0));
        setTitle("PACMAN");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
