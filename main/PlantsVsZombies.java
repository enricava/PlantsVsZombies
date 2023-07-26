package pr3;

import java.util.Scanner;


/**********************************************************************************
 * 
 * 
 * 				PR�CTICA REALIZADA POR MARIO JIM�NEZ Y ENRIQUE CAVANILLAS
 * 
 * 
 **********************************************************************************/

public class PlantsVsZombies {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Level lv = Level.EASY; 
		
		if (args[0] == "EASY") lv = Level.EASY;
		else if (args[0] == "MEDIUM") lv = Level.MEDIUM;
		else if (args[0] == "HARD") lv = Level.HARD;

		int seed = Integer.parseInt(args[1]);
		Game game = new Game(lv, seed);
		
		Controller controller = new Controller(game, sc);
		controller.run();
		
	}

}
