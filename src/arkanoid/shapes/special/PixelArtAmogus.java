package arkanoid.shapes.special;

import arkanoid.game.backgrounds.Background;
import arkanoid.shapes.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author Tommy Zaft
 * <p>
 * Drawing of a Among-us character
 * (some may say amogus).
 */
public class PixelArtAmogus implements Sprite {
    private static final Color GREEN = new Color(42, 214, 24);
    private static final Color SECOND_GREEN = new Color(10, 123, 12);

    private int x;
    private final int y;
    private final int width;
    private final int height;
    private final Color bodyColor;
    private final Color secondBodyColor;
    private final double speed;
    private int framesPassedSinceLastDrawing;


    /**
     * constructor.
     *
     * @param x               x
     * @param y               y
     * @param bodyColor       the bodyColor
     * @param secondBodyColor the secondBodyColor
     */
    public PixelArtAmogus(int x, int y, Color bodyColor, Color secondBodyColor) {
        this.x = x;
        this.y = y;
        this.width = 80;
        this.height = 60;
        this.bodyColor = bodyColor;
        this.secondBodyColor = secondBodyColor;
        this.speed = 0.2;
        this.framesPassedSinceLastDrawing = (int) (1 / speed);
    }

    /**
     * default constructor.
     *
     * @param x x
     * @param y y
     */
    public PixelArtAmogus(int x, int y) {
        this(x, y, GREEN, SECOND_GREEN);
    }


    /**
     * move.
     *
     * @param speedToMove speed
     */
    public void move(int speedToMove) {
        if (x > Background.SCREEN_WIDTH) {
            this.x = -60;
        } else {
            this.x += speedToMove;
        }
    }

