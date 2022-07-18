import java.util.HashMap;

import game.ObjectsInArea.Stone;
import game.ObjectsInArea.player.Player;
import game.ObjectsInArea.player.PlayerManager;
import game.area.GameArea;
import game.area.IntegerPosition2D;
import game.area.PositionException;
import game.visualizer.Visualizer;

public class Main {
    private static GameArea area;
    private static Visualizer visualizer;
    private static PlayerManager playerManager;

    public static void main(String[] args) throws PositionException {
        System.out.println("Hello World!");

        initVariables();
        placeStones();

        playerManager.movePlayerDown();
        playerManager.movePlayerDown();
        playerManager.movePlayerDown();

        visualizer.showConsole();
    }

    private static void initVariables() throws PositionException {
        area = new GameArea();

        visualizer = new Visualizer(new IntegerPosition2D(-10, -10),
                new IntegerPosition2D(10, 10), area);
        HashMap<Class<?>, String> consoleVisualMap = visualizer.getConsoleVisualMap();
        consoleVisualMap.put(new Player().getClass(), "P");
        consoleVisualMap.put(new Stone().getClass(), "s");

        playerManager = new PlayerManager(area, new Player(), new IntegerPosition2D(0, 0));
    }

    private static void placeStones() throws PositionException {
        int x;
        int y;

        for (x = -10; x <= 10; x++) {
            area.place(new IntegerPosition2D(x, 10), new Stone());
            area.place(new IntegerPosition2D(x, -10), new Stone());
        }

        for (y = -9; y <= 9; y++) {
            area.place(new IntegerPosition2D(-10, y), new Stone());
            area.place(new IntegerPosition2D(10, y), new Stone());
        }

    }
}
