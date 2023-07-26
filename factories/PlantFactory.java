package factories;

import gameObjects.Nuez;
import gameObjects.Peashooter;
import gameObjects.Petacereza;
import gameObjects.Plant;
import gameObjects.Sunflower;
import pr3.Game;

public class PlantFactory {
	
	private static Plant[] availablePlants = {
		new Peashooter(),
		new Sunflower(),
		new Petacereza(),
		new Nuez()
	};

    public static Plant getPlant(char plantSymbol, Game game){
    	Plant plant = null;
        for(int i = 0; i < availablePlants.length && plant == null; i++) {
        	if(availablePlants[i].getSymbol() == plantSymbol) {
        		plant = availablePlants[i];
        		renew(i);
        	}
        }
        if(plant != null) plant.setGame(game);
        return plant;
    } 
    
    public static void listOfAvailablePlants(){
    	//for each llamar plant.list
       System.out.println("[P]eashooter: Cost: " + availablePlants[0].getCost());
       System.out.println("[S]unflower: Cost: " + availablePlants[1].getCost());
       System.out.println("Peta[C]ereza: Cost: " + availablePlants[2].getCost());
       System.out.println("[N]uez: Cost: " + availablePlants[3].getCost());
    }
    
    private static void renew(int i) {
    	switch(i) {
    	case 0: availablePlants[0] = new Peashooter();
    	case 1: availablePlants[1] = new Sunflower();
    	case 2: availablePlants[2] = new Petacereza();
    	case 3: availablePlants[3] = new Nuez();
    	}
    }
}
