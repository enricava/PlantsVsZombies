package gameObjects;

import pr3.Game;

public class Deportista extends Zombie {
	
	private static final int HARM = 1;
	private static final char SYMBOL = 'd';
	private final int NUM_CYCLES = 1;
	private final static int INITIAL_HP = 2;
	
	public Deportista(int x, int y, Game game) {
		super(x, y, INITIAL_HP, SYMBOL, HARM, game);
	}

	public Deportista() {
		super(-1, -1, INITIAL_HP, SYMBOL, HARM, null);
	}

	public void update() {
		++cycle;
		
		game.zombieAction(x, y, HARM);
		
		if(game.validPos(x, y - 1) && (cycle % NUM_CYCLES==0) && hp > 0)
			y = y - 1;
			
	}
	
}
