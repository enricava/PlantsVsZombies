package commands;

import pr3.Controller;
import pr3.Game;
import gameObjects.Zombie;
import factories.ZombieFactory;

public class AddZombieCommand extends Command {

	private static final char SYMBOL = 'z';
	private final static String COMMANDHELP = "addzombie";
	private final static String COMMANDINFO = "add[Z]ombie zombie x y";
	private final static String HELPTEXT = "Adds a zombie in a given position.";
	private String zombieName;
	private int x;
	private int y;

	
	public AddZombieCommand() {
		super(COMMANDHELP, COMMANDINFO, HELPTEXT, SYMBOL);
	}

	public AddZombieCommand parse(String[] commandWords, Controller controller) {
		AddZombieCommand command = null;
		commandWords[0].toLowerCase();
		boolean sameChar = commandWords[0].charAt(0) == SYMBOL && commandWords[0].length() == 1;
		if(sameChar || commandWords[0].equals(commandName)) {
			zombieName = commandWords[1];
			x = Integer.parseInt(commandWords[2]);
			y = Integer.parseInt(commandWords[3]);
			command = this;
		}
		return command;
	}
	
	public void execute(Game game, Controller controller) {
		if(game.validPos(x,y)) {
			Zombie zombie = ZombieFactory.getZombie(zombieName, game);
			if(zombie != null) {
				game.addZombieManually(zombie, x, y);
				controller.setPrintGameState(true);
				game.update();
			}
			else System.out.println("Invalid zombie name");
		}
		else System.out.println("Invalid position " + x + ','+ y);
	}

}
