package Pacman.View;
package Pacman.Data;

public class main {

    entreeClavier keyboard;

    public static void main(String[] args) {
        System.out.println("Démarrage...");
        entreeClavier test = new entreeClavier();

        Fenetre fenetre = new Fenetre();

        fenetre.setVisible(true);
        getGrilleInitiale()

        fenetre.addKeyListener(new entreeClavier());
        System.out.println("Done");
    }
}
