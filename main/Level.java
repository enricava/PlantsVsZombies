package pr3;


public enum Level {
	EASY, MEDIUM, HARD;
	
	public double levelToDouble() {
		double value;
		switch (this) {
			case EASY: value = 0.0; break;
			case MEDIUM: value = 1.0; break;
			case HARD: value = 2.0; break;
			default : value = 0.0; break;
		}
		return value;
	}
	
	public int numberOfZombies() {
		int value;
		switch (this) {
		case EASY: value = 5; break;
		case MEDIUM: value = 10; break;
		case HARD: value = 15; break;
		default: value = 1;
		}
		return value;
	}
}

	