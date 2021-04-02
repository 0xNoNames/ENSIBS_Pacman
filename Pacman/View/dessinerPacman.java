package Pacman.View;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import Pacman.Logic.Pacman;

/**
 * La classe dessinerPacman permet de gérer les sprites de Pacman.
 * 
 * @author Arthur Pêtre
 */
public class dessinerPacman {
    private int spriteActuel;

    public void dessiner(Pacman pacman, Graphics2D frame) {
        switch (pacman.getDirectionCourante()) {
        case NORD:
            spritePacmanNord(frame, pacman);
            break;
        case SUD:
            spritePacmanSud(frame, pacman);
            break;
        case EST:
            spritePacmanEst(frame, pacman);
            break;
        case OUEST:
            spritePacmanOuest(frame, pacman);
            break;
        }

    }

    private void spritePacmanNord(Graphics2D frame, Pacman pacman) {
        switch (spriteActuel) {
        case 1:
            frame.drawImage(new ImageIcon("pacmannord1.png").getImage()/* pacmanSpriteNord1 */, pacman.getposX(),
                    pacman.getposY(), this);
            break;
        case 2:
            frame.drawImage(new ImageIcon("pacmanord2.png").getImage()/* pacmanSpriteNord2 */, pacman.getposX(),
                    pacman.getposY(), this);
            break;
        case 3:
            frame.drawImage(new ImageIcon("pacmannord3.png").getImage()/* pacmanSpriteNord3 */, pacman.getposX(),
                    pacman.getposY(), this);
            break;
        default:
            frame.drawImage(new ImageIcon("pacmannord1.png").getImage(), pacman.getposX(), pacman.getposY(), this);
            break;
        }
    }

    private void spritePacmanSud(Graphics2D frame, Pacman pacman) {
        switch (spriteActuel) {
        case 1:
            frame.drawImage(new ImageIcon("pacmansud1.png").getImage()/* pacmanSpriteSud1 */, pacman.getposX(),
                    pacman.getposY(), this);
            break;
        case 2:
            frame.drawImage(new ImageIcon("pacmansud2.png").getImage()/* pacmanSpriteSud1 */, pacman.getposX(),
                    pacman.getposY(), this);
            break;
        case 3:
            frame.drawImage(new ImageIcon("pacmansud3.png").getImage()/* pacmanSpriteSud1 */, pacman.getposX(),
                    pacman.getposY(), this);
            break;
        default:
            frame.drawImage(new ImageIcon("pacmansud1.png").getImage(), pacman.getposX(), pacman.getposY(), this);
            break;
        }
    }

    private void spritePacmanEst(Graphics2D frame, Pacman pacman) {
        switch (spriteActuel) {
        case 1:
            frame.drawImage(new ImageIcon("pacmanEst1.png").getImage()/* pacmanSpriteEst1 */, pacman.getposX(),
                    pacman.getposY(), this);
            break;
        case 2:
            frame.drawImage(new ImageIcon("pacmanEst2.png").getImage()/* pacmanSpriteEst1 */, pacman.getposX(),
                    pacman.getposY(), this);
            break;
        case 3:
            frame.drawImage(new ImageIcon("pacmanEst3.png").getImage()/* pacmanSpriteEst1 */, pacman.getposX(),
                    pacman.getposY(), this);
            break;
        default:
            frame.drawImage(new ImageIcon("pacmanEst1.png").getImage(), pacman.getposX(), pacman.getposY(), this);
            break;
        }
    }

    private void spritePacmanOuest(Graphics2D frame, Pacman pacman) {
        switch (spriteActuel) {
        case 1:
            frame.drawImage(new ImageIcon("pacmanouest1.png").getImage()/* pacmanSpriteOuest1 */, pacman.getposX(),
                    pacman.getposY(), this);
            break;
        case 2:
            frame.drawImage(new ImageIcon("pacmanouest2.png").getImage()/* pacmanSpriteOuest1 */, pacman.getposX(),
                    pacman.getposY(), this);
            break;
        case 3:
            frame.drawImage(new ImageIcon("pacmanouest3.png").getImage()/* pacmanSpriteOuest1 */, pacman.getposX(),
                    pacman.getposY(), this);
            break;
        default:
            frame.drawImage(new ImageIcon("pacmanouest1.png").getImage(), pacman.getposX(), pacman.getposY(), this);
            break;
        }
    }

}