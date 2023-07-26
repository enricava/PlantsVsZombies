package pr3;
import java.util.Scanner;

import commands.Command;
import commands.CommandParser;
import printers.DebugPrinter;
import printers.ReleasePrinter;

public class Controller {
	private Game game;
	private Scanner scanner;
	private boolean printGameState;
	private boolean exit;
	private final String prompt = "Enter command: ";
	private final String unknownCommandMsg = "Unknown command. Please try again.";
	private String printMode;
	
	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		exit = false;
		printGameState = true;
		printMode = "release";
	}
	
	public void run() {
		
		while (!game.isGameFinished() && !exit) {
			showStatus();
			
			printGame(printMode);
			
			System.out.print(prompt);
			String[] words = scanner.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandParser.parseCommand(words, this);
			
			if (command != null) {
				command.execute(game, this);
			} 
			else {
				System.err.println(unknownCommandMsg);
				setNoPrintGameState();
			}
			
		}
		printGame("release");
		System.out.println(game.getWinner() + "won in " + game.getCycleCount() + "turns!");
	}
	
	private void showStatus() {
		System.out.println("Random seed used: " + game.getSeed());
		System.out.println("Cycle number: " + game.getCycleCount());
		System.out.println("Sun coins: " + game.getSuncoins());
		System.out.println("Remaining zombies: " + game.getRemainingZombies());
	}
	
	private void printGame(String mode) {
		if(printGameState) {
			if(mode.equals("debug")) {
				DebugPrinter board = new DebugPrinter(game);
				System.out.println(board.toString());
			}
			else {
				ReleasePrinter board = new ReleasePrinter(game, game.getDimX(), game.getDimY());
				System.out.println(board.toString());
			}
		}
		printGameState = false;
	}
	
	public void setPrintGameState(boolean ok){
		if (!printGameState) printGameState = ok;
	}
	
	public void setNoPrintGameState() {
		printGameState = false;	
	}

	public void setExitState() {
		exit = true;
	}

	public void setPrintMode(String string) {
		printMode = string;
	}
	
}

