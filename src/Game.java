import arkanoid.game.AnimationRunner;
import arkanoid.game.GameFlow;
import arkanoid.game.levels.LevelInformation;
// all four levels
import arkanoid.game.levels.FinalOne;
import arkanoid.game.levels.DirectHit;
import arkanoid.game.levels.WideEasy;
import arkanoid.game.levels.SpaceLevel;

import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tommy Zaft
 * <p>
 * The game.
 */
public class Game {
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    private static final int FRAMES_PER_SECOND = 60;

    /**
     * initializes and runs a game.
     *
     * @param args arguments passed
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid Game", SCREEN_WIDTH, SCREEN_HEIGHT);
        AnimationRunner ar = new AnimationRunner(gui, FRAMES_PER_SECOND);
        GameFlow gameFlow = new GameFlow(ar, gui.getKeyboardSensor(), gui);

        List<LevelInformation> levels = new ArrayList<>();

        for (String arg : args) {
            int index;
            try {
                index = Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                continue;
            }
            if (index == 1) {
                levels.add(new DirectHit());
            } else if (index == 2) {
                levels.add(new WideEasy());
            } else if (index == 3) {
                levels.add(new SpaceLevel());
            } else if (index == 4) {
                levels.add(new FinalOne());
            }
        }
        if (levels.isEmpty()) {
            levels.add(new DirectHit());
            levels.add(new WideEasy());
            levels.add(new SpaceLevel());
            levels.add(new FinalOne());
        }

        gameFlow.runLevels(levels);
    }
}
