 
public class Player {
	public String Name;
	private boolean isMachine;
	public Grid Grid_own; // for own ship locations and guesses from opponents
	public Grid Grid_other; // for recording own guess of locations of opponents's ships

	// a few constant
	private static final int[] SHIP_LENGTHS = { 2, 3, 3, 4, 5 };
	private final static String[] labels = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
	private static final boolean verbose = false;
	
	// Constructor
	public Player(String _name, boolean _isMachine) {
		Name = _name;
		isMachine = _isMachine;
		Grid_own = new Grid();
		Grid_other = new Grid();
	}

	// Print your ships on the grid
	public void printMyShips() {
        System.out.println(Name+"'s ships");
		Grid_own.printShips();
	}

	// Print opponent guesses
	public void printOpponentGuesses() {
		Grid_own.printStatus();
	}

	// Print your guesses
	public void printMyGuesses() {
		System.out.println(Name+"'s guesses");
		Grid_other.printStatus();
	}

	// Record a guess from the opponent
	public boolean recordOpponentGuess(int row, int col) {
		return false;
	}

	public void chooseShipLocation(Ship s, int row, int col, int direction) {

	}

	public void setAllShipLocations() {

//		readRow();
//		
//		readCol();
//
//		readDirection();
//		
//
//
//		Ship s1 = new Ship(2);
//		s1.setLocation(0, 0);
//		s1.setDirection(0);
//		if (this.Grid_own.validateShip(s1))
//			this.Grid_own.addShip(s1);
//
//		Ship s2 = new Ship(3);
//		s2.setLocation(4, 4);
//		s2.setDirection(1);
//		if (this.Grid_own.validateShip(s2))
//			this.Grid_own.addShip(s2);
//
//		Ship s3 = new Ship(5);
//		s3.setLocation(4, 4);
//		s3.setDirection(1);
//		if (this.Grid_own.validateShip(s3))
//			this.Grid_own.addShip(s3);

		// read in all ships
		for (int i = 0; i < SHIP_LENGTHS.length; i++) {
			int j = i + 1;
			if (verbose) System.out.println("Reading ship " + j + " with length=" + SHIP_LENGTHS[i]);

			Ship s = new Ship(SHIP_LENGTHS[i]);

			boolean shipValidate = false;
			while (shipValidate == false) {
				int r = readRow();
				int c = readCol();
				int d = readDirection();
				s.setLocation(r, c);
				s.setDirection(d);
				if (this.Grid_own.validateShip(s))
					break;
			}

			this.Grid_own.addShip(s);
			
			if (isMachine == false)
				this.printMyShips();
		}
	}

	private int readCol() {
		
		if (isMachine)
		{ 
			return Randomizer.nextInt(0, this.Grid_own.numCols()-1);
		}
		
		
		
		// Scanner scanner = new Scanner(System.in);
		int x = 0;
		System.out.print("Enter a number from 1 to " + this.Grid_own.numCols() + " for col:");
		while (true) {

			if (ScannerUtil.SCANNER.hasNextInt()) {
				x = ScannerUtil.SCANNER.nextInt();

				if (x >= 1 && x <= this.Grid_own.numCols()) {
					break; // Valid input, exit loop
				} else {
					System.out.println(
							"Invalid number, must be between 1 and " + this.Grid_own.numCols() + ". Please try again.");
				}
			} else {
				// System.out.println("That's not an integer. Please try again.");
				ScannerUtil.SCANNER.next(); // Consume the invalid token
			}

		}
		// scanner.close();
		return x - 1;
	}

	// read in row
	private int readRow() {
		
		if (isMachine)
		{ 
			return Randomizer.nextInt(0, this.Grid_own.numRows()-1);
		}
		
		
		// Scanner scanner = new Scanner(System.in);
		int index = -1;
		System.out.print("Enter a single letter from A to J for the row:");

		while (index < 0) {

			String input = ScannerUtil.SCANNER.nextLine().toUpperCase(); // Convert input to uppercase

			// Validate that the user has entered only a single letter
			if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
				// Search for the index of the input letter in the labels array
				for (int i = 0; i < labels.length; i++) {
					if (labels[i].equals(input)) {
						index = i;
						break;
					}
				}

				if (index >= 0) {
					break;
					// System.out.println("The index of the letter " + input + " in the labels array
					// is: " + index);
				} else {
					System.out.println(input + " is not a valid input. Please enter a single letter from A to J.");
				}
			} else {
				// System.out.println("Invalid input. Please enter only a single letter.");
			}

		}

		// scanner.close();
		return index;
	}

	// read in direction
	private int readDirection() {
		if (isMachine)
		{ 
			return Randomizer.nextInt(0,  1);
		}
		
		// Scanner scanner = new Scanner(System.in);
		int x = 0;
		System.out.print("Enter diretion (0 for Horizonal, 1 for Vertical):");

		while (true) {

			if (ScannerUtil.SCANNER.hasNextInt()) {
				x = ScannerUtil.SCANNER.nextInt();

				if (x == 0 || x == 1) {
					break; // Valid input, exit loop
				} else {
					System.out.println("Invalid number, must be 0 or 1,  Please try again.");
				}
			} else {
				System.out.println("That's not an integer. Please try again.");
				ScannerUtil.SCANNER.next(); // Consume the invalid token
			}

		}
		// scanner.close();
		return x;
	}
	
	public boolean Win()
	{
		if(this.Grid_other.getTotalHit()==this.Grid_own.getTotalShip())  //assume the # of ship is the same for both players
		{
			return true;
		}
		return false;
	}
}