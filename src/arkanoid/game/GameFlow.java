package arkanoid.game;

import arkanoid.game.levels.LevelInformation;
import arkanoid.game.screens.KeyPressStoppableAnimation;
import arkanoid.game.screens.LoseEndScreen;
import arkanoid.game.screens.WinEndScreen;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * @author Tommy Zaft
 * <p>
 * In charge of creating the different levels, and moving from one level to the next.
 */
public class GameFlow {
    private final GUI gui;
    private final KeyboardSensor keyboard;
    private final Counter scoreCounter;
    private final AnimationRunner animationRunner;

    /**
     * constructor.
     *
     * @param ar  AnimationRunner
     * @param ks  KeyboardSensor
     * @param gui GUI
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.gui = gui;
        this.keyboard = ks;
        this.animationRunner = ar;
        this.scoreCounter = new Counter();
    }

    /**
     * run levels.
     *
     * @param levels levels
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean didLose = false;
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboard, this.animationRunner, this.gui,
                    this.scoreCounter);
            level.initialize();
            while (!level.shouldStop()) {
                level.run();
            }
            if (level.getNumberOfBalls() == 0) {
                didLose = true;
                break;
            }
        }
        KeyPressStoppableAnimation screen;
        if (!didLose) {
            screen = new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY,
                    new WinEndScreen(this.scoreCounter.getValue()));

        } else {
            screen = new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY,
                    new LoseEndScreen(this.scoreCounter.getValue()));
        }
        animationRunner.run(screen);

        gui.close();
    }
}