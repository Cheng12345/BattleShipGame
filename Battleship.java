
public class Battleship {

	public static void main(String[] args) {
		System.out.println("Welcome!");

		Player p1 = new Player("Human", true);
		Player p2 = new Player("Machine", true);

		p1.setAllShipLocations();
		p1.printMyShips();

		p2.setAllShipLocations();
		p2.printMyShips();

//	        Guess g = new Guess(p1,p2);
//			for (int i = 0; i < 10; i++)
//				for (int j = 0; j < 10; j++)
//					  g.MakeAGuess(i, j);	
//	        
//	        p1.printMyGuesses(); 
//	        p2.printOpponentGuesses();  //should be the same as above

		// start to guess
		int count = 0;
		
		while ((p1.Win() == false || p2.Win() == false) ) {
			count++;
			
			
			System.out.println("Round " + count + "  ************************** " + p1.Name + " is guessing");
			Guess g1 = new Guess(p1, p2);
			int r1;
			int c1;
			
			//randomly find (r1,c1) , not guesses yet
			while (true) {
				r1 = Randomizer.nextInt(0, 9);
				c1 = Randomizer.nextInt(0, 9);
				if (p1.Grid_other.getStatus(r1, c1) == -1) {
					break;
				}
			}
			g1.MakeAGuess(r1, c1);
			p1.printMyGuesses(); 
			System.out.println("Total hits=" + p1.Grid_other.getTotalHit() +"/" + p1.Grid_own.getTotalShip());
			
			
			System.out.println(p2.Name + " is guessing");
			Guess g2 = new Guess(p2, p1);
			int r2;
			int c2;
			
			//randomly find (r1,c1) , not guesses yet
			while (true) {
				r2 = Randomizer.nextInt(0, 9);
				c2 = Randomizer.nextInt(0, 9);
				if (p2.Grid_other.getStatus(r2, c2) == -1) {
					break;
				}
			}
			g2.MakeAGuess(r2, c2);
			p2.printMyGuesses(); 
			System.out.println("Total hits=" + p2.Grid_other.getTotalHit() +"/" + p2.Grid_own.getTotalShip());
		}

	}

}
