package pr3;

import gameObjects.Plant;

public class SuncoinManager {

	private final int INITIAL_SUNCOINS = 100;
	private int suncoins;
	
	
	public SuncoinManager() {
		suncoins = INITIAL_SUNCOINS;
	}
	

	public void addSuncoins(){
		suncoins = suncoins + 5;
	}

	public boolean buyPlant(Plant plant){
		if (suncoins >= plant.getCost()) {
			suncoins = suncoins - plant.getCost();
			return true;
		}
		return false;
	}


	public int getSuncoins() {
		return suncoins;
	}
	
}
