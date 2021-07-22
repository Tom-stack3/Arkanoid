package arkanoid.game;

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

import arkanoid.shapes.Sprite;

/**
 * @author Tommy Zaft
 * <p>
 * Represents a Sprite Collection.
 * Has a list of sprites.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * creates a new Sprite Collection with an empty sprites list.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    /**
     * add sprite to the list.
     *
     * @param s the sprite to add
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        // Make a copy of the sprites before iterating over them.
        List<Sprite> spritesCopy = new ArrayList<>(this.sprites);
        // Notify all listeners about a hit event:
        for (Sprite s : spritesCopy) {
            s.timePassed();
        }
    }

    /**
     * remove sprite from collection.
     *
     * @param s sprite to remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d the DrawSurface to draw on
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
}
