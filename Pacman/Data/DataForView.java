package Pacman.Data;

import java.awt.Image;

import Pacman.Logic.ECouleur;

/**
 * DataForView stocke les différentes données susceptibles d'être demandées par
 * la View. Elle agit comme un cache.
 * 
 * @author Louis-Baptiste Sobolewski
 */
public class DataForView implements ISprites {
    private static String cheminSpriteComplet = "/Pacman/Data/sprites.png";
    private Image spriteComplet;
    
    public DataForView()
    {
        
    }

    @Override
    public Image[] getPacmanSprites() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Image[] getMortPacmanSprites() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Image[] getFantomesSprites(ECouleur couleur) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Image[] getMortFantomeSprites() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Image[] getGommesSprites() {
        // TODO Auto-generated method stub
        return null;
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
    public Image[] getMur() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Image[] getRGOSprite() {
        // TODO Auto-generated method stub
        return null;
    }
}
