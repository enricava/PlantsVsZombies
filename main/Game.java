package pr3;

import factories.ZombieFactory;
import gameObjects.GameObjectList;
import gameObjects.Plant;
import gameObjects.Zombie;

public class Game {

	public final int SIZE = 1;
	public final int DIM_X = 4;
	public final int DIM_Y = 7;
	
	private GameObjectList plants;
	private GameObjectList zombies;
	private SuncoinManager suncoins;
	private ZombieManager zombieManager;
	private int cycleCount;
	private int seed;
	private String winner;
	private Level level;
	
	public Game(Level level, int seed) { 
		plants = new GameObjectList(SIZE);
		zombies = new GameObjectList(SIZE);
		this.level = level;
		suncoins = new SuncoinManager();
		zombieManager = new ZombieManager(level, seed);
		this.seed = seed;
		winner = "a";
		cycleCount = 0;
	}

	public void update() {
		plants.update();
		zombies.update();
		
		addZombie();
		
		cycleCount ++;
	}
	
	private void addZombie() {
		int randomRow = zombieManager.newPos(DIM_X);
		int zombieNumber;
		if (validPos(randomRow, DIM_Y - 2) && zombieManager.isZombieAdded()) {
			zombieNumber = zombieManager.randomZombieType(ZombieFactory.getNumberOfTypes());
			Zombie zombie = ZombieFactory.getType(zombieNumber);
			zombie.setGame(this);
			zombie.setPosition(randomRow, DIM_Y - 2);
			zombies.add(zombie);
		}
	}
	
	public boolean isGameFinished(){
		if (zombiesWin()) {
			winner = "ZOMBIES"; 
			return true;
		}
		if (plantsWin()) {
			winner = "PLANTS";
			return true;
		}
		else return false;
	}
	

	
	public void peashooterAction(int x, int y, int harm){
		boolean ok = false;
		int i = 0;
		while (i + y < DIM_Y && !ok) {	
			ok = zombies.doDamage(x, y+i, harm);
			++i;
		}
	}
	
	public void zombieAction (int x, int y, int harm) {
		plants.doDamage(x,y - 1,harm);
	}
	

	public boolean validPos(int x, int y) {
		return (plants.emptyPos(x,y) && zombies.emptyPos(x,y) && x < DIM_X && y < DIM_Y) ;
	}
	
	
	public boolean addPlant(Plant plant, int x, int y) {
		boolean ok = false;
		if(suncoins.buyPlant(plant)) {
			plant.setPosition(x, y);
			plants.add(plant);
			ok = true;
		}
		return ok;
	}
	
	private boolean plantsWin() {
		return (zombieManager.leftToAppear() == 0 && zombies.noZombies());
	}
	
	private boolean zombiesWin() {
		return (zombies.zombiesWin());
	}
	
	
	public int getSeed() {
		return seed;
	}

	public void addSuncoins() {
		suncoins.addSuncoins();
	}
	
	public int getSuncoins() {
		return suncoins.getSuncoins();
	}
	
	public int getCycleCount() {
		return cycleCount;
	}

	public String getWinner(){
		return winner;
	}
	
	public String toString(int x, int y) {
		String string;
		string = " ";
		if (string == " ") string = plants.toString(x,y);
		if (string == " ") string = zombies.toString(x,y);
		return string;
	}
	
	public int getDimY() {
		return DIM_Y;
	}
	public int getDimX() {
		return DIM_X;
	}
	
	public int getRemainingZombies() {
		return zombieManager.getRemainingZombies();
	}

	public void explode(int x, int y, int harm) {
		zombies.doDamage(x+1, y+1, harm);
		zombies.doDamage(x+1, y,   harm);
		zombies.doDamage(x,   y+1, harm);
		zombies.doDamage(x-1, y+1, harm);
		zombies.doDamage(x-1, y,   harm);
		zombies.doDamage(x-1, y-1, harm);
		zombies.doDamage(x,   y-1, harm);
		zombies.doDamage(x+1, y-1, harm);
	}

	public void resetGame() {
		plants = new GameObjectList(SIZE);
		zombies = new GameObjectList(SIZE);
		suncoins = new SuncoinManager();
		zombieManager = new ZombieManager(level, seed);
		winner = "a";
		cycleCount = 0;
	}

	public void addZombieManually(Zombie zombie, int x, int y) {
		zombie.setPosition(x, y);
		zombies.add(zombie);
	}
	
	public String listsToString() {
		return plants.toString() + zombies.toString();
	}
	
	public int getListsLength() {
		int i = plants.getCap() + zombies.getCap();
		return i;
	}

	public String toInfoStringLists(int i) {
		if(i >= plants.getCap()) return zombies.toInfoString(i - plants.getCap());
		else return plants.toInfoString(i);
	}
}
