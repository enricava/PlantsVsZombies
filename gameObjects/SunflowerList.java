package gameObjects;

public class SunflowerList {

	private Sunflower[] list;
	private int cap;
	
	public SunflowerList(int size){
		this.cap = 0;
		list = new Sunflower[size] ;
	}
	
	public void add(Sunflower a) {
		if (cap == list.length) {
			//CASO TAMAÑO MAXIMO
		}
		else {
			list[cap++] = a;
		}
	}
	
	//RETURNS IF THERE ARE SUNFLOWERS IN A GIVEN POSITION
	public boolean sun_Pos(int x, int y){
		if(getpos(x, y) != null) return true;
		return false;
	}
	
	//RETURNS TRUE IF A PEASHOOTER LOSES HEALTH POINTS
	public boolean doDamage(int x, int y, int harm){
		Sunflower sunflower = getpos(x , y);
		if (sunflower != null) {
			sunflower.doDamage(harm);
			return true;
		}
		else return false;
	}
	
	
	// Return Peashooter in that pos, if there is no zombie it returns null
	private Sunflower getpos(int x, int y){
		Sunflower sunflower  = null;
		for (int i = 0; i < cap; ++i){
			if(list[i].getHP() != 0 && list[i].getX ()== x && list[i].getY() == y)
				sunflower = list[i];
		}
		return sunflower;
	}
	
	public int getCap() {
		return cap;
	}
	
	public int getHP(int pos) {
		return list[pos].getHP();
	}
	
	public int getX(int pos) {
		return list[pos].getX();
	}
	
	public int getY(int pos) {
		return list[pos].getY();
	}

	
	//UPDATES LIST OF SUNFLOWERS
	public void update() {
		for (int i = 0; i < cap; i++) {
			if (getHP(i) > 0) list[i].update();
		}
	}

	public String toString(int i, int j) {
		Sunflower sunflower = getpos(i,j);
		if (sunflower != null) return "S[" + sunflower.getHP() + "]";
		return " ";
	}
	
}
