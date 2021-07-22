package arkanoid.game.backgrounds;

import arkanoid.shapes.Block;
import arkanoid.shapes.Point;
import arkanoid.shapes.Rectangle;
import arkanoid.shapes.special.PixelArtAmogus;

import java.awt.Color;

/**
 * @author Tommy Zaft
 * <p>
 * The FinalOne level Background.
 */
public class FinalOneBackground extends Background {
    private static final Color[] AMONGUS_COLORS = {
            new Color(198, 9, 9), new Color(11, 43, 211),
            new Color(7, 129, 41), new Color(238, 82, 186),
            new Color(239, 126, 6), new Color(245, 245, 87),
            new Color(61, 70, 77), new Color(214, 225, 240),
            new Color(107, 44, 189), new Color(115, 71, 24),
            new Color(54, 254, 220), new Color(79, 240, 55)
    };
    private static final Color[] AMONGUS_SECOND_COLORS = {
            new Color(124, 2, 53), new Color(2, 13, 143),
            new Color(3, 76, 41), new Color(173, 40, 175),
            new Color(179, 60, 13), new Color(194, 136, 27),
            new Color(24, 25, 32), new Color(131, 150, 191),
            new Color(57, 16, 125), new Color(94, 33, 12),
            new Color(31, 171, 191), new Color(14, 170, 65)
    };

    private static final int NUM_OF_AMOGUS = 6;
    private static final Color BACKGROUND_COLOR = new Color(52, 189, 225);

    /**
     * constructor.
     */
    public FinalOneBackground() {
        int currentX = 75;
        int y = 450;
        int secondY = 180;
        int pushChosen = 3;
        this.addSprite(new Block(new Rectangle(new Point(0, 0), SCREEN_WIDTH, SCREEN_HEIGHT,
                BACKGROUND_COLOR)));
        for (int i = 0; i < NUM_OF_AMOGUS; i++) {
            int indexChosen = i % AMONGUS_COLORS.length;
            this.addSprite(new PixelArtAmogus(currentX, y, AMONGUS_COLORS[indexChosen],
                    AMONGUS_SECOND_COLORS[indexChosen]));

            this.addSprite(new PixelArtAmogus(currentX, secondY,
                    AMONGUS_COLORS[(indexChosen + pushChosen) % AMONGUS_COLORS.length],
                    AMONGUS_SECOND_COLORS[(indexChosen + pushChosen) % AMONGUS_COLORS.length]));
            currentX += (Background.SCREEN_WIDTH - 2 * Background.BORDER_SIZE) / NUM_OF_AMOGUS + 30;
        }
    }
}
