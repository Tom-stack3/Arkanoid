package arkanoid.game.backgrounds;

import arkanoid.shapes.Sprite;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tommy Zaft
 * <p>
 * A level's Background.
 */
public abstract class Background implements Sprite {
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    public static final int BORDER_SIZE = 50;

    private List<Sprite> sprites;

    /**
     * constructor.
     */
    public Background() {
        sprites = new ArrayList<>();
    }

    /**
     * Add sprite to sprites list.
     *
     * @param s sprite to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * Add sprites to sprites list.
     *
     * @param spritesList sprites list to add.
     */
    public void addSprites(List<Sprite> spritesList) {
        this.sprites.addAll(spritesList);
    }

    @Override
    public void drawOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }

    @Override
    public void timePassed() {
        for (Sprite s : sprites) {
            s.timePassed();
        }
    }
}
