package commands;

import pr3.Controller;
import pr3.Game;

public class ExitCommand extends NoParamsCommand {
	
	private final static char SYMBOL = 'e';
	private final static String COMMANDHELP = "exit";
	private final static String COMMANDINFO = "[E]xit";
	private final static String HELPTEXT = "Exits game";
	
	public ExitCommand() {
		super(COMMANDHELP, COMMANDINFO, HELPTEXT, SYMBOL);
	}

	public void execute(Game game, Controller controller) {
		controller.setExitState();
	}


}
