package printers;

import pr3.Game;
import pr3.MyStringUtils;

public abstract class BoardPrinter {
	protected int dimX; 
	protected int dimY;
	protected String[][] board;
	protected final String space = " ";
	protected int cellSize;
	
	public BoardPrinter(Game game, int dimX, int dimY, int cellSize) {
		this.dimX = dimX;
		this.dimY = dimY;
		this.cellSize = cellSize;
		encodeGame(game);
	}
	
	public abstract void encodeGame(Game game);
	
	public String toString() {
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
			
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (dimY * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
			
		StringBuilder str = new StringBuilder();
			
		str.append(lineDelimiter);
			
		for(int i=0; i<dimX; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<dimY; j++) {
					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
				}
				str.append(lineDelimiter);
		}
		return str.toString();
	}
}
