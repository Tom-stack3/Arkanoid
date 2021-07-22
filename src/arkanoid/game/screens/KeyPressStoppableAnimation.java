package arkanoid.game.screens;

import arkanoid.game.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Tommy Zaft
 * <p>
 * Represents a KeyPressStoppableAnimation.
 */
public class KeyPressStoppableAnimation implements Animation {
    private final KeyboardSensor keyboardSensor;
    private final String key;
    private final Animation animation;
    private boolean shouldStop;
    private static boolean firstTime = true;
    private static final long TIME_NEED_TO_PASS = 250;
    private static long lastPress = System.currentTimeMillis();

    /**
     * constructor.
     *
     * @param sensor    KeyboardSensor
     * @param key       String
     * @param animation Animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.keyboardSensor = sensor;
        this.shouldStop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);

        if (this.keyboardSensor.isPressed(key)) {
            long timePassed = System.currentTimeMillis() - lastPress;
            if (firstTime || (timePassed > TIME_NEED_TO_PASS)) {
                firstTime = false;
                this.shouldStop = true;
                lastPress = System.currentTimeMillis();
            }
        }
    }

    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }
}
