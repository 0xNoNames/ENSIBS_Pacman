package Pacman.View;

import java.awt.Graphics2D;
import Pacman.Data.DataForView;
import Pacman.Logic.Fantome;

/**
 * 
 * La classe dessinerFantome permet de gérer les sprites des Fantomes.
 * 
 * @author Arthur Pêtre
 */
public class dessinerFantome {
    private int spriteActuel = 0;
    private int waitSprite = 0;
    private int offsetX = 4;
    private int offsetY = 24;

    private Fantome fantome;
    private DataForView data;

    /**
     * Constructeur de la classe, assigne Fantome et DataForView aux attributs
     * correspondants.
     * 
     * @param fantome Fantome que l'on va dessiner.
     * @param data    permet de récuperer les sprites depuis Data.
     */
    public dessinerFantome(Fantome fantome, DataForView data) {
        this.fantome = fantome;
        this.data = data;
    }

    /**
     * Met à jour le numéro de sprite actuel et dessine le Fantome voulu.
     * 
     * @param g2d objet Graphics2D permettant de mettre à jour les sprites.
     */
    public void dessiner(Graphics2D g2d) {
        dessinerSpriteFantome(g2d);
        // updateOffsets();
        if (waitSprite == 4) {
            updateSprite();
            waitSprite = 0;
        } else {
            waitSprite++;
        }
    }

    /**
     * Met à jour le numéro de sprite actuel.
     */
    private void updateSprite() {
        if (this.spriteActuel == 0) {
            this.spriteActuel = 1;
        } else {
            this.spriteActuel = 0;
        }
    }

    /**
     * Met à jour le décalage X et Y des images.
     */
    private void updateOffsets() {
        double[] position = this.fantome.getPosition();
        if (position[0] >= 0 && position[0] < 0.11) {
            this.offsetX = 0;
        } else if (position[0] >= 0.11 && position[0] < 0.22) {
            this.offsetX = 1;
        } else if (position[0] >= 0.22 && position[0] < 0.33) {
            this.offsetX = 2;
        } else if (position[0] >= 0.33 && position[0] < 0.44) {
            this.offsetX = 3;
        } else if (position[0] >= 0.44 && position[0] < 0.55) {
            this.offsetX = 4;
        } else if (position[0] >= 0.55 && position[0] < 0.66) {
            this.offsetX = 5;
        } else if (position[0] >= 0.66 && position[0] < 0.77) {
            this.offsetX = 6;
        } else if (position[0] >= 0.77 && position[0] < 0.88) {
            this.offsetX = 7;
        } else if (position[0] >= 0.88 && position[0] < 0) {
            this.offsetX = 8;
        }

        if (position[1] >= 0 && position[1] < 0.11) {
            this.offsetY = 24;
        } else if (position[1] >= 0.11 && position[1] < 0.22) {
            this.offsetY = 25;
        } else if (position[1] >= 0.22 && position[1] < 0.33) {
            this.offsetY = 26;
        } else if (position[1] >= 0.33 && position[1] < 0.44) {
            this.offsetY = 27;
        } else if (position[1] >= 0.44 && position[1] < 0.55) {
            this.offsetY = 28;
        } else if (position[1] >= 0.55 && position[1] < 0.66) {
            this.offsetY = 29;
        } else if (position[1] >= 0.66 && position[1] < 0.77) {
            this.offsetY = 30;
        } else if (position[1] >= 0.77 && position[1] < 0.88) {
            this.offsetY = 31;
        } else if (position[1] >= 0.88 && position[1] < 0) {
            this.offsetY = 32;
        }
    }

    /**
     * Dessine le Fantome voulu selon son état.
     * 
     * @param g2d objet Graphics2D permettant de mettre à jour les sprites.
     */
    private void dessinerSpriteFantome(Graphics2D g2d) {
        switch (this.spriteActuel) {
        case 0:
            switch (this.fantome.getStatut()) {
            case CHASSEUR:
                g2d.drawImage(
                        this.data.getFantomesSprites(this.fantome.getCouleur(), this.fantome.getDirectionCourante())[0],
                        ((int) this.fantome.getposX()) * 8 + this.offsetX,
                        ((int) this.fantome.getposY()) * 8 + this.offsetY, null);
                break;

            case VULNERABLE:
                g2d.drawImage(this.data.getVulnerableFantomesSprites()[0],
                        ((int) this.fantome.getposX()) * 8 + this.offsetX, ((int) fantome.getposY()) * 8 + this.offsetY,
                        null);
                break;

            case MORT:
                g2d.drawImage(this.data.getMortFantomeSprites()[0], ((int) this.fantome.getposX()) * 8 + this.offsetX,
                        ((int) this.fantome.getposY()) * 8 + this.offsetY, null);
                break;

            default:
                break;
            }
            break;

        case 1:
            switch (this.fantome.getStatut()) {
            case CHASSEUR:
                g2d.drawImage(
                        this.data.getFantomesSprites(this.fantome.getCouleur(), this.fantome.getDirectionCourante())[1],
                        ((int) this.fantome.getposX()) * 8 + this.offsetX,
                        ((int) this.fantome.getposY()) * 8 + this.offsetY, null);
                break;

            case VULNERABLE:
                g2d.drawImage(this.data.getVulnerableFantomesSprites()[1],
                        ((int) this.fantome.getposX()) * 8 + this.offsetX,
                        ((int) this.fantome.getposY()) * 8 + this.offsetY, null);
                break;

            case MORT:
                g2d.drawImage(this.data.getMortFantomeSprites()[1], ((int) this.fantome.getposX()) * 8 + this.offsetX,
                        ((int) this.fantome.getposY()) * 8 + this.offsetY, null);
                break;
            }
            break;
        }
    }
}
