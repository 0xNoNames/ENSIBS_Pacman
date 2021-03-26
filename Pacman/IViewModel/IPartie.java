package Pacman.IViewModel;

import Pacman.Model.EStatutPartie;

public interface IPartie {
   	public void tick();
   	public int getNiveau();
	public int getPoints();
	public EStatutPartie getEtatPartie();	
}
