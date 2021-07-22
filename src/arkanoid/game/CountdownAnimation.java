package arkanoid.game;

import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

import arkanoid.shapes.special.TrafficLight;

/**
 * @author Tommy Zaft
 * <p>
 * The countdown screen showing up before every level.
 */
public class CountdownAnimation implements Animation {
    private final SpriteCollection gameScreen;
    private final double numOfSeconds;
    private final int countFrom;
    private static int counter;

    private static final int TRAFFIC_LIGHT_X = 490;
    private static final int TRAFFIC_LIGHT_Y = 330;

    private final Color textColor;

    // traffic light colors.
    private static final Color RED = new Color(228, 0, 0);
    private static final Color YELLOW = new Color(253, 206, 74);
    private static final Color GREEN = new Color(73, 230, 60);

    /**
     * constructor for CountdownAnimation.
     *
     * @param numOfSeconds num of seconds to show each number.
     * @param countFrom    count from.
     * @param gameScreen   the game screen
     * @param textColor    text color
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, Color textColor) {
        this.numOfSeconds = numOfSeconds;
        this.gameScreen = gameScreen;
        this.countFrom = countFrom;
        counter = countFrom;
        this.textColor = textColor;
    }


    /**
     * draw the "Go!" text.
     *
     * @param d     DrawSurface
     * @param textY textY
     */
    private void drawGoText(DrawSurface d, int textY) {
        int goTextX = 40 * d.getWidth() / 100;
        d.setColor(textColor);
        d.drawText(goTextX, textY, "Go!", 100);
        new TrafficLight(TRAFFIC_LIGHT_X, TRAFFIC_LIGHT_Y, GREEN).drawOn(d);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        int millisecondsPerFrame = (int) (numOfSeconds / countFrom) * 1000;
        long startTime = System.currentTimeMillis(); // timing

        this.gameScreen.drawAllOn(d);

        int textX = 47 * d.getWidth() / 100;
        int textY = 2 * d.getHeight() / 3;

        if (counter <= 0) {
            this.drawGoText(d, textY);
        } else {
            d.setColor(textColor);
            d.drawText(textX, textY, Integer.toString(counter), 100);
            if (counter == 1) {
                new TrafficLight(TRAFFIC_LIGHT_X, TRAFFIC_LIGHT_Y, YELLOW).drawOn(d);
            } else {
                new TrafficLight(TRAFFIC_LIGHT_X, TRAFFIC_LIGHT_Y, RED).drawOn(d);
            }
        }

        if (counter < countFrom && counter > -1) {
            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
        --counter;
    }

    @Override
    public boolean shouldStop() {
        if (counter == -2) {
            new Sleeper().sleepFor(500);
        }
        return counter == -2;
    }
}
