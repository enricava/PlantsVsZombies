package gameObjects;

import pr3.Game;

public class Nuez extends Plant{
	private final static int INITIAL_HP = 10;
	private final static char SYMBOL = 'n';
	private final static int HARM = 0;

	public Nuez() {
		super(-1, -1, INITIAL_HP,  SYMBOL, HARM, null);
		cost = 50;
	}
	
	public Nuez(int x, int y , Game game) {
		super(x, y, INITIAL_HP, SYMBOL, HARM,  game);
	}

	public void update() {
		cycle++;
	}

}
