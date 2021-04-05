package Pacman.View;

public class main {
    entreeClavier keyboard;

    // Test des fonctions
    public static void main(String[] args) {
        System.out.println("Démarrage...");

        // data = new DataForView();
        Fenetre fenetre = new Fenetre();
        // dessinerPacman dessinerpacman = new dessinerPacman();

        // JLabel grilleLabel = new JLabel(new ImageIcon(data.getGrille()));
        // JLabel pacmanLabel = new JLabel(new
        // ImageIcon(data.getPacmanSprites(EDirection.NORD)[0]));

        // fenetre.add(grilleLabel);

        // Pacman pacman = new Pacman();
        // dessinerpacman.dessiner(pacman, fenetre, data);

        fenetre.setVisible(true);

        System.out.println("Done");
    }
}
