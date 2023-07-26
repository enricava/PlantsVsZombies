package commands;

import pr3.Controller;
import pr3.Game;

public abstract class Command {
	private String helpText;
	private String commandText;
	protected final String commandName;
	protected final char symbol;
	
	public Command(String commandText, String commandInfo, String helpInfo, char symbol) {
		this.commandText = commandInfo;
		helpText = helpInfo;
		String[] commandInfoWords = commandText.split("\\s+");
		commandName = commandInfoWords[0];
		this.symbol = symbol;
	}
	
	
	public abstract void execute(Game game, Controller controller);
	public abstract Command parse(String[] commandWords, Controller controller) ;
	
	public String helpText() {
		return " " + commandText + ": " + helpText;
	}

}
