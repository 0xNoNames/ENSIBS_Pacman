package Pacman.Logic;

/**
 * 
 * 
 * @author François JULLION
 */
public class Blinky extends Fantome {
    
    /**
     * Constructeur de la classe Blinky
     */
    public Blinky() {
        this.couleur = ECouleur.ROUGE;
    }

    /**
     * 
     */
    public void deplacer(Pacman p) {
        /* Calcul de la direction Voulue */
        double diffX = p.getposX() - this.getposX();
        double diffY = p.getposY() - this.getposY();
        if(diffX > diffY){
            if(diffX > 0 ) {
                dirVoulue = EDirection.EST;
            } else {
                dirVoulue = EDirection.OUEST;
            }
        } else {
            if(diffY > 0){
                dirVoulue = EDirection.SUD;
            } else {
                dirVoulue = EDirection.NORD;
            }
        }
        /* Test si la direction voulue est possible */
        int[] posActuelle = {(int)this.posX,(int)this.posY};
        int[] posVoulue = {0,0};
        switch(dirVoulue) {
            case EST:
                posVoulue[0] = posActuelle[0] + 1;
                posVoulue[1] = posActuelle[1];
                break;
            case OUEST:
                posVoulue[0] = posActuelle[0] - 1;
                posVoulue[1] = posActuelle[1];
                break;
            case NORD:
                posVoulue[0] = posActuelle[0];
                posVoulue[1] = posActuelle[1] - 1;
                break;
            case SUD:
                posVoulue[0] = posActuelle[0];
                posVoulue[1] = posActuelle[1] + 1;
                break;
        }
        /* */
        boolean deplacementVouluPossible = false;
        if() {

        } else if(posVoulue[0]<0 || posVoulue[0]>=grille.getCases().length || posVoulue[1]<0 || posVoulue[1]>=grille.getCases()[0].length) {
            deplacementVouluPossible = true;
        } else if(grille.getCases()[posVoulue[0]][posVoulue[1]] instanceof Jouable){
            deplacementVouluPossible = true;        
        } 
        /* MAJ dirCourante si deplacement voulue possible*/
        boolean deplacementCourantPossible = false;
        if(deplacementVouluPossible) {
            dirCourante = dirVoulue;
        } else {
            /* Sinon on vérifie la direction courante est possible */
            switch(dirVoulue) {
                case EST:
                    posVoulue[0] = posActuelle[0] + 1;
                    posVoulue[1] = posActuelle[1];
                    break;
                case OUEST:
                    posVoulue[0] = posActuelle[0] - 1;
                    posVoulue[1] = posActuelle[1];
                    break;
                case NORD:
                    posVoulue[0] = posActuelle[0];
                    posVoulue[1] = posActuelle[1] - 1;
                    break;
                case SUD:
                    posVoulue[0] = posActuelle[0];
                    posVoulue[1] = posActuelle[1] + 1;
                    break;
            }
            if(posVoulue[0]<0 || posVoulue[0]>=grille.getCases().length || posVoulue[1]<0 || posVoulue[1]>=grille.getCases()[0].length) {
                deplacementCourantPossible = true;
            } else if(grille.getCases()[posVoulue[0]][posVoulue[1]] instanceof Jouable){
                deplacementCourantPossible = true;        
            } 
        }
        /* Si une direction est possible on déplace */
        if(deplacementVouluPossible) {
            this.posX += d.getVitesseFantome() * ;
            this.posy += d.getVitesseFantome() * ;
        } else if(deplacementCourantPossible) {
            this.posX +=
            this.posy = 
        }
    }
}
