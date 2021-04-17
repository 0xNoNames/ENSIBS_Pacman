package Pacman.Logic;

import Pacman.Data.DataForLogic;

public class Test {
    
    public static void main(String[] args) {
        DataForLogic d = new DataForLogic();

        System.out.println(d.getFruitNiveau(21));
        /* Test Grille + Entite + Déplacement */
        Case[][] t1 = new Case[3][3];
        t1[0][0] = new Mur();
        t1[0][1] = new Jouable();
        t1[0][2] = new Jouable();
        t1[1][0] = new Jouable();
        t1[1][1] = new Jouable();
        t1[1][2] = new Mur();
        t1[2][0] = new Jouable();
        t1[2][1] = new Jouable();
        t1[2][2] = new Jouable();

        Grille g = new Grille(t1);

        Partie p = new Partie();
        p.d = d;

        Pacman p1 = new Pacman();
        p1.setPosX(0);
        p1.setPosY(2);
        p1.setGrille(g);
        p1.setPartie(p);
        Inky ink = new Inky(2,2);
        ink.setGrille(g);
        ink.setPartie(p);
        ink.dirCourante = EDirection.NORD;
        
        //Deplacement test
        ink.deplacer(p1);
        
        
        p.tick();

    }
}
