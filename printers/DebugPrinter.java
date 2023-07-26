package printers;

import pr3.Game;

public class DebugPrinter extends BoardPrinter{
	private static final int cellSize = 22;

	public DebugPrinter(Game game) {
		super(game, 1, game.getListsLength(), cellSize);
}


	public void encodeGame(Game game) {
		board = new String[1][game.getListsLength()];
		for (int i = 0; i < game.getListsLength(); i++) {
			board[0][i] = game.toInfoStringLists(i);
		}
	}

}
