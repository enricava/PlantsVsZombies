package printers;

import pr3.Game;

public class ReleasePrinter extends BoardPrinter{	
	private static final int cellSize = 7;
	public ReleasePrinter(Game game, int dimX, int dimY) {
		super(game, dimX, dimY, cellSize);
	}

	public void encodeGame(Game game) {
		board = new String[dimX][dimY];
		for(int i = 0; i < dimX; i++) {
			for(int j = 0; j < dimY; j++) {
				board[i][j] =  game.toString(i, j);
			}
		}		
		
	}

}
