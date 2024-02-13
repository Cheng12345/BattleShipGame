public class Location {
    //a few constant
    private static final int UNGUESSED=-1;
    private static final int MISS=0;
    private static final int HIT=1;
    
    private boolean hasShip;
    private int status; // 0 for unguessed, 1 for hit, 2 for miss

    public Location() {
        this.hasShip = false;
        this.status = -1; // 0 indicates an unguessed location
    }

    public boolean checkHit() {
        return status == 1;
    }

    public boolean checkMiss() {
        return status == 0;
    }

    public boolean isUnguessed() {
        return status == -1;
    }

    public void markHit() {
        this.status = 1;
    }

    public void markMiss() {
        this.status = 0;
    }

    public boolean hasShip() {
        return this.hasShip;
    }

    public void setShip(boolean val) {
        this.hasShip = val;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }
}