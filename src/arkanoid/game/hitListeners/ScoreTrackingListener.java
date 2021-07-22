package arkanoid.game.hitListeners;

import arkanoid.game.Counter;
import arkanoid.shapes.Ball;
import arkanoid.shapes.Block;

/**
 * @author Tommy Zaft
 * <p>
 * A ScoreTrackingListener is in charge of tracking the score of the game.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    private static final int POINTS_FOR_HITTING_A_BLOCK = 5;

    /**
     * constructor.
     *
     * @param scoreCounter a reference to the score counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(POINTS_FOR_HITTING_A_BLOCK);
    }
}