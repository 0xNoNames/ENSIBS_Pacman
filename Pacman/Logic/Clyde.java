package Pacman.Logic;

/**
 * Le classe Blinky permet de représenter un des quatres fantomes du jeu
 * 
 * @author François JULLION
 */
public class Clyde extends Fantome {
    
    /**
     * Constructeur de la classe Clyde
     */
    public Clyde(double x, double y) {
        super(x,y);
        this.couleur = ECouleur.ORANGE;
    }

    /**
     * Permet de déplacer aléatoirement Clyde
     */
    public void deplacer() {
        /* Selection aléatoire d'une direction voulue */
        EDirection[] tab = {EDirection.EST,EDirection.NORD,EDirection.SUD,EDirection.OUEST};
        int indice = (int) (Math.random() * tab.length);
        this.dirVoulue = tab[indice];

        /* Calcul de la position Voulue */
        int[] posActuelle = getPositionActuelle();
        int[] posVoulue = calculPosDirection(this.dirVoulue, posActuelle);

        /* Test si la direction voulue est possible */
         boolean deplacementVouluPossible = estPositionPossible(posVoulue);

        /* MAJ dirCourante si deplacement voulue possible*/
         boolean deplacementCourantPossible = false;
         if(deplacementVouluPossible) {
             dirCourante = dirVoulue;
        } else {
             /* Sinon on vérifie si la direction courante est possible */
             posVoulue = calculPosDirection(dirCourante, posActuelle);
             deplacementCourantPossible = estPositionPossible(posVoulue); 
        }

        /* Si une direction est possible on déplace */
        if(deplacementVouluPossible) {
            switch(dirVoulue) {
                case EST:
                    this.posX += Partie.d.getVitesseFantome(this.partie.getNiveau(),this.couleur) * (1.0/Partie.tickParSeconde);
                    break;
                case OUEST:
                    this.posX -= Partie.d.getVitesseFantome(this.partie.getNiveau(),this.couleur) * (1.0/Partie.tickParSeconde);
                    break;
                case SUD:
                    this.posY += Partie.d.getVitesseFantome(this.partie.getNiveau(),this.couleur) * (1.0/Partie.tickParSeconde);
                    break;
                case NORD:
                    this.posY -= Partie.d.getVitesseFantome(this.partie.getNiveau(),this.couleur) * (1.0/Partie.tickParSeconde);
                    break;
            }
        } else if(deplacementCourantPossible) {
            switch(dirCourante) {
                case EST:
                    this.posX += Partie.d.getVitesseFantome(this.partie.getNiveau(),this.couleur) * (1.0/Partie.tickParSeconde);
                    break;
                case OUEST:
                    this.posX -= Partie.d.getVitesseFantome(this.partie.getNiveau(),this.couleur) * (1.0/Partie.tickParSeconde);
                    break;
                case SUD:
                    this.posY += Partie.d.getVitesseFantome(this.partie.getNiveau(),this.couleur) * (1.0/Partie.tickParSeconde);
                    break;
                case NORD:
                    this.posY -= Partie.d.getVitesseFantome(this.partie.getNiveau(),this.couleur) * (1/Partie.tickParSeconde);
                    break;
            }  
        }
         
    }
}
