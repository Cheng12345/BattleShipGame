public class Grid {
	private static final boolean verbose = false;

	private static final int NUM_ROWS = 10;
	private static final int NUM_COLS = 10;

	private final Location[][] grid;
	private final static String[] labels = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };

	public Grid() {
		grid = new Location[NUM_ROWS][NUM_COLS];
		for (int i = 0; i < NUM_ROWS; i++)
			for (int j = 0; j < NUM_COLS; j++)
				grid[i][j] = new Location();
	}

	public void markHit(int row, int col) {
		grid[row][col].markHit();
	}

	public void markMiss(int row, int col) {
		grid[row][col].markMiss();
	}

	public void setStatus(int row, int col, int status) {
		grid[row][col].setStatus(status);
	}

	public int getStatus(int row, int col) {
		return grid[row][col].getStatus();
	}

	public boolean alreadyGuessed(int row, int col) {
		return grid[row][col].isUnguessed();
	}

	public void setShip(int row, int col, boolean val) {
		grid[row][col].setShip(val);
	}

	public boolean hasShip(int row, int col) {
		return grid[row][col].hasShip();
	}

	public Location get(int row, int col) {
		return grid[row][col];
	}

	public int numRows() {
		return grid.length;
	}

	public int numCols() {
		return grid[0].length;
	}

	public void printStatus() {
		printGrid(false);
	}

	public void printShips() {
		printGrid(true);
	}

	private void printGrid(boolean showShips) {
		System.out.print("  ");
		for (int col = 1; col <= numCols(); col++) {
			System.out.print(col + " ");
		}
		System.out.println();

		for (int row = 0; row < numRows(); row++) {
			System.out.print(labels[row] + " ");
			for (int col = 0; col < numCols(); col++) {
				if (showShips) {
					System.out.print((grid[row][col].hasShip() ? "X" : "-") + " ");
				} else {
					if (grid[row][col].isUnguessed()) {
						System.out.print("- ");
					} else if (grid[row][col].checkHit()) {
						System.out.print("X ");
					} else {
						System.out.print("O ");
					}
				}
			}
			System.out.println();
		}
	}

	public void addShip(Ship s) {
		if (s.getDirection() == 0) {
			for (int c = s.getCol(); c < s.getCol() + s.getLength(); c++) {

				setShip(s.getRow(), c, true);
			}
		} else {
			for (int r = s.getRow(); r < s.getRow() + s.getLength(); r++) {

				setShip(r, s.getCol(), true);
			}
		}
	}

	public boolean validateShip(Ship s) {
		// check top boundary or left boundary
		if (s.getRow() < 0 || s.getCol() < 0) {

			if (verbose) {
				System.out.println("out of bounday top or left");
			}
			return false;
		}

		// check right boundary for horizontal
		if (s.getDirection() == 0) {
			if (s.getCol() + s.getLength() >= NUM_COLS)
			{
				if (verbose) {
					System.out.println("out of bounday  on the right");
				}
				return false;
			}
		} else { // bottom
			if (s.getRow() + s.getLength() >= NUM_ROWS)
			{
				if (verbose) {
					System.out.println("out of bounday at the bottom");
				}
				return false;
			}
		}
		
		
		//now valid to see if a location is taken already
		if (s.getDirection() == 0) {
			for (int c = s.getCol(); c < s.getCol() + s.getLength(); c++) {

				if (hasShip(s.getRow(), c))
				{
					if (verbose) {System.out.println("("+ s.getRow()+ ","+ c + ") already has a ship");}
					return false;
				}
			}
		} else {
			for (int r = s.getRow(); r < s.getRow() + s.getLength(); r++) {
				if (hasShip(r, s.getCol()))
				{
					if (verbose) {System.out.println("("+ r+ ","+  s.getCol() + ") already has a ship");}
					return false;
				}
			}
		}
		
		
		return true;

	}
	
	public int getTotalHit()
	{
		int tot=0;
		  
			for (int i = 0; i < NUM_ROWS; i++)
				for (int j = 0; j < NUM_COLS; j++)
				   if(grid[i][j].checkHit())
					   tot++;
		 
       return tot;
	}
	
	public int getTotalShip()
	{
		int tot=0;
		  
			for (int i = 0; i < NUM_ROWS; i++)
				for (int j = 0; j < NUM_COLS; j++)
				   if(grid[i][j].hasShip())
					   tot++;
		 
       return tot;
	}
}