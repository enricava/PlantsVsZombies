package commands;

import pr3.Game;
import pr3.Controller;

public class UpdateCommand extends NoParamsCommand{
		
	private final static String COMMANDTEXT = "update";
	private final static String COMMANDINFO = "[U]pdate";
	private final static char SYMBOL = 'u';
	private final static String HELPTEXT = "Updates the game if necessary.";
		
	public UpdateCommand() {
		super(COMMANDTEXT, COMMANDINFO, HELPTEXT, SYMBOL);
	}
	
	public void execute(Game game, Controller controller) {
		game.update();
		controller.setPrintGameState(true);
	}
		
}