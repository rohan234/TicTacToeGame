
public class Marker {

	final int y = 0; //these variables are set to access index in a way so its readable to humans
	final int x = 1;
	
	static int[] oldPos;
	static int[] newPos;
	
	String playerMarker = "X";
	
	static int[] getPosition(String marker, String[][] board) {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				if (board[y][x].startsWith(marker)) {
					int[] position = {y, x};
					return position;
				}
			}
		}
		
		System.out.println("ERROR: UNABLE TO FIND MARKER: " + marker);
		return null;
	}
		
	public void moveUp() {
		move(findNewPosition(/*Axis:*/ y, /*Increase:*/ false));
	}
	
	public void moveDown() {
		move(findNewPosition(/*Axis:*/ y, /*Increase:*/ true));
	}
	
	public void moveLeft() {
		move(findNewPosition(/*Axis:*/ x, /*Increase:*/ false));
	}

	
	public void moveRight() {
		move(findNewPosition(/*Axis:*/ x, /*Increase:*/ true));
	}
	
	
	private int[] findNewPosition(int axis, boolean increase) {
		oldPos = getPosition("+", Board.hlBoard);
		newPos = oldPos;
		
		if (increase) {
			newPos[axis] += 1;
		} else {
			newPos[axis] -= 1;
		}
		
		return newPos;
	}
	
	
	private void move(int[] newPosition) {
		
		if (validMove(Board.hlBoard, newPosition)) {
			Board.resetBoard(Board.hlBoard);
			Board.hlBoard[newPosition[y]][newPosition[x]] = "+";
		}
		
		MainFrame.updateVisuals();
	}
	
	
	public void placeMarker() {
		
		oldPos = getPosition("+", Board.hlBoard);
		
		if (validMove(Board.gameBoard, getPosition("+", Board.hlBoard))) {
			Board.gameBoard[oldPos[y]][oldPos[x]] = playerMarker;
			updatePlayerMarker();
		}
			
		
		MainFrame.updateVisuals();
		
	}
	
	
	private boolean validMove(String[][] board, int[] newPosition) {
		if (board[newPosition[y]][newPosition[x]] == "-") {
			return true;
		} else {
			return false;
		}
		
	}
	
	private void updatePlayerMarker() {
		
		if (MainFrame.isPlayerOneTurn) {
			playerMarker = "O";
			MainFrame.isPlayerOneTurn = false;
		}
		else {
			playerMarker = "X";
			MainFrame.isPlayerOneTurn = true;
		}
		
	}
	
}
