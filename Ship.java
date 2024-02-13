public class Ship {
    //a few constant
    private static final int UNSET=-1;
    private static final int HORIZONTAL=0;
    private static final int Vertical=1;
    
    
    private int length;
    private int row;
    private int col;
    private int direction=UNSET;
    private boolean isLocationSet = false;
    private boolean isDirectionSet = false;
    

    
    // Constructor 
    public Ship(int length) {
        this.length = length;
    }
    
    public boolean isLocationSet() {
        return this.isLocationSet;
    }

    public boolean isDirectionSet() {
        return this.isDirectionSet;
    }

    public void setLocation(int row, int col) {
        this.row = row;
        this.col = col;
        this.isLocationSet = true;
    }
   
    public void setDirection(int direction) {
        this.direction = direction;
        this.isDirectionSet = true;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public int getLength() {
        return this.length;
    }

    public int getDirection() {
        return this.direction;
    }

    private String directionToString() {
        return Integer.toString(this.direction);
    }

    private String locationToString() {
        return "(" + this.row + ", " + this.col + ")";
    }
    
    public String toString() {
        return "Ship{length=" + this.length + 
               ", location=" + this.locationToString() +
               ", direction=" + this.directionToString() + "}";
    }
}