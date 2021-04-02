package Pacman.View;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import Pacman.Logic.Fantome;

/**
 * 
 * La classe dessinerFantome permet de gérer les sprites des Fantomes.
 * 
 * @author Arthur Pêtre
 */
public class dessinerFantome {

    private int spriteActuel;

    public void dessiner(Fantome fantome, Graphics2D frame) {
        switch (fantome.getDirectionCourante()) {
        case NORD:
            spritefantomeNord(frame, fantome);
            break;
        case SUD:
            spritefantomeSud(frame, fantome);
            break;
        case EST:
            spritefantomeEst(frame, fantome);
            break;
        case OUEST:
            spritefantomeOuest(frame, fantome);
            break;
        }

    }

    private void spritefantomeNord(Graphics2D frame, Fantome fantome) {
        switch (spriteActuel) {
        case 1:
            frame.drawImage(new ImageIcon("fantomenord1.png").getImage()/* fantomeSpriteNord1 */, fantome.getposX(),
                    fantome.getposY(), null);
            break;
        case 2:
            frame.drawImage(new ImageIcon("fantomeord2.png").getImage()/* fantomeSpriteNord2 */, fantome.getposX(),
                    fantome.getposY(), null);
            break;
        case 3:
            frame.drawImage(new ImageIcon("fantomenord3.png").getImage()/* fantomeSpriteNord3 */, fantome.getposX(),
                    fantome.getposY(), null);
            break;
        default:
            frame.drawImage(new ImageIcon("fantomenord1.png").getImage(), fantome.getposX(), fantome.getposY(), null);
            break;
        }
    }

    private void spritefantomeSud(Graphics2D frame, Fantome fantome) {
        switch (spriteActuel) {
        case 1:
            frame.drawImage(new ImageIcon("fantomesud1.png").getImage()/* fantomeSpriteSud1 */, fantome.getposX(),
                    fantome.getposY(), null);
            break;
        case 2:
            frame.drawImage(new ImageIcon("fantomesud2.png").getImage()/* fantomeSpriteSud1 */, fantome.getposX(),
                    fantome.getposY(), null);
            break;
        case 3:
            frame.drawImage(new ImageIcon("fantomesud3.png").getImage()/* fantomeSpriteSud1 */, fantome.getposX(),
                    fantome.getposY(), null);
            break;
        default:
            frame.drawImage(new ImageIcon("fantomesud1.png").getImage(), fantome.getposX(), fantome.getposY(), null);
            break;
        }
    }

    private void spritefantomeEst(Graphics2D frame, Fantome fantome) {
        switch (spriteActuel) {
        case 1:
            frame.drawImage(new ImageIcon("fantomeEst1.png").getImage()/* fantomeSpriteEst1 */, fantome.getposX(),
                    fantome.getposY(), null);
            break;
        case 2:
            frame.drawImage(new ImageIcon("fantomeEst2.png").getImage()/* fantomeSpriteEst1 */, fantome.getposX(),
                    fantome.getposY(), null);
            break;
        case 3:
            frame.drawImage(new ImageIcon("fantomeEst3.png").getImage()/* fantomeSpriteEst1 */, fantome.getposX(),
                    fantome.getposY(), null);
            break;
        default:
            frame.drawImage(new ImageIcon("fantomeEst1.png").getImage(), fantome.getposX(), fantome.getposY(), null);
            break;
        }
    }

    private void spritefantomeOuest(Graphics2D frame, Fantome fantome) {
        switch (spriteActuel) {
        case 1:
            frame.drawImage(new ImageIcon("fantomeouest1.png").getImage()/* fantomeSpriteOuest1 */, fantome.getposX(),
                    fantome.getposY(), null);
            break;
        case 2:
            frame.drawImage(new ImageIcon("fantomeouest2.png").getImage()/* fantomeSpriteOuest1 */, fantome.getposX(),
                    fantome.getposY(), null);
            break;
        case 3:
            frame.drawImage(new ImageIcon("fantomeouest3.png").getImage()/* fantomeSpriteOuest1 */, fantome.getposX(),
                    fantome.getposY(), null);
            break;
        default:
            frame.drawImage(new ImageIcon("fantomeouest1.png").getImage(), fantome.getposX(), fantome.getposY(), null);
            break;
        }
    
}