    @Override
    public void timePassed() {
        if (framesPassedSinceLastDrawing == (int) (1 / speed)) {
            move(1);
            framesPassedSinceLastDrawing = 0;
        } else {
            framesPassedSinceLastDrawing++;
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        drawBlack(d);
        drawBlack2(d);
        drawBlack3(d);
        drawBodyColor(d);
        drawBodyColor2(d);
        drawSecondBodyColor(d);
        drawSecondBodyColor2(d);
        draw171(d);
        draw157198215(d);
        draw223(d);
        drawWhite(d);
        draw150189206(d);
        draw221235241(d);
        draw7899107(d);
        draw235243247(d);
        draw3404(d);
    }

    /**
     * drawBlack 2.
     *
     * @param d DrawSurface
     */
    private void drawBlack2(DrawSurface d) {
        d.setColor(new Color(0, 0, 0));
        d.fillRectangle(x + 36, y, 3, 3);
        d.fillRectangle(x + 39, y, 3, 3);
        d.fillRectangle(x + 42, y, 3, 3);
        d.fillRectangle(x + 45, y, 3, 3);
        d.fillRectangle(x + 48, y, 3, 3);
        d.fillRectangle(x + 51, y, 3, 3);
        d.fillRectangle(x + 54, y, 3, 3);
        d.fillRectangle(x + 57, y, 3, 3);
        d.fillRectangle(x + 30, y + 3, 3, 3);
        d.fillRectangle(x + 33, y + 3, 3, 3);
        d.fillRectangle(x + 36, y + 3, 3, 3);
        d.fillRectangle(x + 39, y + 3, 3, 3);
        d.fillRectangle(x + 42, y + 3, 3, 3);
        d.fillRectangle(x + 45, y + 3, 3, 3);
        d.fillRectangle(x + 48, y + 3, 3, 3);
        d.fillRectangle(x + 51, y + 3, 3, 3);
        d.fillRectangle(x + 54, y + 3, 3, 3);
        d.fillRectangle(x + 57, y + 3, 3, 3);
        d.fillRectangle(x + 60, y + 3, 3, 3);
        d.fillRectangle(x + 63, y + 3, 3, 3);
        d.fillRectangle(x + 27, y + 6, 3, 3);
        d.fillRectangle(x + 30, y + 6, 3, 3);
        d.fillRectangle(x + 33, y + 6, 3, 3);
        d.fillRectangle(x + 36, y + 6, 3, 3);
        d.fillRectangle(x + 57, y + 6, 3, 3);
        d.fillRectangle(x + 60, y + 6, 3, 3);
        d.fillRectangle(x + 63, y + 6, 3, 3);
        d.fillRectangle(x + 66, y + 6, 3, 3);
        d.fillRectangle(x + 69, y + 6, 3, 3);
        d.fillRectangle(x + 27, y + 9, 3, 3);
        d.fillRectangle(x + 30, y + 9, 3, 3);
        d.fillRectangle(x + 63, y + 9, 3, 3);
        d.fillRectangle(x + 66, y + 9, 3, 3);
        d.fillRectangle(x + 69, y + 9, 3, 3);
        d.fillRectangle(x + 24, y + 12, 3, 3);
        d.fillRectangle(x + 27, y + 12, 3, 3);
        d.fillRectangle(x + 69, y + 12, 3, 3);
        d.fillRectangle(x + 72, y + 12, 3, 3);
        d.fillRectangle(x + 24, y + 15, 3, 3);
        d.fillRectangle(x + 27, y + 15, 3, 3);
        d.fillRectangle(x + 42, y + 18, 3, 3);
        d.fillRectangle(x + 45, y + 18, 3, 3);
        d.fillRectangle(x + 48, y + 18, 3, 3);
        d.fillRectangle(x + 51, y + 18, 3, 3);
        d.fillRectangle(x + 54, y + 18, 3, 3);
        d.fillRectangle(x + 57, y + 18, 3, 3);
        d.fillRectangle(x + 60, y + 18, 3, 3);
        d.fillRectangle(x + 63, y + 18, 3, 3);
        d.fillRectangle(x + 66, y + 18, 3, 3);
        d.fillRectangle(x + 69, y + 18, 3, 3);
        d.fillRectangle(x + 72, y + 18, 3, 3);
        d.fillRectangle(x + 75, y + 18, 3, 3);
        d.fillRectangle(x + 78, y + 18, 3, 3);
        d.fillRectangle(x + 21, y + 21, 3, 3);
        d.fillRectangle(x + 24, y + 21, 3, 3);
        d.fillRectangle(x + 39, y + 21, 3, 3);
        d.fillRectangle(x + 42, y + 21, 3, 3);
        d.fillRectangle(x + 45, y + 21, 3, 3);
        d.fillRectangle(x + 48, y + 21, 3, 3);
        d.fillRectangle(x + 51, y + 21, 3, 3);
        d.fillRectangle(x + 54, y + 21, 3, 3);
        d.fillRectangle(x + 39, y + 24, 3, 3);
        d.fillRectangle(x + 42, y + 24, 3, 3);
        d.fillRectangle(x + 78, y + 24, 3, 3);
        d.fillRectangle(x + 81, y + 24, 3, 3);
        d.fillRectangle(x + 84, y + 24, 3, 3);
        d.fillRectangle(x + 18, y + 27, 3, 3);
        d.fillRectangle(x + 21, y + 27, 3, 3);
        d.fillRectangle(x + 24, y + 27, 3, 3);
        d.fillRectangle(x + 36, y + 27, 3, 3);
        d.fillRectangle(x + 39, y + 27, 3, 3);
        d.fillRectangle(x + 42, y + 27, 3, 3);
        d.fillRectangle(x + 81, y + 27, 3, 3);
        d.fillRectangle(x + 84, y + 27, 3, 3);
        d.fillRectangle(x + 87, y + 27, 3, 3);
        d.fillRectangle(x + 9, y + 30, 3, 3);
        d.fillRectangle(x + 12, y + 30, 3, 3);
        d.fillRectangle(x + 15, y + 30, 3, 3);
        d.fillRectangle(x + 18, y + 30, 3, 3);
        d.fillRectangle(x + 21, y + 30, 3, 3);
        d.fillRectangle(x + 36, y + 30, 3, 3);
        d.fillRectangle(x + 39, y + 30, 3, 3);
        d.fillRectangle(x + 84, y + 30, 3, 3);
        d.fillRectangle(x + 87, y + 30, 3, 3);
        d.fillRectangle(x + 6, y + 33, 3, 3);
        d.fillRectangle(x + 9, y + 33, 3, 3);
        d.fillRectangle(x + 12, y + 33, 3, 3);
        d.fillRectangle(x + 15, y + 33, 3, 3);
        d.fillRectangle(x + 18, y + 33, 3, 3);
        d.fillRectangle(x + 21, y + 33, 3, 3);
        d.fillRectangle(x + 36, y + 33, 3, 3);
        d.fillRectangle(x + 39, y + 33, 3, 3);
        d.fillRectangle(x + 42, y + 33, 3, 3);
        d.fillRectangle(x + 84, y + 33, 3, 3);
        d.fillRectangle(x + 87, y + 33, 3, 3);
        d.fillRectangle(x + 3, y + 36, 3, 3);
        d.fillRectangle(x + 6, y + 36, 3, 3);
        d.fillRectangle(x + 9, y + 36, 3, 3);
        d.fillRectangle(x + 18, y + 36, 3, 3);
        d.fillRectangle(x + 21, y + 36, 3, 3);
        d.fillRectangle(x + 39, y + 36, 3, 3);
        d.fillRectangle(x + 42, y + 36, 3, 3);
        d.fillRectangle(x + 84, y + 36, 3, 3);
        d.fillRectangle(x + 87, y + 36, 3, 3);
        d.fillRectangle(x + 3, y + 39, 3, 3);
        d.fillRectangle(x + 6, y + 39, 3, 3);
        d.fillRectangle(x + 18, y + 39, 3, 3);
        d.fillRectangle(x + 21, y + 39, 3, 3);
        d.fillRectangle(x + 39, y + 39, 3, 3);
        d.fillRectangle(x + 42, y + 39, 3, 3);
        d.fillRectangle(x + 81, y + 39, 3, 3);
        d.fillRectangle(x + 84, y + 39, 3, 3);
        d.fillRectangle(x + 87, y + 39, 3, 3);
    }

    /**
     * drawBlack.
     *
     * @param d DrawSurface
     */
    private void drawBlack3(DrawSurface d) {
        d.setColor(new Color(0, 0, 0));
        d.fillRectangle(x, y + 42, 3, 3);
        d.fillRectangle(x + 3, y + 42, 3, 3);
        d.fillRectangle(x + 6, y + 42, 3, 3);
        d.fillRectangle(x + 18, y + 42, 3, 3);
        d.fillRectangle(x + 21, y + 42, 3, 3);
        d.fillRectangle(x + 39, y + 42, 3, 3);
        d.fillRectangle(x + 42, y + 42, 3, 3);
        d.fillRectangle(x + 45, y + 42, 3, 3);
        d.fillRectangle(x + 78, y + 42, 3, 3);
        d.fillRectangle(x + 81, y + 42, 3, 3);
        d.fillRectangle(x + 84, y + 42, 3, 3);
        d.fillRectangle(x, y + 45, 3, 3);
        d.fillRectangle(x + 3, y + 45, 3, 3);
        d.fillRectangle(x + 18, y + 45, 3, 3);
        d.fillRectangle(x + 21, y + 45, 3, 3);
        d.fillRectangle(x + 42, y + 45, 3, 3);
        d.fillRectangle(x + 45, y + 45, 3, 3);
        d.fillRectangle(x + 48, y + 45, 3, 3);
        d.fillRectangle(x + 69, y + 45, 3, 3);
        d.fillRectangle(x + 72, y + 45, 3, 3);
        d.fillRectangle(x + 75, y + 45, 3, 3);
        d.fillRectangle(x + 78, y + 45, 3, 3);
        d.fillRectangle(x + 81, y + 45, 3, 3);
        d.fillRectangle(x, y + 48, 3, 3);
        d.fillRectangle(x + 3, y + 48, 3, 3);
        d.fillRectangle(x + 18, y + 48, 3, 3);
        d.fillRectangle(x + 21, y + 48, 3, 3);
        d.fillRectangle(x + 45, y + 48, 3, 3);
        d.fillRectangle(x + 48, y + 48, 3, 3);
        d.fillRectangle(x + 51, y + 48, 3, 3);
        d.fillRectangle(x + 54, y + 48, 3, 3);
        d.fillRectangle(x + 57, y + 48, 3, 3);
        d.fillRectangle(x + 60, y + 48, 3, 3);
        d.fillRectangle(x + 63, y + 48, 3, 3);
        d.fillRectangle(x + 66, y + 48, 3, 3);
        d.fillRectangle(x + 69, y + 48, 3, 3);
        d.fillRectangle(x + 72, y + 48, 3, 3);
        d.fillRectangle(x + 75, y + 48, 3, 3);
        d.fillRectangle(x + 78, y + 48, 3, 3);
        d.fillRectangle(x + 81, y + 48, 3, 3);
        d.fillRectangle(x, y + 51, 3, 3);
        d.fillRectangle(x + 3, y + 51, 3, 3);
        d.fillRectangle(x + 18, y + 51, 3, 3);
        d.fillRectangle(x + 21, y + 51, 3, 3);
        d.fillRectangle(x + 51, y + 51, 3, 3);
        d.fillRectangle(x + 54, y + 51, 3, 3);
        d.fillRectangle(x + 57, y + 51, 3, 3);
        d.fillRectangle(x + 60, y + 51, 3, 3);
        d.fillRectangle(x + 63, y + 51, 3, 3);
        d.fillRectangle(x + 66, y + 51, 3, 3);
        d.fillRectangle(x + 69, y + 51, 3, 3);
        d.fillRectangle(x + 78, y + 51, 3, 3);
        d.fillRectangle(x + 81, y + 51, 3, 3);
        d.fillRectangle(x, y + 54, 3, 3);
        d.fillRectangle(x + 3, y + 54, 3, 3);
        d.fillRectangle(x + 18, y + 54, 3, 3);
        d.fillRectangle(x + 21, y + 54, 3, 3);
        d.fillRectangle(x + 78, y + 54, 3, 3);
        d.fillRectangle(x + 81, y + 54, 3, 3);
        d.fillRectangle(x, y + 57, 3, 3);
        d.fillRectangle(x + 3, y + 57, 3, 3);
        d.fillRectangle(x + 18, y + 57, 3, 3);
        d.fillRectangle(x + 21, y + 57, 3, 3);
        d.fillRectangle(x + 78, y + 57, 3, 3);
        d.fillRectangle(x + 81, y + 57, 3, 3);
        d.fillRectangle(x, y + 60, 3, 3);
        d.fillRectangle(x + 3, y + 60, 3, 3);
        d.fillRectangle(x + 18, y + 60, 3, 3);
        d.fillRectangle(x + 21, y + 60, 3, 3);
        d.fillRectangle(x + 78, y + 60, 3, 3);
        d.fillRectangle(x + 81, y + 60, 3, 3);
        d.fillRectangle(x, y + 63, 3, 3);
        d.fillRectangle(x + 3, y + 63, 3, 3);
        d.fillRectangle(x + 18, y + 63, 3, 3);
        d.fillRectangle(x + 21, y + 63, 3, 3);
    }

    /**
     * drawBlack.
     *
     * @param d DrawSurface
     */
    private void drawBlack(DrawSurface d) {
        d.setColor(new Color(0, 0, 0));
        d.fillRectangle(x + 78, y + 63, 3, 3);
        d.fillRectangle(x + 81, y + 63, 3, 3);
        d.fillRectangle(x, y + 66, 3, 3);
        d.fillRectangle(x + 3, y + 66, 3, 3);
        d.fillRectangle(x + 18, y + 66, 3, 3);
        d.fillRectangle(x + 21, y + 66, 3, 3);
        d.fillRectangle(x + 78, y + 66, 3, 3);
        d.fillRectangle(x + 81, y + 66, 3, 3);
        d.fillRectangle(x, y + 69, 3, 3);
        d.fillRectangle(x + 3, y + 69, 3, 3);
        d.fillRectangle(x + 18, y + 69, 3, 3);
        d.fillRectangle(x + 21, y + 69, 3, 3);
        d.fillRectangle(x + 78, y + 69, 3, 3);
        d.fillRectangle(x + 81, y + 69, 3, 3);
        d.fillRectangle(x, y + 72, 3, 3);
        d.fillRectangle(x + 3, y + 72, 3, 3);
        d.fillRectangle(x + 18, y + 72, 3, 3);
        d.fillRectangle(x + 21, y + 72, 3, 3);
        d.fillRectangle(x + 78, y + 72, 3, 3);
        d.fillRectangle(x + 81, y + 72, 3, 3);
        d.fillRectangle(x, y + 75, 3, 3);
        d.fillRectangle(x + 3, y + 75, 3, 3);
        d.fillRectangle(x + 6, y + 75, 3, 3);
        d.fillRectangle(x + 18, y + 75, 3, 3);
        d.fillRectangle(x + 21, y + 75, 3, 3);
        d.fillRectangle(x + 78, y + 75, 3, 3);
        d.fillRectangle(x + 81, y + 75, 3, 3);
        d.fillRectangle(x + 3, y + 78, 3, 3);
        d.fillRectangle(x + 6, y + 78, 3, 3);
        d.fillRectangle(x + 18, y + 78, 3, 3);
        d.fillRectangle(x + 21, y + 78, 3, 3);
        d.fillRectangle(x + 78, y + 78, 3, 3);
        d.fillRectangle(x + 81, y + 78, 3, 3);
        d.fillRectangle(x + 3, y + 81, 3, 3);
        d.fillRectangle(x + 6, y + 81, 3, 3);
        d.fillRectangle(x + 18, y + 81, 3, 3);
        d.fillRectangle(x + 21, y + 81, 3, 3);
        d.fillRectangle(x + 78, y + 81, 3, 3);
        d.fillRectangle(x + 81, y + 81, 3, 3);
        d.fillRectangle(x + 3, y + 84, 3, 3);
        d.fillRectangle(x + 6, y + 84, 3, 3);
        d.fillRectangle(x + 9, y + 84, 3, 3);
        d.fillRectangle(x + 12, y + 84, 3, 3);
        d.fillRectangle(x + 18, y + 84, 3, 3);
        d.fillRectangle(x + 21, y + 84, 3, 3);
        d.fillRectangle(x + 75, y + 84, 3, 3);
        d.fillRectangle(x + 78, y + 84, 3, 3);
        d.fillRectangle(x + 81, y + 84, 3, 3);
        d.fillRectangle(x + 6, y + 87, 3, 3);
        d.fillRectangle(x + 9, y + 87, 3, 3);
        d.fillRectangle(x + 12, y + 87, 3, 3);
        d.fillRectangle(x + 15, y + 87, 3, 3);
        d.fillRectangle(x + 18, y + 87, 3, 3);
        d.fillRectangle(x + 21, y + 87, 3, 3);
        d.fillRectangle(x + 45, y + 87, 3, 3);
        d.fillRectangle(x + 48, y + 87, 3, 3);
        d.fillRectangle(x + 51, y + 87, 3, 3);
        d.fillRectangle(x + 54, y + 87, 3, 3);
        d.fillRectangle(x + 57, y + 87, 3, 3);
        d.fillRectangle(x + 60, y + 87, 3, 3);
        d.fillRectangle(x + 63, y + 87, 3, 3);
        d.fillRectangle(x + 66, y + 87, 3, 3);
        d.fillRectangle(x + 75, y + 87, 3, 3);
        d.fillRectangle(x + 78, y + 87, 3, 3);
        d.fillRectangle(x + 12, y + 90, 3, 3);
        d.fillRectangle(x + 15, y + 90, 3, 3);
        d.fillRectangle(x + 18, y + 90, 3, 3);
        d.fillRectangle(x + 21, y + 90, 3, 3);
        d.fillRectangle(x + 45, y + 90, 3, 3);
        d.fillRectangle(x + 48, y + 90, 3, 3);
        d.fillRectangle(x + 51, y + 90, 3, 3);
        d.fillRectangle(x + 54, y + 90, 3, 3);
        d.fillRectangle(x + 57, y + 90, 3, 3);
        d.fillRectangle(x + 60, y + 90, 3, 3);
        d.fillRectangle(x + 63, y + 90, 3, 3);
        d.fillRectangle(x + 75, y + 90, 3, 3);
        d.fillRectangle(x + 78, y + 90, 3, 3);
        d.fillRectangle(x + 18, y + 93, 3, 3);
        d.fillRectangle(x + 21, y + 93, 3, 3);
        d.fillRectangle(x + 75, y + 93, 3, 3);
        d.fillRectangle(x + 78, y + 93, 3, 3);
        d.fillRectangle(x + 18, y + 96, 3, 3);
        d.fillRectangle(x + 21, y + 96, 3, 3);
        d.fillRectangle(x + 42, y + 96, 3, 3);
        d.fillRectangle(x + 45, y + 96, 3, 3);
        d.fillRectangle(x + 48, y + 96, 3, 3);
        d.fillRectangle(x + 54, y + 96, 3, 3);
        d.fillRectangle(x + 57, y + 96, 3, 3);
        d.fillRectangle(x + 75, y + 96, 3, 3);
        d.fillRectangle(x + 78, y + 96, 3, 3);
        d.fillRectangle(x + 18, y + 99, 3, 3);
        d.fillRectangle(x + 21, y + 99, 3, 3);
        d.fillRectangle(x + 42, y + 99, 3, 3);
        d.fillRectangle(x + 45, y + 99, 3, 3);
        d.fillRectangle(x + 48, y + 99, 3, 3);
        d.fillRectangle(x + 54, y + 99, 3, 3);
        d.fillRectangle(x + 57, y + 99, 3, 3);
        d.fillRectangle(x + 72, y + 99, 3, 3);
        d.fillRectangle(x + 75, y + 99, 3, 3);
        d.fillRectangle(x + 78, y + 99, 3, 3);
        d.fillRectangle(x + 18, y + 102, 3, 3);
        d.fillRectangle(x + 21, y + 102, 3, 3);
        d.fillRectangle(x + 24, y + 102, 3, 3);
        d.fillRectangle(x + 42, y + 102, 3, 3);
        d.fillRectangle(x + 45, y + 102, 3, 3);
        d.fillRectangle(x + 57, y + 102, 3, 3);
        d.fillRectangle(x + 60, y + 102, 3, 3);
        d.fillRectangle(x + 63, y + 102, 3, 3);
        d.fillRectangle(x + 66, y + 102, 3, 3);
        d.fillRectangle(x + 69, y + 102, 3, 3);
        d.fillRectangle(x + 72, y + 102, 3, 3);
        d.fillRectangle(x + 75, y + 102, 3, 3);
        d.fillRectangle(x + 21, y + 105, 3, 3);
        d.fillRectangle(x + 24, y + 105, 3, 3);
        d.fillRectangle(x + 39, y + 105, 3, 3);
        d.fillRectangle(x + 42, y + 105, 3, 3);
        d.fillRectangle(x + 45, y + 105, 3, 3);
        d.fillRectangle(x + 57, y + 105, 3, 3);
        d.fillRectangle(x + 60, y + 105, 3, 3);
        d.fillRectangle(x + 63, y + 105, 3, 3);
        d.fillRectangle(x + 66, y + 105, 3, 3);
        d.fillRectangle(x + 69, y + 105, 3, 3);
        d.fillRectangle(x + 72, y + 105, 3, 3);
        d.fillRectangle(x + 75, y + 105, 3, 3);
        d.fillRectangle(x + 21, y + 108, 3, 3);
        d.fillRectangle(x + 24, y + 108, 3, 3);
        d.fillRectangle(x + 27, y + 108, 3, 3);
        d.fillRectangle(x + 30, y + 108, 3, 3);
        d.fillRectangle(x + 33, y + 108, 3, 3);
        d.fillRectangle(x + 36, y + 108, 3, 3);
        d.fillRectangle(x + 39, y + 108, 3, 3);
        d.fillRectangle(x + 42, y + 108, 3, 3);
        d.fillRectangle(x + 63, y + 108, 3, 3);
        d.fillRectangle(x + 66, y + 108, 3, 3);
        d.fillRectangle(x + 27, y + 111, 3, 3);
        d.fillRectangle(x + 30, y + 111, 3, 3);
        d.fillRectangle(x + 33, y + 111, 3, 3);
        d.fillRectangle(x + 36, y + 111, 3, 3);
        d.fillRectangle(x + 39, y + 111, 3, 3);


    }

    /**
     * drawBodyColor.
     *
     * @param d DrawSurface
     */
    private void drawBodyColor2(DrawSurface d) {
        d.setColor(bodyColor);
        d.fillRectangle(x + 39, y + 6, 3, 3);
        d.fillRectangle(x + 42, y + 6, 3, 3);
        d.fillRectangle(x + 45, y + 6, 3, 3);
        d.fillRectangle(x + 48, y + 6, 3, 3);
        d.fillRectangle(x + 51, y + 6, 3, 3);
        d.fillRectangle(x + 54, y + 6, 3, 3);
        d.fillRectangle(x + 33, y + 9, 3, 3);
        d.fillRectangle(x + 36, y + 9, 3, 3);
        d.fillRectangle(x + 39, y + 9, 3, 3);
        d.fillRectangle(x + 42, y + 9, 3, 3);
        d.fillRectangle(x + 45, y + 9, 3, 3);
        d.fillRectangle(x + 48, y + 9, 3, 3);
        d.fillRectangle(x + 51, y + 9, 3, 3);
        d.fillRectangle(x + 54, y + 9, 3, 3);
        d.fillRectangle(x + 57, y + 9, 3, 3);
        d.fillRectangle(x + 60, y + 9, 3, 3);
        d.fillRectangle(x + 30, y + 12, 3, 3);
        d.fillRectangle(x + 33, y + 12, 3, 3);
        d.fillRectangle(x + 36, y + 12, 3, 3);
        d.fillRectangle(x + 39, y + 12, 3, 3);
        d.fillRectangle(x + 42, y + 12, 3, 3);
        d.fillRectangle(x + 45, y + 12, 3, 3);
        d.fillRectangle(x + 48, y + 12, 3, 3);
        d.fillRectangle(x + 51, y + 12, 3, 3);
        d.fillRectangle(x + 54, y + 12, 3, 3);
        d.fillRectangle(x + 57, y + 12, 3, 3);
        d.fillRectangle(x + 60, y + 12, 3, 3);
        d.fillRectangle(x + 63, y + 12, 3, 3);
        d.fillRectangle(x + 30, y + 15, 3, 3);
        d.fillRectangle(x + 33, y + 15, 3, 3);
        d.fillRectangle(x + 36, y + 15, 3, 3);
        d.fillRectangle(x + 39, y + 15, 3, 3);
        d.fillRectangle(x + 42, y + 15, 3, 3);
        d.fillRectangle(x + 45, y + 15, 3, 3);
        d.fillRectangle(x + 48, y + 15, 3, 3);
        d.fillRectangle(x + 30, y + 18, 3, 3);
        d.fillRectangle(x + 33, y + 18, 3, 3);
        d.fillRectangle(x + 36, y + 18, 3, 3);
        d.fillRectangle(x + 39, y + 18, 3, 3);
        d.fillRectangle(x + 27, y + 21, 3, 3);
        d.fillRectangle(x + 30, y + 21, 3, 3);
        d.fillRectangle(x + 33, y + 21, 3, 3);
        d.fillRectangle(x + 36, y + 21, 3, 3);
        d.fillRectangle(x + 27, y + 24, 3, 3);
        d.fillRectangle(x + 30, y + 24, 3, 3);
        d.fillRectangle(x + 33, y + 24, 3, 3);
        d.fillRectangle(x + 36, y + 24, 3, 3);
        d.fillRectangle(x + 27, y + 27, 3, 3);
        d.fillRectangle(x + 30, y + 27, 3, 3);
        d.fillRectangle(x + 33, y + 27, 3, 3);
        d.fillRectangle(x + 27, y + 30, 3, 3);
        d.fillRectangle(x + 30, y + 30, 3, 3);
        d.fillRectangle(x + 33, y + 30, 3, 3);
        d.fillRectangle(x + 27, y + 33, 3, 3);
        d.fillRectangle(x + 30, y + 33, 3, 3);
        d.fillRectangle(x + 33, y + 33, 3, 3);
        d.fillRectangle(x + 12, y + 36, 3, 3);
        d.fillRectangle(x + 15, y + 36, 3, 3);
        d.fillRectangle(x + 27, y + 36, 3, 3);
        d.fillRectangle(x + 30, y + 36, 3, 3);
        d.fillRectangle(x + 33, y + 36, 3, 3);
        d.fillRectangle(x + 36, y + 36, 3, 3);
        d.fillRectangle(x + 9, y + 39, 3, 3);
        d.fillRectangle(x + 12, y + 39, 3, 3);
        d.fillRectangle(x + 15, y + 39, 3, 3);
        d.fillRectangle(x + 27, y + 39, 3, 3);
        d.fillRectangle(x + 30, y + 39, 3, 3);
        d.fillRectangle(x + 33, y + 39, 3, 3);
        d.fillRectangle(x + 36, y + 39, 3, 3);
        d.fillRectangle(x + 9, y + 42, 3, 3);
        d.fillRectangle(x + 12, y + 42, 3, 3);
        d.fillRectangle(x + 15, y + 42, 3, 3);
        d.fillRectangle(x + 27, y + 42, 3, 3);
        d.fillRectangle(x + 30, y + 42, 3, 3);
        d.fillRectangle(x + 33, y + 42, 3, 3);
        d.fillRectangle(x + 36, y + 42, 3, 3);
        d.fillRectangle(x + 15, y + 45, 3, 3);
        d.fillRectangle(x + 27, y + 45, 3, 3);
        d.fillRectangle(x + 30, y + 45, 3, 3);
        d.fillRectangle(x + 33, y + 45, 3, 3);
        d.fillRectangle(x + 36, y + 45, 3, 3);
        d.fillRectangle(x + 39, y + 45, 3, 3);
        d.fillRectangle(x + 30, y + 48, 3, 3);
        d.fillRectangle(x + 33, y + 48, 3, 3);
        d.fillRectangle(x + 36, y + 48, 3, 3);
        d.fillRectangle(x + 39, y + 48, 3, 3);
        d.fillRectangle(x + 42, y + 48, 3, 3);
        d.fillRectangle(x + 30, y + 51, 3, 3);
        d.fillRectangle(x + 33, y + 51, 3, 3);
        d.fillRectangle(x + 36, y + 51, 3, 3);
        d.fillRectangle(x + 39, y + 51, 3, 3);
        d.fillRectangle(x + 42, y + 51, 3, 3);
        d.fillRectangle(x + 45, y + 51, 3, 3);
    }

    /**
     * drawBodyColor.
     *
     * @param d DrawSurface
     */
    private void drawBodyColor(DrawSurface d) {
        d.setColor(bodyColor);
        d.fillRectangle(x + 48, y + 51, 3, 3);
        d.fillRectangle(x + 72, y + 51, 3, 3);
        d.fillRectangle(x + 75, y + 51, 3, 3);
        d.fillRectangle(x + 30, y + 54, 3, 3);
        d.fillRectangle(x + 33, y + 54, 3, 3);
        d.fillRectangle(x + 36, y + 54, 3, 3);
        d.fillRectangle(x + 39, y + 54, 3, 3);
        d.fillRectangle(x + 42, y + 54, 3, 3);
        d.fillRectangle(x + 45, y + 54, 3, 3);
        d.fillRectangle(x + 48, y + 54, 3, 3);
        d.fillRectangle(x + 51, y + 54, 3, 3);
        d.fillRectangle(x + 54, y + 54, 3, 3);
        d.fillRectangle(x + 57, y + 54, 3, 3);
        d.fillRectangle(x + 60, y + 54, 3, 3);
        d.fillRectangle(x + 63, y + 54, 3, 3);
        d.fillRectangle(x + 66, y + 54, 3, 3);
        d.fillRectangle(x + 69, y + 54, 3, 3);
        d.fillRectangle(x + 72, y + 54, 3, 3);
        d.fillRectangle(x + 75, y + 54, 3, 3);
        d.fillRectangle(x + 30, y + 57, 3, 3);
        d.fillRectangle(x + 33, y + 57, 3, 3);
        d.fillRectangle(x + 36, y + 57, 3, 3);
        d.fillRectangle(x + 39, y + 57, 3, 3);
        d.fillRectangle(x + 42, y + 57, 3, 3);
        d.fillRectangle(x + 45, y + 57, 3, 3);
        d.fillRectangle(x + 48, y + 57, 3, 3);
        d.fillRectangle(x + 51, y + 57, 3, 3);
        d.fillRectangle(x + 54, y + 57, 3, 3);
        d.fillRectangle(x + 57, y + 57, 3, 3);
        d.fillRectangle(x + 60, y + 57, 3, 3);
        d.fillRectangle(x + 63, y + 57, 3, 3);
        d.fillRectangle(x + 66, y + 57, 3, 3);
        d.fillRectangle(x + 69, y + 57, 3, 3);
        d.fillRectangle(x + 72, y + 57, 3, 3);
        d.fillRectangle(x + 75, y + 57, 3, 3);
        d.fillRectangle(x + 30, y + 60, 3, 3);
        d.fillRectangle(x + 33, y + 60, 3, 3);
        d.fillRectangle(x + 36, y + 60, 3, 3);
        d.fillRectangle(x + 39, y + 60, 3, 3);
        d.fillRectangle(x + 42, y + 60, 3, 3);
        d.fillRectangle(x + 45, y + 60, 3, 3);
        d.fillRectangle(x + 48, y + 60, 3, 3);
        d.fillRectangle(x + 51, y + 60, 3, 3);
        d.fillRectangle(x + 54, y + 60, 3, 3);
        d.fillRectangle(x + 57, y + 60, 3, 3);
        d.fillRectangle(x + 60, y + 60, 3, 3);
        d.fillRectangle(x + 63, y + 60, 3, 3);
        d.fillRectangle(x + 66, y + 60, 3, 3);
        d.fillRectangle(x + 69, y + 60, 3, 3);
        d.fillRectangle(x + 72, y + 60, 3, 3);
        d.fillRectangle(x + 75, y + 60, 3, 3);
        d.fillRectangle(x + 33, y + 63, 3, 3);
        d.fillRectangle(x + 36, y + 63, 3, 3);
        d.fillRectangle(x + 39, y + 63, 3, 3);
        d.fillRectangle(x + 42, y + 63, 3, 3);
        d.fillRectangle(x + 45, y + 63, 3, 3);
        d.fillRectangle(x + 48, y + 63, 3, 3);
        d.fillRectangle(x + 51, y + 63, 3, 3);
        d.fillRectangle(x + 54, y + 63, 3, 3);
        d.fillRectangle(x + 57, y + 63, 3, 3);
        d.fillRectangle(x + 60, y + 63, 3, 3);
        d.fillRectangle(x + 63, y + 63, 3, 3);
        d.fillRectangle(x + 66, y + 63, 3, 3);
        d.fillRectangle(x + 69, y + 63, 3, 3);
        d.fillRectangle(x + 72, y + 63, 3, 3);
        d.fillRectangle(x + 75, y + 63, 3, 3);
        d.fillRectangle(x + 33, y + 66, 3, 3);
        d.fillRectangle(x + 36, y + 66, 3, 3);
        d.fillRectangle(x + 39, y + 66, 3, 3);
        d.fillRectangle(x + 42, y + 66, 3, 3);
        d.fillRectangle(x + 45, y + 66, 3, 3);
        d.fillRectangle(x + 48, y + 66, 3, 3);
        d.fillRectangle(x + 51, y + 66, 3, 3);
        d.fillRectangle(x + 54, y + 66, 3, 3);
        d.fillRectangle(x + 57, y + 66, 3, 3);
        d.fillRectangle(x + 60, y + 66, 3, 3);
        d.fillRectangle(x + 63, y + 66, 3, 3);
        d.fillRectangle(x + 66, y + 66, 3, 3);
        d.fillRectangle(x + 69, y + 66, 3, 3);
        d.fillRectangle(x + 72, y + 66, 3, 3);
        d.fillRectangle(x + 36, y + 69, 3, 3);
        d.fillRectangle(x + 39, y + 69, 3, 3);
        d.fillRectangle(x + 42, y + 69, 3, 3);
        d.fillRectangle(x + 45, y + 69, 3, 3);
        d.fillRectangle(x + 48, y + 69, 3, 3);
        d.fillRectangle(x + 51, y + 69, 3, 3);
        d.fillRectangle(x + 54, y + 69, 3, 3);
        d.fillRectangle(x + 57, y + 69, 3, 3);
        d.fillRectangle(x + 60, y + 69, 3, 3);
        d.fillRectangle(x + 63, y + 69, 3, 3);
        d.fillRectangle(x + 66, y + 69, 3, 3);
        d.fillRectangle(x + 69, y + 69, 3, 3);
        d.fillRectangle(x + 39, y + 72, 3, 3);
        d.fillRectangle(x + 42, y + 72, 3, 3);
        d.fillRectangle(x + 45, y + 72, 3, 3);
        d.fillRectangle(x + 48, y + 72, 3, 3);
        d.fillRectangle(x + 51, y + 72, 3, 3);
        d.fillRectangle(x + 54, y + 72, 3, 3);
        d.fillRectangle(x + 57, y + 72, 3, 3);
        d.fillRectangle(x + 60, y + 72, 3, 3);
        d.fillRectangle(x + 63, y + 72, 3, 3);
        d.fillRectangle(x + 66, y + 72, 3, 3);
        d.fillRectangle(x + 42, y + 75, 3, 3);
        d.fillRectangle(x + 45, y + 75, 3, 3);
        d.fillRectangle(x + 48, y + 75, 3, 3);
        d.fillRectangle(x + 51, y + 75, 3, 3);
        d.fillRectangle(x + 54, y + 75, 3, 3);
        d.fillRectangle(x + 57, y + 75, 3, 3);
        d.fillRectangle(x + 60, y + 75, 3, 3);
        d.fillRectangle(x + 63, y + 75, 3, 3);

    }

    /**
     * drawSecondBodyColor.
     *
     * @param d DrawSurface
     */
    private void drawSecondBodyColor2(DrawSurface d) {
        d.setColor(secondBodyColor);
        d.fillRectangle(x + 66, y + 12, 3, 3);
        d.fillRectangle(x + 24, y + 30, 3, 3);
        d.fillRectangle(x + 24, y + 33, 3, 3);
        d.fillRectangle(x + 24, y + 36, 3, 3);
        d.fillRectangle(x + 24, y + 39, 3, 3);
        d.fillRectangle(x + 24, y + 42, 3, 3);
        d.fillRectangle(x + 6, y + 45, 3, 3);
        d.fillRectangle(x + 9, y + 45, 3, 3);
        d.fillRectangle(x + 12, y + 45, 3, 3);
        d.fillRectangle(x + 24, y + 45, 3, 3);
        d.fillRectangle(x + 6, y + 48, 3, 3);
        d.fillRectangle(x + 9, y + 48, 3, 3);
        d.fillRectangle(x + 12, y + 48, 3, 3);
        d.fillRectangle(x + 15, y + 48, 3, 3);
        d.fillRectangle(x + 24, y + 48, 3, 3);
        d.fillRectangle(x + 27, y + 48, 3, 3);
        d.fillRectangle(x + 6, y + 51, 3, 3);
        d.fillRectangle(x + 9, y + 51, 3, 3);
        d.fillRectangle(x + 12, y + 51, 3, 3);
        d.fillRectangle(x + 15, y + 51, 3, 3);
        d.fillRectangle(x + 24, y + 51, 3, 3);
        d.fillRectangle(x + 27, y + 51, 3, 3);
        d.fillRectangle(x + 6, y + 54, 3, 3);
        d.fillRectangle(x + 9, y + 54, 3, 3);
        d.fillRectangle(x + 12, y + 54, 3, 3);
        d.fillRectangle(x + 15, y + 54, 3, 3);
        d.fillRectangle(x + 24, y + 54, 3, 3);
        d.fillRectangle(x + 27, y + 54, 3, 3);
        d.fillRectangle(x + 6, y + 57, 3, 3);
        d.fillRectangle(x + 9, y + 57, 3, 3);
        d.fillRectangle(x + 12, y + 57, 3, 3);
        d.fillRectangle(x + 15, y + 57, 3, 3);
        d.fillRectangle(x + 24, y + 57, 3, 3);
        d.fillRectangle(x + 27, y + 57, 3, 3);
        d.fillRectangle(x + 6, y + 60, 3, 3);
        d.fillRectangle(x + 9, y + 60, 3, 3);
        d.fillRectangle(x + 12, y + 60, 3, 3);
        d.fillRectangle(x + 15, y + 60, 3, 3);
        d.fillRectangle(x + 24, y + 60, 3, 3);
        d.fillRectangle(x + 27, y + 60, 3, 3);
        d.fillRectangle(x + 6, y + 63, 3, 3);
        d.fillRectangle(x + 9, y + 63, 3, 3);
        d.fillRectangle(x + 12, y + 63, 3, 3);
        d.fillRectangle(x + 15, y + 63, 3, 3);
        d.fillRectangle(x + 24, y + 63, 3, 3);
        d.fillRectangle(x + 27, y + 63, 3, 3);
        d.fillRectangle(x + 30, y + 63, 3, 3);
        d.fillRectangle(x + 6, y + 66, 3, 3);
        d.fillRectangle(x + 9, y + 66, 3, 3);
        d.fillRectangle(x + 12, y + 66, 3, 3);
        d.fillRectangle(x + 15, y + 66, 3, 3);
        d.fillRectangle(x + 24, y + 66, 3, 3);
        d.fillRectangle(x + 27, y + 66, 3, 3);
        d.fillRectangle(x + 30, y + 66, 3, 3);
        d.fillRectangle(x + 75, y + 66, 3, 3);
        d.fillRectangle(x + 6, y + 69, 3, 3);
        d.fillRectangle(x + 9, y + 69, 3, 3);
        d.fillRectangle(x + 12, y + 69, 3, 3);
        d.fillRectangle(x + 15, y + 69, 3, 3);
        d.fillRectangle(x + 24, y + 69, 3, 3);
        d.fillRectangle(x + 27, y + 69, 3, 3);
        d.fillRectangle(x + 30, y + 69, 3, 3);
        d.fillRectangle(x + 33, y + 69, 3, 3);
        d.fillRectangle(x + 72, y + 69, 3, 3);
        d.fillRectangle(x + 75, y + 69, 3, 3);
        d.fillRectangle(x + 6, y + 72, 3, 3);
    }

    /**
     * drawSecondBodyColor.
     *
     * @param d DrawSurface
     */
    private void drawSecondBodyColor(DrawSurface d) {
        d.setColor(secondBodyColor);

        d.fillRectangle(x + 9, y + 72, 3, 3);
        d.fillRectangle(x + 12, y + 72, 3, 3);
        d.fillRectangle(x + 15, y + 72, 3, 3);
        d.fillRectangle(x + 24, y + 72, 3, 3);
        d.fillRectangle(x + 27, y + 72, 3, 3);
        d.fillRectangle(x + 30, y + 72, 3, 3);
        d.fillRectangle(x + 33, y + 72, 3, 3);
        d.fillRectangle(x + 36, y + 72, 3, 3);
        d.fillRectangle(x + 69, y + 72, 3, 3);
        d.fillRectangle(x + 72, y + 72, 3, 3);
        d.fillRectangle(x + 75, y + 72, 3, 3);
        d.fillRectangle(x + 9, y + 75, 3, 3);
        d.fillRectangle(x + 12, y + 75, 3, 3);
        d.fillRectangle(x + 15, y + 75, 3, 3);
        d.fillRectangle(x + 24, y + 75, 3, 3);
        d.fillRectangle(x + 27, y + 75, 3, 3);
        d.fillRectangle(x + 30, y + 75, 3, 3);
        d.fillRectangle(x + 33, y + 75, 3, 3);
        d.fillRectangle(x + 36, y + 75, 3, 3);
        d.fillRectangle(x + 39, y + 75, 3, 3);
        d.fillRectangle(x + 66, y + 75, 3, 3);
        d.fillRectangle(x + 69, y + 75, 3, 3);
        d.fillRectangle(x + 72, y + 75, 3, 3);
        d.fillRectangle(x + 75, y + 75, 3, 3);
        d.fillRectangle(x + 9, y + 78, 3, 3);
        d.fillRectangle(x + 12, y + 78, 3, 3);
        d.fillRectangle(x + 15, y + 78, 3, 3);
        d.fillRectangle(x + 24, y + 78, 3, 3);
        d.fillRectangle(x + 27, y + 78, 3, 3);
        d.fillRectangle(x + 30, y + 78, 3, 3);
        d.fillRectangle(x + 33, y + 78, 3, 3);
        d.fillRectangle(x + 36, y + 78, 3, 3);
        d.fillRectangle(x + 39, y + 78, 3, 3);
        d.fillRectangle(x + 42, y + 78, 3, 3);
        d.fillRectangle(x + 45, y + 78, 3, 3);
        d.fillRectangle(x + 48, y + 78, 3, 3);
        d.fillRectangle(x + 51, y + 78, 3, 3);
        d.fillRectangle(x + 54, y + 78, 3, 3);
        d.fillRectangle(x + 57, y + 78, 3, 3);
        d.fillRectangle(x + 60, y + 78, 3, 3);
        d.fillRectangle(x + 63, y + 78, 3, 3);
        d.fillRectangle(x + 66, y + 78, 3, 3);
        d.fillRectangle(x + 69, y + 78, 3, 3);
        d.fillRectangle(x + 72, y + 78, 3, 3);
        d.fillRectangle(x + 75, y + 78, 3, 3);
        d.fillRectangle(x + 9, y + 81, 3, 3);
        d.fillRectangle(x + 12, y + 81, 3, 3);
        d.fillRectangle(x + 15, y + 81, 3, 3);
        d.fillRectangle(x + 24, y + 81, 3, 3);
        d.fillRectangle(x + 27, y + 81, 3, 3);
        d.fillRectangle(x + 30, y + 81, 3, 3);
        d.fillRectangle(x + 33, y + 81, 3, 3);
        d.fillRectangle(x + 36, y + 81, 3, 3);
        d.fillRectangle(x + 39, y + 81, 3, 3);
        d.fillRectangle(x + 42, y + 81, 3, 3);
        d.fillRectangle(x + 45, y + 81, 3, 3);
        d.fillRectangle(x + 48, y + 81, 3, 3);
        d.fillRectangle(x + 51, y + 81, 3, 3);
        d.fillRectangle(x + 54, y + 81, 3, 3);
        d.fillRectangle(x + 57, y + 81, 3, 3);
        d.fillRectangle(x + 60, y + 81, 3, 3);
        d.fillRectangle(x + 63, y + 81, 3, 3);
        d.fillRectangle(x + 66, y + 81, 3, 3);
        d.fillRectangle(x + 69, y + 81, 3, 3);
        d.fillRectangle(x + 72, y + 81, 3, 3);
        d.fillRectangle(x + 75, y + 81, 3, 3);
        d.fillRectangle(x + 15, y + 84, 3, 3);
        d.fillRectangle(x + 24, y + 84, 3, 3);
        d.fillRectangle(x + 27, y + 84, 3, 3);
        d.fillRectangle(x + 30, y + 84, 3, 3);
        d.fillRectangle(x + 33, y + 84, 3, 3);
        d.fillRectangle(x + 36, y + 84, 3, 3);
        d.fillRectangle(x + 39, y + 84, 3, 3);
        d.fillRectangle(x + 42, y + 84, 3, 3);
        d.fillRectangle(x + 45, y + 84, 3, 3);
        d.fillRectangle(x + 48, y + 84, 3, 3);
        d.fillRectangle(x + 51, y + 84, 3, 3);
        d.fillRectangle(x + 54, y + 84, 3, 3);
        d.fillRectangle(x + 57, y + 84, 3, 3);
        d.fillRectangle(x + 60, y + 84, 3, 3);
        d.fillRectangle(x + 63, y + 84, 3, 3);
        d.fillRectangle(x + 66, y + 84, 3, 3);
        d.fillRectangle(x + 69, y + 84, 3, 3);
        d.fillRectangle(x + 72, y + 84, 3, 3);
        d.fillRectangle(x + 24, y + 87, 3, 3);
        d.fillRectangle(x + 27, y + 87, 3, 3);
        d.fillRectangle(x + 30, y + 87, 3, 3);
        d.fillRectangle(x + 33, y + 87, 3, 3);
        d.fillRectangle(x + 36, y + 87, 3, 3);
        d.fillRectangle(x + 39, y + 87, 3, 3);
        d.fillRectangle(x + 42, y + 87, 3, 3);
        d.fillRectangle(x + 69, y + 87, 3, 3);
        d.fillRectangle(x + 72, y + 87, 3, 3);
        d.fillRectangle(x + 24, y + 90, 3, 3);
        d.fillRectangle(x + 27, y + 90, 3, 3);
        d.fillRectangle(x + 30, y + 90, 3, 3);
        d.fillRectangle(x + 33, y + 90, 3, 3);
        d.fillRectangle(x + 36, y + 90, 3, 3);
        d.fillRectangle(x + 39, y + 90, 3, 3);
        d.fillRectangle(x + 42, y + 90, 3, 3);
        d.fillRectangle(x + 66, y + 90, 3, 3);
        d.fillRectangle(x + 69, y + 90, 3, 3);
        d.fillRectangle(x + 72, y + 90, 3, 3);
        d.fillRectangle(x + 24, y + 93, 3, 3);
        d.fillRectangle(x + 27, y + 93, 3, 3);
        d.fillRectangle(x + 30, y + 93, 3, 3);
        d.fillRectangle(x + 33, y + 93, 3, 3);
        d.fillRectangle(x + 36, y + 93, 3, 3);
        d.fillRectangle(x + 39, y + 93, 3, 3);
        d.fillRectangle(x + 60, y + 93, 3, 3);
        d.fillRectangle(x + 63, y + 93, 3, 3);
        d.fillRectangle(x + 66, y + 93, 3, 3);
        d.fillRectangle(x + 69, y + 93, 3, 3);
        d.fillRectangle(x + 72, y + 93, 3, 3);
        d.fillRectangle(x + 24, y + 96, 3, 3);
        d.fillRectangle(x + 27, y + 96, 3, 3);
        d.fillRectangle(x + 30, y + 96, 3, 3);
        d.fillRectangle(x + 33, y + 96, 3, 3);
        d.fillRectangle(x + 36, y + 96, 3, 3);
        d.fillRectangle(x + 39, y + 96, 3, 3);
        d.fillRectangle(x + 60, y + 96, 3, 3);
        d.fillRectangle(x + 63, y + 96, 3, 3);
        d.fillRectangle(x + 66, y + 96, 3, 3);
        d.fillRectangle(x + 69, y + 96, 3, 3);
        d.fillRectangle(x + 72, y + 96, 3, 3);
        d.fillRectangle(x + 24, y + 99, 3, 3);
        d.fillRectangle(x + 27, y + 99, 3, 3);
        d.fillRectangle(x + 30, y + 99, 3, 3);
        d.fillRectangle(x + 33, y + 99, 3, 3);
        d.fillRectangle(x + 36, y + 99, 3, 3);
        d.fillRectangle(x + 39, y + 99, 3, 3);
        d.fillRectangle(x + 60, y + 99, 3, 3);
        d.fillRectangle(x + 63, y + 99, 3, 3);
        d.fillRectangle(x + 66, y + 99, 3, 3);
        d.fillRectangle(x + 69, y + 99, 3, 3);
        d.fillRectangle(x + 27, y + 102, 3, 3);
        d.fillRectangle(x + 30, y + 102, 3, 3);
        d.fillRectangle(x + 33, y + 102, 3, 3);
        d.fillRectangle(x + 36, y + 102, 3, 3);
        d.fillRectangle(x + 39, y + 102, 3, 3);
        d.fillRectangle(x + 27, y + 105, 3, 3);
        d.fillRectangle(x + 30, y + 105, 3, 3);
        d.fillRectangle(x + 33, y + 105, 3, 3);
        d.fillRectangle(x + 36, y + 105, 3, 3);

    }

    /**
     * draw171.
     *
     * @param d DrawSurface
     */
    private void draw171(DrawSurface d) {
        d.setColor(new Color(1, 7, 1));
        d.fillRectangle(x + 51, y + 15, 3, 3);
        d.fillRectangle(x + 54, y + 15, 3, 3);
        d.fillRectangle(x + 57, y + 15, 3, 3);
        d.fillRectangle(x + 60, y + 15, 3, 3);
        d.fillRectangle(x + 63, y + 15, 3, 3);
        d.fillRectangle(x + 66, y + 15, 3, 3);
        d.fillRectangle(x + 69, y + 15, 3, 3);
        d.fillRectangle(x + 72, y + 15, 3, 3);
        d.fillRectangle(x + 75, y + 15, 3, 3);
        d.fillRectangle(x + 21, y + 18, 3, 3);
        d.fillRectangle(x + 24, y + 18, 3, 3);
        d.fillRectangle(x + 27, y + 18, 3, 3);

    }

    /**
     * draw157198215.
     *
     * @param d DrawSurface
     */
    private void draw157198215(DrawSurface d) {
        d.setColor(new Color(157, 198, 215));
        d.fillRectangle(x + 57, y + 21, 3, 3);
        d.fillRectangle(x + 60, y + 21, 3, 3);
        d.fillRectangle(x + 63, y + 21, 3, 3);
        d.fillRectangle(x + 45, y + 24, 3, 3);
        d.fillRectangle(x + 48, y + 24, 3, 3);
        d.fillRectangle(x + 51, y + 24, 3, 3);
        d.fillRectangle(x + 54, y + 24, 3, 3);
        d.fillRectangle(x + 57, y + 24, 3, 3);
        d.fillRectangle(x + 72, y + 24, 3, 3);
        d.fillRectangle(x + 75, y + 24, 3, 3);
        d.fillRectangle(x + 78, y + 27, 3, 3);
        d.fillRectangle(x + 48, y + 30, 3, 3);
        d.fillRectangle(x + 51, y + 30, 3, 3);
        d.fillRectangle(x + 54, y + 30, 3, 3);
        d.fillRectangle(x + 57, y + 30, 3, 3);
        d.fillRectangle(x + 78, y + 30, 3, 3);
        d.fillRectangle(x + 81, y + 30, 3, 3);
        d.fillRectangle(x + 51, y + 33, 3, 3);
        d.fillRectangle(x + 54, y + 33, 3, 3);
        d.fillRectangle(x + 57, y + 33, 3, 3);
        d.fillRectangle(x + 60, y + 33, 3, 3);
        d.fillRectangle(x + 63, y + 33, 3, 3);
        d.fillRectangle(x + 66, y + 33, 3, 3);
        d.fillRectangle(x + 69, y + 33, 3, 3);
        d.fillRectangle(x + 72, y + 33, 3, 3);
        d.fillRectangle(x + 75, y + 33, 3, 3);
        d.fillRectangle(x + 78, y + 33, 3, 3);
        d.fillRectangle(x + 81, y + 33, 3, 3);
        d.fillRectangle(x + 54, y + 36, 3, 3);
        d.fillRectangle(x + 57, y + 36, 3, 3);
        d.fillRectangle(x + 60, y + 36, 3, 3);
        d.fillRectangle(x + 63, y + 36, 3, 3);
        d.fillRectangle(x + 66, y + 36, 3, 3);
        d.fillRectangle(x + 69, y + 36, 3, 3);
        d.fillRectangle(x + 72, y + 36, 3, 3);
        d.fillRectangle(x + 75, y + 36, 3, 3);

    }

    /**
     * draw223.
     *
     * @param d DrawSurface
     */
    private void draw223(DrawSurface d) {
        d.setColor(new Color(2, 2, 3));
        d.fillRectangle(x + 66, y + 21, 3, 3);
        d.fillRectangle(x + 69, y + 21, 3, 3);
        d.fillRectangle(x + 72, y + 21, 3, 3);
        d.fillRectangle(x + 75, y + 21, 3, 3);
        d.fillRectangle(x + 78, y + 21, 3, 3);
        d.fillRectangle(x + 81, y + 21, 3, 3);
        d.fillRectangle(x + 21, y + 24, 3, 3);
        d.fillRectangle(x + 24, y + 24, 3, 3);

    }

    /**
     * drawWhite.
     *
     * @param d DrawSurface
     */
    private void drawWhite(DrawSurface d) {
        d.setColor(new Color(255, 255, 255));
        d.fillRectangle(x + 60, y + 24, 3, 3);
        d.fillRectangle(x + 63, y + 24, 3, 3);
        d.fillRectangle(x + 66, y + 24, 3, 3);
        d.fillRectangle(x + 69, y + 24, 3, 3);

    }

    /**
     * draw150189206.
     *
     * @param d DrawSurface
     */
    private void draw150189206(DrawSurface d) {
        d.setColor(new Color(150, 189, 206));
        d.fillRectangle(x + 45, y + 27, 3, 3);
        d.fillRectangle(x + 48, y + 27, 3, 3);
        d.fillRectangle(x + 51, y + 27, 3, 3);
        d.fillRectangle(x + 54, y + 27, 3, 3);

    }

    /**
     * draw221235241.
     *
     * @param d DrawSurface
     */
    private void draw221235241(DrawSurface d) {
        d.setColor(new Color(221, 235, 241));
        d.fillRectangle(x + 57, y + 27, 3, 3);
        d.fillRectangle(x + 60, y + 27, 3, 3);
        d.fillRectangle(x + 63, y + 27, 3, 3);
        d.fillRectangle(x + 66, y + 27, 3, 3);
        d.fillRectangle(x + 69, y + 27, 3, 3);
        d.fillRectangle(x + 72, y + 27, 3, 3);
        d.fillRectangle(x + 75, y + 27, 3, 3);

    }

    /**
     * draw7899107.
     *
     * @param d DrawSurface
     */
    private void draw7899107(DrawSurface d) {
        d.setColor(new Color(78, 99, 107));
        d.fillRectangle(x + 42, y + 30, 3, 3);
        d.fillRectangle(x + 45, y + 30, 3, 3);
        d.fillRectangle(x + 45, y + 33, 3, 3);
        d.fillRectangle(x + 48, y + 33, 3, 3);
        d.fillRectangle(x + 45, y + 36, 3, 3);
        d.fillRectangle(x + 48, y + 36, 3, 3);
        d.fillRectangle(x + 51, y + 36, 3, 3);
        d.fillRectangle(x + 78, y + 36, 3, 3);
        d.fillRectangle(x + 81, y + 36, 3, 3);
        d.fillRectangle(x + 45, y + 39, 3, 3);
        d.fillRectangle(x + 48, y + 39, 3, 3);
        d.fillRectangle(x + 51, y + 39, 3, 3);
        d.fillRectangle(x + 54, y + 39, 3, 3);
        d.fillRectangle(x + 57, y + 39, 3, 3);
        d.fillRectangle(x + 60, y + 39, 3, 3);
        d.fillRectangle(x + 63, y + 39, 3, 3);
        d.fillRectangle(x + 66, y + 39, 3, 3);
        d.fillRectangle(x + 69, y + 39, 3, 3);
        d.fillRectangle(x + 72, y + 39, 3, 3);
        d.fillRectangle(x + 75, y + 39, 3, 3);
        d.fillRectangle(x + 78, y + 39, 3, 3);
        d.fillRectangle(x + 48, y + 42, 3, 3);
        d.fillRectangle(x + 51, y + 42, 3, 3);
        d.fillRectangle(x + 54, y + 42, 3, 3);
        d.fillRectangle(x + 57, y + 42, 3, 3);
        d.fillRectangle(x + 60, y + 42, 3, 3);
        d.fillRectangle(x + 63, y + 42, 3, 3);
        d.fillRectangle(x + 66, y + 42, 3, 3);
        d.fillRectangle(x + 69, y + 42, 3, 3);
        d.fillRectangle(x + 72, y + 42, 3, 3);
        d.fillRectangle(x + 75, y + 42, 3, 3);
        d.fillRectangle(x + 51, y + 45, 3, 3);
        d.fillRectangle(x + 54, y + 45, 3, 3);
        d.fillRectangle(x + 57, y + 45, 3, 3);
        d.fillRectangle(x + 60, y + 45, 3, 3);
        d.fillRectangle(x + 63, y + 45, 3, 3);
        d.fillRectangle(x + 66, y + 45, 3, 3);

    }

    /**
     * draw235243247.
     *
     * @param d DrawSurface
     */
    private void draw235243247(DrawSurface d) {
        d.setColor(new Color(235, 243, 247));
        d.fillRectangle(x + 60, y + 30, 3, 3);
        d.fillRectangle(x + 63, y + 30, 3, 3);
        d.fillRectangle(x + 66, y + 30, 3, 3);
        d.fillRectangle(x + 69, y + 30, 3, 3);
        d.fillRectangle(x + 72, y + 30, 3, 3);
        d.fillRectangle(x + 75, y + 30, 3, 3);

    }

    /**
     * draw3404.
     *
     * @param d DrawSurface
     */
    private void draw3404(DrawSurface d) {
        d.setColor(new Color(3, 40, 4));
        d.fillRectangle(x + 42, y + 93, 3, 3);
        d.fillRectangle(x + 45, y + 93, 3, 3);
        d.fillRectangle(x + 48, y + 93, 3, 3);
        d.fillRectangle(x + 54, y + 93, 3, 3);
        d.fillRectangle(x + 57, y + 93, 3, 3);

    }

}
