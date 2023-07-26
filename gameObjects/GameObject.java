package gameObjects;

import pr3.Game;

public abstract class GameObject {
	protected int x, y;
	protected int hp;
	protected int cycle;
	protected char symbol;
	protected int harm;
	protected Game game;
	
	public GameObject(int x, int y, int hp, char symbol, int harm ,Game game) {
		this.x = x;
		this.y = y;
		this.symbol = symbol;
		this.harm = harm;
		this.game = game;
		this.hp = hp;
		
		cycle = 0;
	}
	
	public abstract void update(); 
	public abstract boolean isZombie();
	
	public String toString() {
		return symbol + "[" + hp + "]";
	}
	
	public void doDamage(int harm) {
		hp = hp - harm;
	}
	
	public int getHP() {
		return hp;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getSymbol() {
		return symbol;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toInfoString() {
		return  "[" + symbol + "]" + "hp=" + hp + ",x=" + x + ",y=" + y + ",c=" + cycle;
	}
}
