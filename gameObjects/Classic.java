package gameObjects;

import pr3.Game;

public class Classic extends Zombie {
	
	private static final int INITIAL_HP = 5;
	private static final int HARM = 1;
	private final int NUM_CYCLES = 2;
	private static final char SYMBOL = 'z';
	
	public Classic(int x, int y, Game game) {
		super(x, y, INITIAL_HP, SYMBOL, HARM, game);
	}
	
	public Classic() {
		super(-1, -1, INITIAL_HP, SYMBOL, HARM, null);
	}

	public void update() {
		++cycle;
		game.zombieAction(x, y, HARM);
		
		if(game.validPos(x, y - 1) && (cycle % NUM_CYCLES == 0) && hp > 0) 
			y = y -1;
	}
	
	
}
