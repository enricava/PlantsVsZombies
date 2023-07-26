package commands;

import pr3.Game;
import pr3.Controller;

public class PrintModeCommand extends Command{
	private final static char SYMBOL = 'p';
	private final static String COMMANDHELP = "printmode";
	private final static String COMMANDINFO = "[P]rintMode";
	private final static String HELPTEXT = "change print mode [Release|Debug]";
	private String mode;
	
	public PrintModeCommand() {
		super(COMMANDHELP, COMMANDINFO, HELPTEXT, SYMBOL);
	}

	public PrintModeCommand parse(String[] commandWords, Controller controller) {
		PrintModeCommand command = null;
		commandWords[0].toLowerCase();
		boolean sameChar = commandWords[0].charAt(0) == SYMBOL && commandWords[0].length() == 1;
		if(sameChar || commandWords[0].equals(commandName)) {
			mode = commandWords[1];
			command = this;
		}
		return command;
	}
	
	public void execute(Game game, Controller controller) {
		if (mode.charAt(0) == 'd' || mode.equals("debug"))
			controller.setPrintMode("debug");
		else if (mode.charAt(0) == 'r' || mode.equals("release"))
			controller.setPrintMode("release");
		else System.out.println("Invalid mode");
	}

}
