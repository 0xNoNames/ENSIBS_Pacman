package Pacman.View;

import javax.swing.JFrame;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import Pacman.Logic.Partie;

/**
 * 
 * La classe Fenetre permet de générer la fenêtre ainsi que ses composants.
 * 
 * @author Arthur Pêtre
 */
public class Fenetre extends JFrame {

    // Initialise la fenetre principale.
    public Fenetre(Partie partie) {
        double scale = 2.0;
        Plateau plateau = new Plateau(partie, scale);
        int width = (int) (229 * plateau.getScale());
        int height = (int) (310 * plateau.getScale());

        add(plateau);
        setSize(width, height);
        setResizable(true);
        setTitle("Pacman by JULLION - PETRE - SOBOLEWSKI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Lorsque la fenêtre est redimmensionnée on change l'échelle du jeu
        this.getRootPane().addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent e) {
                double height = e.getComponent().getBounds().getHeight();
                // double height = width * 2;
                plateau.setScale(height / 295.0);
                // setSize((int) width, (int) height);
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }
        });
    }
}
