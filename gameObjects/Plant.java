package gameObjects;

import pr3.Game;

public abstract class Plant extends GameObject{
	protected int cost;
	
	public Plant(int x, int y, int hp, char symbol, int harm, Game game) {
		super(x, y, hp, symbol, harm, game);
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public abstract void update();
	
	public boolean isZombie() {
		return false;
	}

	public int getCost() {
		return cost;
	}
}