package arkanoid.game;

import biuoop.DrawSurface;

/**
 * @author Tommy Zaft
 * <p>
 * An inteface for an animation.
 */
public interface Animation {
    /**
     * does the ctions needed on one frame.
     *
     * @param d the DrawSurface to draw on
     */
    void doOneFrame(DrawSurface d);

    /**
     * checks if should stop.
     *
     * @return if should stop - true. otherwise - false.
     */
    boolean shouldStop();
}
