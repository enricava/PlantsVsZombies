package gameObjects;

import pr3.Game;

public class Sunflower extends Plant {
	private final static int INITIAL_HP = 1;
	private final int NUM_CYCLES = 2;
	private final static char SYMBOL = 's';
	private final static int HARM = 0;
	
	public Sunflower() {
		super(-1, -1, INITIAL_HP,  SYMBOL, HARM, null);
		cost = 20;
	}

	public Sunflower(int x, int y , Game game) {
		super(x, y, INITIAL_HP, SYMBOL, HARM,  game);
	}
	
	public void update() {
		++cycle;
		if(cycle % NUM_CYCLES == 0) game.addSuncoins();	
	}

	
}

