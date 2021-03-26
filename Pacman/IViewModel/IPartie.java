package Pacman.IViewModel;

public interface IPartie {
   	public void tick();
   	public int getNiveau();
	public int getPoints();
	public EStatutPartie getEtatPartie();	
}
