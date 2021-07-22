package arkanoid.game.hitListeners;

import arkanoid.game.Counter;
import arkanoid.game.GameLevel;
import arkanoid.shapes.Ball;
import arkanoid.shapes.Block;

/**
 * @author Tommy Zaft
 * <p>
 * A BlockRemover is in charge of removing blocks from the gameLevel, as well as keeping count of the
 * number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param gameLevel          the gameLevel
     * @param removedBlocks a reference to the counter of the blocks in the gameLevel.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(gameLevel);
        beingHit.removeHitListener(this);
        this.remainingBlocks.decrease(1);
    }
}
