package dk.via.bowling;

public class Frame {
    private int points;
    private int noOfThrows;

    public Frame() {
        this.points = 0;
        this.noOfThrows = 0;
    }

    public int getPoints() {
        if (isScored())
            return points;
        else
            return 0;
    }

    public void doThrow(int pins) {
        points += pins;
        noOfThrows++;
    }

    public boolean isScored() {
        return noOfThrows == 2 && points < 10 || noOfThrows == 3;
    }

    public boolean isPlayed() {
        return noOfThrows == 2 || points == 10;
    }
}
