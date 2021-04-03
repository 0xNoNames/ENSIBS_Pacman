package Pacman.Logic;

/**
 * 
 * 
 * @author François JULLION
 */
public class Jouable extends Case implements ICase{
    /**
     * 
     */
    private Objet objet;

    public Jouable() {
        this.objet = null;
    }

    public Objet getObjet() {
        return this.objet;
    }

    public void setObjet(Objet o) {
        this.objet = o;
    }
}
