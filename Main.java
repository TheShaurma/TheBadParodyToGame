import java.util.HashMap;
import java.util.Scanner;

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
    private static Scanner in;
    private static boolean run;

    public static void main(String[] args) throws PositionException {
        System.out.println("Hello World!");

        initVariables();
        placeStones();

        String input;
        while (run) {
            visualizer.showConsole();

            System.out.print("Use WASD to move:");
            input = in.next();

            if (input.equals("w") ||
                    input.equals("W")) {
                playerManager.movePlayerUp();

            } else if (input.equals("a") ||
                    input.equals("A")) {
                playerManager.movePlayerLeft();

            } else if (input.equals("s") ||
                    input.equals("S")) {
                playerManager.movePlayerDown();

            } else if (input.equals("d") ||
                    input.equals("D")) {
                playerManager.movePlayerRight();

            } else if (input.equals("q") ||
                    input.equals("Q")) {
                // quit
                run = false;
            }
        }
    }

    private static void initVariables() throws PositionException {
        area = new GameArea();

        visualizer = new Visualizer(new IntegerPosition2D(-10, -10),
                new IntegerPosition2D(10, 10), area);
        HashMap<Class<?>, String> consoleVisualMap = visualizer.getConsoleVisualMap();
        consoleVisualMap.put(new Player().getClass(), "P");
        consoleVisualMap.put(new Stone().getClass(), "s");

        playerManager = new PlayerManager(area, new Player(), new IntegerPosition2D(0, 0));

        in = new Scanner(System.in);
        run = true;
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
