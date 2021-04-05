package Pacman.View;

import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Pacman.Data.DataForView;
import Pacman.Logic.Pacman;

/**
 * La classe dessinerPacman permet de gérer les sprites de Pacman.
 * 
 * @author Arthur Pêtre
 */
public class dessinerPacman {
    private int spriteActuel;

    // Met à jour le numéro de sprite actuel et dessine Pacman.
    public void dessiner(Pacman pacman, JFrame fenetre, DataForView data) throws IOException {
        dessinerSpritePacman(pacman, fenetre, data);
        updateSprite();
    }

    // Met à jour le numéro de sprite actuel.
    private void updateSprite() {
        if (this.spriteActuel == 3) {
            spriteActuel = 1;
        } else {
            this.spriteActuel += 1;
        }
    }

    // Dessine Pacman.
    private void dessinerSpritePacman(Pacman pacman, JFrame fenetre, DataForView data) {
        JLabel imageLabel;
        switch (spriteActuel) {
        case 1:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites(pacman.getDirectionCourante())[0]));
            fenetre.add(imageLabel);
            break;

        case 2:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites(pacman.getDirectionCourante())[1]));
            fenetre.add(imageLabel);
            break;

        case 3:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites(pacman.getDirectionCourante())[2]));
            fenetre.add(imageLabel);
            break;
        }  
    }

    // Dessine la mort de Pacman.
    private void dessinerMortPacman(Pacman pacman, JFrame fenetre, DataForView data) {
        // 11 sprites + 1 bouche fermée.
    }
}
