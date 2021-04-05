package Pacman.View;

import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Pacman.Data.DataForView;
import Pacman.Logic.EStatutFantome;
import Pacman.Logic.Fantome;

/**
 * 
 * La classe dessinerFantome permet de gérer les sprites des Fantomes.
 * 
 * @author Arthur Pêtre
 */
public class dessinerFantome {
    private int spriteActuel;

    // Met à jour le numéro de sprite actuel et dessine le Fantome voulu.
    public void dessiner(Fantome fantome, JFrame fenetre, DataForView data) throws IOException {
        dessinerSpriteFantome(fantome, fenetre, data);
        updateSprite();
    }

    // Met à jour le numéro de sprite actuel.
    private void updateSprite() {
        if (this.spriteActuel == 2) {
            spriteActuel = 1;
        } else {
            this.spriteActuel += 1;
        }
    }

    // Dessine le Fantome voulu selon son état.
    private void dessinerSpriteFantome(Fantome fantome, JFrame fenetre, DataForView data) {
        JLabel imageLabel;
        switch (spriteActuel) {
        case 1:
            switch (fantome.getStatut()) {
            case CHASSEUR:
                imageLabel = new JLabel(new ImageIcon(
                        data.getFantomesSprites(fantome.getCouleur(), fantome.getDirectionCourante())[0]));
                fenetre.add(imageLabel);
                break;

            case VULNERABLE:
                imageLabel = new JLabel(
                        new ImageIcon(data.getVulnerableFantomesSprites(fantome.getDirectionCourante())));
                fenetre.add(imageLabel);
                break;

            case MORT:
                imageLabel = new JLabel(new ImageIcon(data.getMortFantomeSprites()[0]));
                fenetre.add(imageLabel);
                break;
            }
            break;

        case 2:
            switch (fantome.getStatut()) {
            case CHASSEUR:
                imageLabel = new JLabel(new ImageIcon(
                        data.getFantomesSprites(fantome.getCouleur(), fantome.getDirectionCourante())[1]));
                fenetre.add(imageLabel);
                break;

            case VULNERABLE:
                imageLabel = new JLabel(
                        new ImageIcon(data.getVulnerableFantomesSprites(fantome.getDirectionCourante())));
                fenetre.add(imageLabel);
                break;

            case MORT:
                imageLabel = new JLabel(new ImageIcon(data.getMortFantomeSprites()[1]));
                fenetre.add(imageLabel);
                break;

            }
            break;
        }
    }
}
