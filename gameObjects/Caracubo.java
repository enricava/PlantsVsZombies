package gameObjects;

import pr3.Game;

public class Caracubo extends Zombie{

	private static final int INITIAL_HP = 8;
	private final int NUM_CYCLES = 4;
	private static final int HARM = 1;
	private static final char SYMBOL = 'c';
	
	public Caracubo(int x, int y, Game game) {
		super(x, y, INITIAL_HP, SYMBOL, HARM, game);
	}

	public Caracubo() {
		super(-1, -1, INITIAL_HP, SYMBOL, HARM, null);
	}

	public void update() {
		++cycle;
		game.zombieAction(x, y, HARM);
		
		if(game.validPos(x, y - 1) && (cycle % NUM_CYCLES==0) && hp > 0)
			y = y - 1;

	}
}
