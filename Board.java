
public class Board extends MainFrame{

	/*Symbols
	 * X: Player One
	 * O: Player Two
	 * -: Blank
	 */
	
	
    
	
	static String[][] board = new String[3][3]; //Creates a 2d arrray
	
	public Board () {} //Constructor for class Board
	
	public static void init() {
		resetBoard();
		printBoard();
		System.out.println("Game initialized.");
	}
	
	public static void resetBoard() {
		/*Generates an empty board*/
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				board[y][x] = "";
			}
		}
	}

	public static void printBoard() {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {

				System.out.println(board[y][x]);
				
			} System.out.println();//stars a new line
		}
	}
	
}

