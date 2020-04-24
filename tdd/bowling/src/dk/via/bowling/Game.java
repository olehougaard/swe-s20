package dk.via.bowling;

public class Game {
    private Frame[] frames;
    private int frameNumber;

    public Game(int numberOfFrames) {
        this.frames = new Frame[numberOfFrames];
        for(int i = 0; i < numberOfFrames - 1; i++)
            this.frames[i] = new Frame();
        this.frames[numberOfFrames - 1] = new LastFrame();
        this.frameNumber = 1;
    }

    public int getTotalPoints() {
        int totalPoints = 0;
        for(Frame frame: frames) totalPoints += frame.getPoints();
        return totalPoints;
    }

    public void doThrow(int pins) {
        if (frameNumber > frames.length) throw new IllegalStateException("Game over, man!");
        for(int i = 0; i < frameNumber; i++)
            if(!frames[i].isScored())
                frames[i].doThrow(pins);
        if (frames[frameNumber - 1].isPlayed()) {
            frameNumber++;
        }
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public int getFramePoints(int i) {
        return frames[i - 1].getPoints();
    }
}
