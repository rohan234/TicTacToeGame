
public class Marker {

	final int y = 0; //these variables are set to access index in a way so its readable to humans
	final int x = 1;
	
	static int[] pos;
	static int[] newPos;
	
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
		move(/*Axis:*/ y, /*Increase:*/ false);
	}
	
	public void moveDown() {
		move(/*Axis:*/ y, /*Increase:*/ true);
	}
	
	public void moveLeft() {
		move(/*Axis:*/ x, /*Increase:*/ false);
	}

	
	public void moveRight() {
		move(/*Axis:*/ x, /*Increase:*/ true);
	}
	
	private void move(int axis, boolean increase) {
		pos = getPosition("+", Board.hlBoard);
		newPos = pos;
		
		newPos[axis] += increase ? 1 : -1;
		
		if (validMove(Board.hlBoard, newPos)) {
			Board.hlBoard[pos[y]][pos[x]] = "-";
			Board.hlBoard[newPos[y]][newPos[x]] = "+";
		}
	}
	
	private boolean validMove(String[][] board, int[] newPosition) {
		boolean isValid;
		isValid = (board[newPosition[y]][newPosition[x]] == "-") ? true : false;

		return isValid;
		
	}
	
}
