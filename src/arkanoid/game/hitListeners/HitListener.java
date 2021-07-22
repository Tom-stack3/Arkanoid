package arkanoid.game.hitListeners;

import arkanoid.shapes.Ball;
import arkanoid.shapes.Block;

/**
 * @author Tommy Zaft
 * <p>
 * An interface for a hit listener.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit by a ball.
     *
     * @param beingHit the object hit.
     * @param hitter   the Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}