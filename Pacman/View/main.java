package Pacman.View;

public class main {

    entreeClavier keyboard;

    public static void main(String[] args) {
        System.out.println("Démarrage...");
        entreeClavier test = new entreeClavier();

        Fenetre fenetre = new Fenetre();

        fenetre.setVisible(true);

        fenetre.addKeyListener(new entreeClavier());
        System.out.println("Done");
    }
}
