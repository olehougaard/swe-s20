package dk.via.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game(10);
    }

    private void frame(int first, int second) {
        game.doThrow(first);
        game.doThrow(second);
    }

    private void spare() {
        frame(7, 3);
    }

    private void strike() {
        game.doThrow(10);
    }

    @Test
    public void gameStartsAt0Points() {
        assertEquals(0, game.getTotalPoints());
    }

    @Test
    public void incompleteFrameIsNotScored() {
        game.doThrow(7);
        assertEquals(0, game.getTotalPoints());
    }

    @Test
    public void openFrameIsScored() {
        frame(7, 2);
        assertEquals(9, game.getTotalPoints());
    }

    @Test
    public void gameIsInFirstFrameUntilFrameIsComplete() {
        game.doThrow(7);
        assertEquals(1, game.getFrameNumber());
    }

    @Test
    public void gameMovesToNextFrameAfterAnOpenFrame() {
        frame(7, 2);
        assertEquals(2, game.getFrameNumber());
    }

    @Test
    public void frameScoreIsRegistered() {
        frame(7, 2);
        assertEquals(9, game.getFramePoints(1));
    }

    @Test
    public void frameScoreIsNotRegisteredBeforeTheFrameIsComplete() {
        game.doThrow(7);
        assertEquals(0, game.getFramePoints(1));
    }

    @Test
    public void secondFrameIsNotScoredUntilItIsComplete() {
        frame(7, 2);
        game.doThrow(4);
        assertEquals(9, game.getTotalPoints());
    }

    @Test
    public void secondOpenFrameIsScoredIndependentlyOfFirst() {
        frame(7, 2);
        frame(4, 3);
        assertEquals(7, game.getFramePoints(2));
    }

    @Test
    public void frameIsRetainedAfterNextFrame() {
        frame(7, 2);
        frame(4, 3);
        assertEquals(9, game.getFramePoints(1));
    }

    @Test
    public void totalScoreIsTheSumOfFrameScores() {
        frame(7, 2);
        frame(4, 3);
        assertEquals(game.getFramePoints(1) + game.getFramePoints(2), game.getTotalPoints());
    }

    @Test
    public void spareIsNotScoredImmediately() {
        spare();
        assertEquals(0, game.getFramePoints(1));
    }

    @Test
    public void spareIsScoredAfterNextThrow() {
        spare();
        game.doThrow(4);
        assertEquals(14, game.getFramePoints(1));
    }

    @Test
    public void gameMovesToNextFrameAfterSpare() {
        spare();
        assertEquals(2, game.getFrameNumber());
    }

    @Test
    public void strikeIsNotScoredImmediately() {
        strike();
        assertEquals(0, game.getFramePoints(1));
    }

    @Test
    public void gameMovesToNextFrameAfterStrike() {
        strike();
        assertEquals(2, game.getFrameNumber());
    }

    @Test
    public void strikeIsNotScoredAfterNextThrow() {
        strike();
        game.doThrow(4);
        assertEquals(0, game.getFramePoints(1));
    }

    @Test
    public void strikeIsScoredAfterNextTwoThrows() {
        strike();
        frame(6, 2);
        assertEquals(18, game.getFramePoints(1));
    }

    @Test
    public void strikeAfterStrikeCountsAsOneThrow() {
        strike();
        strike();
        assertEquals(0, game.getFramePoints(1));
        game.doThrow(2);
        assertEquals(22, game.getFramePoints(1));
    }

    @Test
    public void spareLastFrameGivesExtraThrowInTheFrame() {
        Game game = new Game(1);
        game.doThrow(7);
        game.doThrow(3);
        assertEquals(1, game.getFrameNumber());
        game.doThrow(4);
        assertEquals(2, game.getFrameNumber());
        assertEquals(14, game.getFramePoints(1));
    }

    @Test
    public void strikeLastFrameGivesTwoExtraThrowsInTheFrame() {
        Game game = new Game(1);
        game.doThrow(10);
        assertEquals(1, game.getFrameNumber());
        game.doThrow(4);
        assertEquals(1, game.getFrameNumber());
        game.doThrow(6);
        assertEquals(2, game.getFrameNumber());
        assertEquals(20, game.getFramePoints(1));
    }

    @Test
    public void maximumScoreIs300() {
        for(int i = 0; i < 12; i++) strike();
        assertEquals(300, game.getTotalPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void itsIllegalToThrowPastFinalFrame() {
        for(int i = 0; i < 12; i++) strike();
        game.doThrow(2);
    }
}
