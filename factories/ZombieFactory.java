package factories;

import gameObjects.Caracubo;
import gameObjects.Classic;
import gameObjects.Deportista;
import gameObjects.Zombie;
import pr3.Game;

public class ZombieFactory {
	
	private static Zombie[] availableZombies = {
		new Classic(),
		new Deportista(),
		new Caracubo()
	};

    public static Zombie getZombie(String zombieName, Game game){
    	Zombie zombie = null;
    	zombieName.toLowerCase();
        for(int i = 0; i < availableZombies.length && zombie == null; i++) {
        	if(availableZombies[i].getSymbol() == zombieName.charAt(0))
        		zombie = availableZombies[i];
        		renew(i);
        }
        if(zombie != null) zombie.setGame(game);
        return zombie;
    }

	public static Zombie getType(int zombieNumber) {
		Zombie zombie = availableZombies[zombieNumber];
		renew(zombieNumber);
		return zombie;
	}
    
	public static int getNumberOfTypes() {
		return availableZombies.length;
	}
	
	private static void renew(int i) {
    	switch(i) {
    	case 0: availableZombies[0] = new Classic();
    	case 1: availableZombies[1] = new Deportista();
    	case 2: availableZombies[2] = new Caracubo();
    	}
    }
	
}