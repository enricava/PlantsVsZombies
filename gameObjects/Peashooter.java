package gameObjects;

import pr3.Game;

public class Peashooter extends Plant {

	private final static int INITIAL_HP = 3;
	private final static int PEASHOOTER_DAMAGE = 1;
	private final static char SYMBOL = 'p';
	private final int NUM_CYCLES = 1;
	
	public Peashooter() {
		super(-1, -1, INITIAL_HP, SYMBOL, PEASHOOTER_DAMAGE,  null);
		cost = 50;
	}
	
	public Peashooter(int x, int y, Game game) {
		super(x, y, INITIAL_HP, SYMBOL, PEASHOOTER_DAMAGE,  game);
	}
	
	public void update() {
		++cycle;
		if(cycle % NUM_CYCLES == 0) 
			game.peashooterAction(x,y, PEASHOOTER_DAMAGE);

	}
	
}