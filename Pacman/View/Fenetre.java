package Pacman.View;

import javax.swing.JFrame;
import java.awt.Color;

/**
 * 
 * La classe Fenetre permet de générer la fenêtre ainsi que ses composants.
 * 
 * @author Arthur Pêtre
 */
public class Fenetre extends JFrame {

    public Fenetre() {
        setTitle("PACMAN");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
    }
}
