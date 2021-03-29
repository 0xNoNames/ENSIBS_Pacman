package Pacman.Data;

import Pacman.Logic.ECouleur;
import Pacman.Logic.Fruit;
import Pacman.Logic.Grille;
import Pacman.Logic.Objet;

public class DataForLogic implements IEntite, IFruit, IGrille, IObjet
{
    @Override
    public double getVitessePacman(int niveau) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getVitesseFantome(int niveau, ECouleur couleur) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double[] getPositionInitialePacman() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double[] getPositionInitialeFantome() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Fruit getFruitNiveau(int niveau) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Grille getGrilleInitiale() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getPoints(Objet objet) {
        throw new UnsupportedOperationException();
    }
}
