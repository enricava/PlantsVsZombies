package commands;

import pr3.Game;
import pr3.Controller;

public class HelpCommand extends NoParamsCommand{

	private final static char SYMBOL = 'h';
	private final static String COMMANDHELP = "help";
	private final static String COMMANDINFO = "[H]elp";
	private final static String HELPTEXT = "Prints help message";
	
	public HelpCommand() {
		super(COMMANDHELP, COMMANDINFO, HELPTEXT, SYMBOL);
	}
	public void execute(Game game, Controller controller) {
		CommandParser.commandHelp();
	}
}
