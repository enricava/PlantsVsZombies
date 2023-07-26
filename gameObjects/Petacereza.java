package gameObjects;

import pr3.Game;

public class Petacereza extends Plant {
	private final static int INITIAL_HP = 2;
	private final int NUM_CYCLES = 2;
	private final static char SYMBOL = 'c';
	private final static int HARM = 10;

	public Petacereza() {
		super(-1, -1, INITIAL_HP,  SYMBOL, HARM, null);
		cost = 50;
	}
	
	public Petacereza(int x, int y , Game game) {
		super(x, y, INITIAL_HP, SYMBOL, HARM,  game);
	}

	public void update() {
		++cycle;
		if(cycle == NUM_CYCLES) {
			game.explode(x, y, HARM);
			hp = 0;
		}
		
	}

}
