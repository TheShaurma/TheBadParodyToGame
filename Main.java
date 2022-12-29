import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import TheBadParodyToGame.ObjectsInArea.Stone;
import TheBadParodyToGame.ObjectsInArea.fire.GameFire;
import TheBadParodyToGame.ObjectsInArea.player.Player;
import TheBadParodyToGame.ObjectsInArea.player.PlayerDiedException;
import TheBadParodyToGame.ObjectsInArea.player.PlayerManager;
import TheBadParodyToGame.area.CheckeredArea;
import TheBadParodyToGame.area.position.GameIntegerPosition2D;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;
import TheBadParodyToGame.rooms.CheckeredAreaReader;
import TheBadParodyToGame.rooms.CheckeredAreaSerializer;
import TheBadParodyToGame.rooms.UnknownSymbolException;
import TheBadParodyToGame.visualizer.Visualizer;

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
                playerManager.moveByDirections(input);
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
        consoleVisualMap.put(Player.class, "P");
        consoleVisualMap.put(Stone.class, "s");
        consoleVisualMap.put(GameFire.class, "f");

        IntegerPosition2D startPos = new GameIntegerPosition2D(1, 1);
        Player player = new Player();
        area.place(startPos, player);
        playerManager = new PlayerManager(startPos, area, player);

        in = new Scanner(System.in);
        run = true;
    }
}
