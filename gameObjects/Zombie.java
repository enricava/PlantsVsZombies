package gameObjects;

import pr3.Game;

public abstract class Zombie extends GameObject{

	public Zombie(int x, int y, int hp, char symbol, int harm, Game game) {
		super(x, y, hp, symbol, harm, game);
	}
	
	public abstract void update();

	public void setGame(Game game) {
		this.game = game;
	}
	
	public boolean isZombie() {
		return true;
	}
	
}