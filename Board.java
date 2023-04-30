import java.awt.*;

/**
 * Represents the game board object
 * Initializes the array of {@link #cells}, draws the initial game UI and checks for draw/win conditions
 */
public class Board {
	//Board Constants
	/**Set the grid line width */
	public static final int GRID_WIDTH = 8;
<<<<<<< Updated upstream
	// grid line half width
	public static final int GRID_WIDHT_HALF = GRID_WIDTH / 2;
	
	//2D array of ROWS-by-COLS Cell instances
=======
	/**Set the grid line half width */
	public static final int GRID_WIDTH_HALF = GRID_WIDTH / 2;

	/** 2D array of ROWS-by-COLS Cell instances */
>>>>>>> Stashed changes
	Cell [][] cells;
	
	/** Constructor to create the game board */
	public Board() {
		
	 //TODO: initialise the cells array using ROWS and COLS constants 

		
		for (int row = 0; row < GameMain.ROWS; ++row) {
			for (int col = 0; col < GameMain.COLS; ++col) {
				cells[row][col] = new Cell(row, col);
			}
		}
	}
	

	 /** Return true if it is a draw (i.e., no more EMPTY cells) */ 
	public boolean isDraw() {
		 
<<<<<<< Updated upstream
		// TODO: Check whether the game has ended in a draw. 
		// Hint: Use a nested loop (see the constructor for an example). Check whether any of the cells content in the board grid are Player.Empty. If they are, it is not a draw.
		// Hint: Return false if it is not a draw, return true if there are no empty positions left
		   
		
=======
		// Check whether the game has ended in a draw. 
		// Check whether any of the cells content in the board grid are Player.Empty. If they are, it is not a draw.
		// Return false if it is not a draw, return true if there are no empty positions left
		boolean drawStatus = false;
		for (int row = 0; row < GameMain.ROWS; ++row) {
			for (int col = 0; col < GameMain.COLS; ++col) {
				//if an empty cell is found, game cannot be a draw yet.
				if(cells[row][col].content == Player.Empty){
					return false;
				}
				//if this cell is the last one on the board to check && its not empty then game is a draw
				if(row == GameMain.ROWS - 1 && col == GameMain.COLS - 1){
					drawStatus = true;
				}
			}
		}
		return drawStatus;   
>>>>>>> Stashed changes

		
	}
	
	/** Return true if the current player "thePlayer" has won after making their move  */
	public boolean hasWon(Player thePlayer, int playerRow, int playerCol) {
		 // check if player has 3-in-that-row
		if(cells[playerRow][0].content == thePlayer && cells[playerRow][1].content == thePlayer && cells[playerRow][2].content == thePlayer )
			return true; 
		
		 // TODO: Check if the player has 3 in the playerCol.
		 // Hint: Use the row code above as a starting point, remember that it goes cells[row][column] 
		
		
		
		 // 3-in-the-diagonal
		if( cells[0][0].content == thePlayer && cells[1][1].content == thePlayer && cells[2][2].content == thePlayer)
			return true;
		 
		
		// TODO: Check the diagonal in the other direction
		

		
		//no winner, keep playing
		return false;
	}
	
	/**
	 * Draws the grid (rows then columns) using constant sizes, then call on the
	 * Cells to paint themselves into the grid
	 */
	public void paint(Graphics g) {
		//draw the grid
		g.setColor(Color.gray);
		for (int row = 1; row < GameMain.ROWS; ++row) {          
			g.fillRoundRect(0, GameMain.CELL_SIZE * row - GRID_WIDHT_HALF,                
					GameMain.CANVAS_WIDTH - 1, GRID_WIDTH,                
					GRID_WIDTH, GRID_WIDTH);       
			}
		for (int col = 1; col < GameMain.COLS; ++col) {          
			g.fillRoundRect(GameMain.CELL_SIZE * col - GRID_WIDHT_HALF, 0,                
					GRID_WIDTH, GameMain.CANVAS_HEIGHT - 1,                
					GRID_WIDTH, GRID_WIDTH);
		}
		
		//Draw the cells
		for (int row = 0; row < GameMain.ROWS; ++row) {          
			for (int col = 0; col < GameMain.COLS; ++col) {  
				cells[row][col].paint(g);
			}
		}
	}
	

}
