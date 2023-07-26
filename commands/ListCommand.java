package commands;

import pr3.Game;
import pr3.Controller;
import factories.PlantFactory;

public class ListCommand extends NoParamsCommand {

	private final static char SYMBOL = 'l';
	private final static String COMMANDHELP = "list";
	private final static String COMMANDINFO = "[L]ist";
	private final static String HELPTEXT = "Prints current lists";
	
	public ListCommand() {
		super(COMMANDHELP, COMMANDINFO, HELPTEXT, SYMBOL);
	}

	public void execute(Game game, Controller controller) {
		PlantFactory.listOfAvailablePlants();
	}

}
