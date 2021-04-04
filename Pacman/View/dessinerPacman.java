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

    public dessinerPacman() {
        this.spriteActuel = 1;
    }

    public void dessiner(Pacman pacman, JFrame fenetre, DataForView data) throws IOException {
        switch (pacman.getDirectionCourante()) {
        case NORD:
            spritePacmanNord(pacman, fenetre, data);
            break;

        case SUD:
            spritePacmanSud(pacman, fenetre, data);
            break;

        case EST:
            spritePacmanEst(pacman, fenetre, data);
            break;

        case OUEST:
            spritePacmanOuest(pacman, fenetre, data);
            break;
        }
        updateSprite();
    }

    private void updateSprite() {
        if (this.spriteActuel == 3) {
            spriteActuel = 1;
        } else {
            this.spriteActuel += 1;
        }
    }

    private void spritePacmanNord(Pacman pacman, JFrame fenetre, DataForView data) throws IOException {
        JLabel imageLabel;
        switch (spriteActuel) {
        case 1:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[0]));
            fenetre.add(imageLabel);
            break;

        case 2:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[5]));
            fenetre.add(imageLabel);
            break;

        case 3:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[6]));
            fenetre.add(imageLabel);
            break;

        default:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[0]));
            fenetre.add(imageLabel);
            break;
        }
    }

    private void spritePacmanSud(Pacman pacman, JFrame fenetre, DataForView data) throws IOException {
        JLabel imageLabel;
        switch (spriteActuel) {
        case 1:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[0]));
            fenetre.add(imageLabel);
            break;

        case 2:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[7]));
            fenetre.add(imageLabel);
            break;

        case 3:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[8]));
            fenetre.add(imageLabel);
            break;

        default:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[0]));
            fenetre.add(imageLabel);
            break;
        }
    }

    private void spritePacmanEst(Pacman pacman, JFrame fenetre, DataForView data) throws IOException {
        JLabel imageLabel;
        switch (spriteActuel) {
        case 1:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[0]));
            fenetre.add(imageLabel);
            break;

        case 2:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[3]));
            fenetre.add(imageLabel);
            break;

        case 3:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[4]));
            fenetre.add(imageLabel);
            break;

        default:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[0]));
            fenetre.add(imageLabel);
            break;
        }
    }

    private void spritePacmanOuest(Pacman pacman, JFrame fenetre, DataForView data) throws IOException {
        JLabel imageLabel;
        switch (spriteActuel) {
        case 1:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[0]));
            fenetre.add(imageLabel);
            break;

        case 2:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[1]));
            fenetre.add(imageLabel);
            break;

        case 3:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[2]));
            fenetre.add(imageLabel);
            break;

        default:
            imageLabel = new JLabel(new ImageIcon(data.getPacmanSprites()[0]));
            fenetre.add(imageLabel);
            break;
        }
    }
}