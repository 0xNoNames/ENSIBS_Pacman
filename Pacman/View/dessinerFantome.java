package Pacman.View;

import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Pacman.Data.DataForView;
import Pacman.Logic.Fantome;

/**
 * 
 * La classe dessinerFantome permet de gérer les sprites des Fantomes.
 * 
 * @author Arthur Pêtre
 */
public class dessinerFantome {
    private int spriteActuel;

    public void dessiner(Fantome fantome, JFrame fenetre, DataForView data) throws IOException {
        switch (fantome.getDirectionCourante()) {
        case NORD:
            spritefantomeNord(fantome, fenetre, data);
            break;
        case SUD:
            spritefantomeSud(fantome, fenetre, data);
            break;
        case EST:
            spritefantomeEst(fantome, fenetre, data);
            break;
        case OUEST:
            spritefantomeOuest(fantome, fenetre, data);
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

    private void spritefantomeNord(Fantome fantome, JFrame fenetre, DataForView data) {
        JLabel imageLabel;
        switch (spriteActuel) {
        case 1:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[0]));
            fenetre.add(imageLabel);
            break;

        case 2:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[5]));
            fenetre.add(imageLabel);
            break;

        case 3:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[6]));
            fenetre.add(imageLabel);
            break;

        default:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[0]));
            fenetre.add(imageLabel);
            break;
        }
    }

    private void spritefantomeSud(Fantome fantome, JFrame fenetre, DataForView data) {
        JLabel imageLabel;
        switch (spriteActuel) {
        case 1:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[0]));
            fenetre.add(imageLabel);
            break;

        case 2:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[7]));
            fenetre.add(imageLabel);
            break;

        case 3:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[8]));
            fenetre.add(imageLabel);
            break;

        default:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[0]));
            fenetre.add(imageLabel);
            break;
        }
    }

    private void spritefantomeEst(Fantome fantome, JFrame fenetre, DataForView data) {
        JLabel imageLabel;
        switch (spriteActuel) {
        case 1:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[0]));
            fenetre.add(imageLabel);
            break;

        case 2:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[3]));
            fenetre.add(imageLabel);
            break;

        case 3:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[4]));
            fenetre.add(imageLabel);
            break;

        default:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[0]));
            fenetre.add(imageLabel);
            break;
        }
    }

    private void spritefantomeOuest(Fantome fantome, JFrame fenetre, DataForView data) {
        JLabel imageLabel;
        switch (spriteActuel) {
        case 1:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[0]));
            fenetre.add(imageLabel);
            break;

        case 2:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[1]));
            fenetre.add(imageLabel);
            break;

        case 3:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[2]));
            fenetre.add(imageLabel);
            break;

        default:
            imageLabel = new JLabel(new ImageIcon(data.getFantomesSprites(fantome.getCouleur())[0]));
            fenetre.add(imageLabel);
            break;
        }
    }
}
