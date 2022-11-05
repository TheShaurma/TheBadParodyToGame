import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import game.ObjectsInArea.Stone;
import game.ObjectsInArea.fire.Fire;
import game.ObjectsInArea.player.Player;
import game.ObjectsInArea.player.PlayerDiedException;
import game.ObjectsInArea.player.PlayerManager;
import game.area.CheckeredArea;
import game.area.position.GameIntegerPosition2D;
import game.area.position.PositionException;
import game.rooms.CheckeredAreaReader;
import game.rooms.CheckeredAreaSerializer;
import game.rooms.UnknownSymbolException;
import game.visualizer.Visualizer;

public class Main {
    private static CheckeredArea area;
    private static Visualizer visualizer;
    private static PlayerManager playerManager;
    private static Scanner in;
    private static boolean run;

    public static void main(String[] args) throws PositionException, IOException, UnknownSymbolException {
        System.out.println("Hello World!");

        initVariables();

        String input;
        while (run) {
            visualizer.showConsole();
            System.out.print("Use WASD to move and Q to quit:");

            input = in.next();
            try {
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
            } catch (PlayerDiedException e) {
                System.out.println("Game Over!");
                run = false;
            }
        }

        CheckeredAreaSerializer.writeArea(area, "startArea");
    }

    private static void initVariables() throws PositionException, IOException, UnknownSymbolException {
        area = CheckeredAreaReader.readArea("game\\rooms\\StartLevel.txt");

        visualizer = new Visualizer(new GameIntegerPosition2D(0, 0),
                new GameIntegerPosition2D(30, 30), area);
        HashMap<Class<?>, String> consoleVisualMap = visualizer.getConsoleVisualMap();
        consoleVisualMap.put(new Player().getClass(), "P");
        consoleVisualMap.put(new Stone().getClass(), "s");
        consoleVisualMap.put(new Fire().getClass(), "f");

        playerManager = new PlayerManager(area, new Player(), new GameIntegerPosition2D(1, 1));

        in = new Scanner(System.in);
        run = true;
    }
}
