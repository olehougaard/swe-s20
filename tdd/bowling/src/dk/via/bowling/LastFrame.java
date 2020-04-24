package dk.via.bowling;

public class LastFrame extends Frame {
    @Override
    public boolean isPlayed() {
        return isScored();
    }
}
