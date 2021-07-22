package arkanoid.game;

import arkanoid.game.hitListeners.HitListener;

/**
 * @author Tommy Zaft
 * <p>
 * An interface for a hit notifier.
 */
public interface HitNotifier {
    /**
     * add a listener to hit events.
     *
     * @param hl the listener to add.
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl the listener to remove.
     */
    void removeHitListener(HitListener hl);
}
