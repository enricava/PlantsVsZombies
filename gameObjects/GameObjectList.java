package gameObjects;

public class GameObjectList {
	private GameObject[] list;
	private int cap;
	
	public GameObjectList(int size){
		cap = 0;
		list = new GameObject[size];
	}
	
	public void update() {
		for (int i = 0; i < cap; i++){
			if(list[i].getHP()>0){
				list[i].update();
			}
		}
	}
	
	public void add(GameObject object) {
		if (cap == list.length) doubleSize();
			list[cap] = object;
			cap++;
	}

	public boolean emptyPos(int x, int y) {
		if(getObjectInPos(x,y) != null) return false;
		return true;
	}
	
	private GameObject getObjectInPos(int x, int y){
		GameObject object  = null;
		for (int i = 0; i < cap; ++i){
			if(list[i].getHP() != 0 && list[i].getX() == x && list[i].getY() == y)
				object = list[i];
		}
		return object;
	}
	
	public boolean doDamage(int x, int y, int harm) {
		boolean ok = false;
		GameObject object = getObjectInPos(x, y);
		if (object != null) {
			object.doDamage(harm);
			ok = true;
		}
		return ok;
	}
	
	public String toString(int x, int y) {
		GameObject object = getObjectInPos(x, y);
		if(object != null) return object.toString();
		else return " ";
	}
	
	public boolean noZombies() {
		boolean ok = true;
		int i = 0;
		while(i < cap && ok) {
			if (list[i].isZombie() && list[i].getHP() > 0) ok = false;
			i++;
		}
		return ok;
	}
	
	public boolean zombiesWin(){
		boolean ok = false;
		int i = 0; 
		while (i < cap && !ok){
			if(list[i].isZombie() && list[i].getHP() > 0 && list[i].getY() == 0)
				ok  = true;
			i++;
		}		
		return ok;
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
	
	public String toInfoString(int i) {
		return list[i].toInfoString();
	}
	
	private void doubleSize() {
		GameObject list2[] = new GameObject[list.length * 2];
		for (int i = 0; i < cap; i++) list2[i] = list[i];
		list = list2;
	}
}
