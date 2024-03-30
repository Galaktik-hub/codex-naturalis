package codexnaturalis;

public class Board {
	private int[][] board;
	
	public Board() {
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; i++) {
				board[i][j] = 0;
			}
		}
	}
}
