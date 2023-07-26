package commands;

import pr3.Controller;

public abstract class NoParamsCommand extends Command {
	public NoParamsCommand(String commandText, String commandInfo, String helpInfo, char symbol) {
		super(commandText, commandInfo, helpInfo, symbol);
	}
	
	public NoParamsCommand parse(String[] commandWords, Controller controller) {
		NoParamsCommand command = null;
		commandWords[0].toLowerCase();
		boolean sameChar = commandWords[0].charAt(0) == symbol && commandWords[0].length() == 1;
		if(sameChar || commandWords[0].equals(commandName)) {
			command = this;
		}
		return command;
}
}