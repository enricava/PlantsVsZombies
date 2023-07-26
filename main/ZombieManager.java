package pr3;
import java.util.Random;

public class ZombieManager {
	
	private double frecuency;
	private static Random rand;
	private int zombiesLeftToAppear;
	
	
	public int leftToAppear(){
		return zombiesLeftToAppear;
	}
	
	public ZombieManager(Level lv, int seed) {
		ZombieManager.rand = new Random(seed);
		zombiesLeftToAppear = lv.numberOfZombies();
		frecuency = (lv.levelToDouble() + 1)/ 10;
	}
	
	public boolean isZombieAdded(){
		boolean ok = (zombiesLeftToAppear > 0 && Math.random() < frecuency);
		if(ok) this.zombiesLeftToAppear--;
		return ok;
	}
	
	public int newPos(int maxRows) {
		int pos = rand.nextInt(maxRows);
		return pos;
	}
	
	
	
	public int getRemainingZombies() {
		return zombiesLeftToAppear;
	}

	public int randomZombieType(int maxZombieTypes) {
		int number = rand.nextInt();
		if(number < 0) number *= -1;
		return number % maxZombieTypes;
	}
	
	
}
