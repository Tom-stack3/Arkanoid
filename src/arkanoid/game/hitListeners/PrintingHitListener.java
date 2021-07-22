package arkanoid.game.hitListeners;

import arkanoid.shapes.Ball;
import arkanoid.shapes.Block;

/**
 * @author Tommy Zaft
 * <p>
 * A simple hit listener which prints when a block was hit.
 */
public class PrintingHitListener implements HitListener {
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println(beingHit + " was hit!");
    }
}
