package commands;

import pr3.Controller;

public class CommandParser { //inicia una lista con todos los comandos posibles
	private static Command[] availableCommands = {
			new AddCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new ListCommand(),
			new UpdateCommand(),
			new AddZombieCommand(),
			new PrintModeCommand()
	};
	
	public static Command parseCommand(String[ ] commandWords, Controller controller) {
		Command command = null;
		for (int i = 0; i < availableCommands.length && command == null; i++) {
			command = availableCommands[i].parse(commandWords, controller);
		}
		return command;
	}
	
	public static void commandHelp() {
		for (int i = 0; i < availableCommands.length; i++) {
			System.out.println(availableCommands[i].helpText());
		}
	}
	
}
