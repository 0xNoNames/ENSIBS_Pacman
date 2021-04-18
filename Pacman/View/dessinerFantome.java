package Pacman.View;

import java.awt.Graphics2D;
import Pacman.Data.DataForView;
import Pacman.Logic.Fantome;
import Pacman.Logic.Partie;

/**
 * 
 * La classe dessinerFantome permet de gérer les sprites des Fantomes.
 * 
 * @author Arthur Pêtre
 */
public class dessinerFantome {
    private int spriteActuel = 0;
    private int waitSprite = 0;
    private int offsetX = -4;
    private int offsetY = 24;

    private Fantome fantome;
    private DataForView data;
    private Partie partie;

    /**
     * Constructeur de la classe, assigne Fantome et DataForView aux attributs
     * correspondants.
     * 
     * @param fantome Fantome que l'on va dessiner.
     * @param data    permet de récuperer les sprites depuis Data.
     */
    public dessinerFantome(Fantome fantome, Partie partie, DataForView data) {
        this.fantome = fantome;
        this.data = data;
        this.partie = partie;
    }

    /**
     * Met à jour le numéro de sprite actuel et dessine le Fantome voulu.
     * 
     * @param g2d objet Graphics2D permettant de mettre à jour les sprites.
     */
    public void dessiner(Fantome fantome, Partie partie, Graphics2D g2d) {
        this.fantome = fantome;
        this.partie = partie;
        dessinerSpriteFantome(g2d);
        // updateOffsets();

        if (waitSprite == 8) {
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
        double positionX = position[0] - (int) position[0];
        double positionY = position[1] - (int) position[1];

        offsetX = (int) ((positionX * 100.00 / 10.00)) + 4;
        offsetY = (int) (positionY * 100.00 / 10.00) + 24;
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
            case DEBUTPARTIE:
                g2d.drawImage(
                        this.data.getFantomesSprites(this.fantome.getCouleur(), this.fantome.getDirectionCourante())[0],
                        ((int) this.fantome.getposX()) * 8 + this.offsetX,
                        ((int) this.fantome.getposY()) * 8 + this.offsetY, null);
                break;
            case CHASSEUR:
                g2d.drawImage(
                        this.data.getFantomesSprites(this.fantome.getCouleur(), this.fantome.getDirectionCourante())[0],
                        ((int) this.fantome.getposX()) * 8 + this.offsetX,
                        ((int) this.fantome.getposY()) * 8 + this.offsetY, null);
                break;
            case VULNERABLE:
                if (this.partie.getCompteurVulnerable() >= 375) {
                    g2d.drawImage(this.data.getVulnerableFantomesSprites()[3],
                            ((int) this.fantome.getposX()) * 8 + this.offsetX,
                            ((int) fantome.getposY()) * 8 + this.offsetY, null);
                } else {
                    g2d.drawImage(this.data.getVulnerableFantomesSprites()[0],
                            ((int) this.fantome.getposX()) * 8 + this.offsetX,
                            ((int) fantome.getposY()) * 8 + this.offsetY, null);
                }
                break;

            case MORT:
                g2d.drawImage(this.data.getMortFantomeSprites(this.fantome.getDirectionCourante()),
                        ((int) this.fantome.getposX()) * 8 + this.offsetX,
                        ((int) this.fantome.getposY()) * 8 + this.offsetY, null);
                break;

            default:
                break;
            }
            break;

        case 1:
            switch (this.fantome.getStatut()) {
            case DEBUTPARTIE:
                g2d.drawImage(
                        this.data.getFantomesSprites(this.fantome.getCouleur(), this.fantome.getDirectionCourante())[1],
                        ((int) this.fantome.getposX()) * 8 + this.offsetX,
                        ((int) this.fantome.getposY()) * 8 + this.offsetY, null);
                break;
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
                g2d.drawImage(this.data.getMortFantomeSprites(this.fantome.getDirectionCourante()),
                        ((int) this.fantome.getposX()) * 8 + this.offsetX,
                        ((int) this.fantome.getposY()) * 8 + this.offsetY, null);
                break;
            }
            break;
        }
    }
}
