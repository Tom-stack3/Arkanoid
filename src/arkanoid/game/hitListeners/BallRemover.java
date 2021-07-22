package arkanoid.game.hitListeners;

import arkanoid.game.Counter;
import arkanoid.game.GameLevel;
import arkanoid.shapes.Ball;
import arkanoid.shapes.Block;

/**
 * @author Tommy Zaft
 * <p>
 * A BallRemover is in charge of removing balls from the gameLevel.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * constructor.
     *
     * @param gameLevel           the gameLevel.
     * @param remainingBalls a reference to the counter of the balls in the gameLevel.
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(gameLevel);
        this.remainingBalls.decrease(1);
    }
}
