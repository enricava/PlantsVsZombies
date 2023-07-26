package commands;

import pr3.Controller;
import pr3.Game;
import gameObjects.Plant;
import factories.PlantFactory;

public class AddCommand extends Command{
	private final static char SYMBOL = 'a';
	private final static String COMMANDHELP = "add";
	private final static String COMMANDINFO = "[A]dd plant x y";
	private final static String HELPTEXT = "Adds a plant in a given position.";
	private String plantName;
	private int x;
	private int y;
	
	public AddCommand() {
		super(COMMANDHELP, COMMANDINFO, HELPTEXT, SYMBOL);
	}
	
	public AddCommand parse(String[] commandWords, Controller controller) {
		AddCommand command = null;
		commandWords[0].toLowerCase();
		boolean sameChar = commandWords[0].charAt(0) == SYMBOL && commandWords[0].length() == 1;
		if(sameChar || commandWords[0].equals(commandName)) {
			plantName = commandWords[1];
			x = Integer.parseInt(commandWords[2]);
			y = Integer.parseInt(commandWords[3]);
			command = this;
		}
		return command;
	}
	
	public void execute(Game game, Controller controller) {
		if(game.validPos(x,y)) {
			Plant plant = PlantFactory.getPlant(nameParseToSymbol(), game);
			if(plant != null) {
				if(!game.addPlant(plant, x, y)) System.out.println("Insufficient funds");
				else {
					controller.setPrintGameState(true);
					game.update();
				}
			}
			else System.out.println("Invalid plant name");
		}
		else System.out.println("Invalid position " + x + ','+ y);
	}
	
	private char nameParseToSymbol() {
		if(plantName.equals("peashooter") || plantName.equals("p")) return 'p';
		else if(plantName.equals("petacereza") || plantName.equals("c")) return 'c';
		else if(plantName.equals("nuez") || plantName.equals("n")) return 'n';
		else if(plantName.equals("sunflower") || plantName.equals("s")) return 's';
		else return 'x';
	}
	
}