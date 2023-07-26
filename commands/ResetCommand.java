package commands;

import pr3.Game;
import pr3.Controller;

public class ResetCommand extends NoParamsCommand{
	private final static char SYMBOL = 'r';
	private final static String COMMANDHELP = "reset";
	private final static String COMMANDINFO = "[R]eset";
	private final static String HELPTEXT = "Resets the game.";
		
	public ResetCommand() {
		super(COMMANDHELP, COMMANDINFO, HELPTEXT, SYMBOL);
	}
		
	public void execute(Game game, Controller controller) {
		game.resetGame();
	}
		
}