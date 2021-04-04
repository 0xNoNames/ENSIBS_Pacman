package Pacman.Logic;

/**
 * 
 * 
 * @author François JULLION
 */
public class Grille {

    /**
     * 
     */
    private Case[][] cases;

    /**
     * 
     */
    private Pacman pac;

    /**
     * 
     */
    private Blinky blinky;

    /**
     * 
     */
    private Clyde clide;

    /**
     * 
     */
    private Inky inky;

    /**
     * 
     */
    private Pinky pinky;

    public Grille(Case[][] c) {
        this.pac = new Pacman();
        this.clide = new Clyde();
        this.inky = new Inky();
        this.pinky = new Pinky();
        this.blinky = new Blinky();
        // TODO set les positions des entités
        this.cases = c;
    }

    public Pacman getPacman() {
        return this.pac;
    }

    public Pinky getPinky() {
        return this.pinky;
    }

    public Clyde getClyde() {
        return this.clide;
    }

    public Inky getInky() {
        return this.inky;
    }

    public Blinky getBlinky() {
        return this.blinky;
    }

    public Case[][] getCases() {
        return this.cases;
    }
}
