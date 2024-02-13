
public class Guess {

	private Player p1;// p1 is guessing
	private Player p2;// p2 is being guessed

	public Guess(Player _p1, Player _p2) {
		this.p1 = _p1;
		this.p2 = _p2;
	}

	public void MakeAGuess(int r, int c) {
		System.out.println("("+(r+1)+","+(c+1)+")");
		
		if (p2.Grid_own.hasShip(r, c)) {
			p2.Grid_own.markHit(r, c); // p2 got hit
			p1.Grid_other.markHit(r, c); // remember it within its object

		} else {
			p2.Grid_own.markMiss(r, c); //
			p1.Grid_other.markMiss(r, c); // remember it within its object

		}

	}
}
