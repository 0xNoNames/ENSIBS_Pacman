package Pacman.Data;

import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import Pacman.Logic.ECouleur;

/**
 * DataForView stocke les différentes données susceptibles d'être demandées par
 * la View. Elle agit comme un cache.
 * 
 * @author Louis-Baptiste Sobolewski
 */
public class DataForView implements ISprites {
    private static String cheminSpriteComplet = "/Pacman/Data/sprites.png";
    private BufferedImage spriteComplet;
    private Image[] pacmanSprites, mortPacmanSprites, fantomesSprites,
        mortFantomesSprites, gommesSprites;
    
    public DataForView()
    {
        try {
            spriteComplet = (BufferedImage) ImageIO.read(
                DataForView.class.getResourceAsStream(cheminSpriteComplet)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(spriteComplet);
    }

    @Override
    public Image[] getPacmanSprites() {
        // si ces sprites n'ont pas encore été demandés
        if (pacmanSprites == null)
        {
            pacmanSprites = new Image[9];

            pacmanSprites[0] = spriteComplet.getSubimage(41, 4, 16, 16);
            pacmanSprites[1] = spriteComplet.getSubimage(1, 4, 16, 16);
            pacmanSprites[2] = spriteComplet.getSubimage(21, 4, 16, 16);
            pacmanSprites[3] = spriteComplet.getSubimage(1, 24, 16, 16);
            pacmanSprites[4] = spriteComplet.getSubimage(21, 24, 16, 16);
            pacmanSprites[5] = spriteComplet.getSubimage(1, 44, 16, 16);
            pacmanSprites[6] = spriteComplet.getSubimage(21, 44, 16, 16);
            pacmanSprites[7] = spriteComplet.getSubimage(1, 64, 16, 16);
            pacmanSprites[8] = spriteComplet.getSubimage(21, 64, 16, 16);
        }

        return pacmanSprites;
    }

    @Override
    public Image[] getMortPacmanSprites() {
        // si ces sprites n'ont pas encore été demandés
        if (mortPacmanSprites == null)
        {
            mortPacmanSprites = new Image[11];

            // tous ces sprites sont sur la même ligne
            for (int i = 0; i < mortPacmanSprites.length; i++)
            {
                mortPacmanSprites[i] =
                    spriteComplet.getSubimage(245, 1 + 20 * i, 16, 16);
            }
        }

        return mortPacmanSprites;
    }

    @Override
    public Image[] getFantomesSprites(ECouleur couleur) {
        // si ces sprites n'ont pas encore été demandés
        if (fantomesSprites == null)
        {
            fantomesSprites = new Image[34];

            // les fantomes normaux sont sur 4 lignes 8 colonnes
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 8; j++)
                {
                    fantomesSprites[i * 8 + j] = spriteComplet.getSubimage(
                        84 + i * 20, 1 + j * 20, 16, 16
                    );
                }
            }

            // il manque l'état vulnérable
            fantomesSprites[32] = spriteComplet.getSubimage(1, 164, 16, 16);
            fantomesSprites[32] = spriteComplet.getSubimage(21, 164, 16, 16);
        }

        return fantomesSprites;
    }

    @Override
    public Image[] getMortFantomeSprites() {
        // si ces sprites n'ont pas encore été demandés
        if (mortFantomesSprites == null)
        {
            mortFantomesSprites = new Image[2];

            mortFantomesSprites[0] = spriteComplet.getSubimage(41, 164, 16, 16);
            mortFantomesSprites[1] = spriteComplet.getSubimage(61, 164, 16, 16);
        }

        return mortFantomesSprites;
    }

    @Override
    public Image[] getGommesSprites() {
        // si ces sprites n'ont pas encore été demandés
        if (gommesSprites == null)
        {
            gommesSprites = new Image[2];

            gommesSprites[0] = spriteComplet.getSubimage(112, 184, 7, 7);
            gommesSprites[1] = spriteComplet.getSubimage(1, 184, 7, 7);
        }

        return gommesSprites;
    }

    @Override
    public Image[] getFruitSprites() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Image[] getLettresChiffres() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Image[] getPoints() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Image getGrille() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Image[] getRGOSprite() {
        // TODO Auto-generated method stub
        return null;
    }
}
