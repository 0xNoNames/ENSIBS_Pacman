package Pacman.View;

import javax.swing.JFrame;
import Pacman.View.Plateau;
import java.awt.event.ComponentEvent;
import java.awt.Rectangle;

import Pacman.Logic.Partie;
import Pacman.Logic.Case;

/**
 * 
 * La classe Fenetre permet de générer la fenêtre ainsi que ses composants.
 * 
 * @author Arthur Pêtre
 */
public class Fenetre extends JFrame {

    // Initialise la fenetre principale.
    public Fenetre(Partie partie) {
        Plateau plateau = new Plateau(partie, 3.0);
        add(plateau);
        int width = (int) (229 * plateau.getScale());
        int height = (int) (310 * plateau.getScale());

        setSize(width, height);
        setResizable(true);
        setTitle("PACMAN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    // @Override
    // public void formComponentResized(ComponentEvent arg0) {
    // Rectangle F = arg0.getComponent().getBounds();
    // arg0.getComponent().setBounds(F.x, F.y, F.width, F.width);
    // }
}
