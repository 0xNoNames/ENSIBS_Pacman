On ne considère pas le mode scatter

# Comportements communs

Le fantôme détermine sa case target.

Puis il détermine la prochaine case la plus proche de la target :

 - il ne peut pas faire demi tour.
 - il ne peut pas aller dans un mur.
 - si deux cases sont à distance égale de la target, l'ordre est le suivant :
   - nord > ouest > sud > est (ignoré)

La distance est sqrt[(xb - xa)^2 + (yb - ya)^2]. La racine n'est peut être pas importante ?

# Comportements spécifiques

## Blinky

Target = Pacman

## Pinky

Target = Pacman + 4 cases dans la direction courante de Pacman

## Inky

Target = Pacman - (différence entre Pacman et Blinky)

## Clyde

Target = idem que Blinky si dans un rayon > 8 cases par rapport à Pacman
         idem que son scatter mode si dans un rayon < 8 cases par rapport à Pacman

La target en scatter est le coin sud ouest.

## Fantôme mort

Target = milieu du spawn des fantômes

Une fois atteinte, direction courante = nord

## Vulnérable

Les fantômes font demi tour lors du passage chasseur -> vulnérable ou du passage vulnérable -> chasseur.

Au lieu d'utiliser une target, le fantôme choisit aléatoirement une direction selon les 2 premières conditions décrites dans # Comportements communs.
