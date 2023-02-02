import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import TheBadParodyToGame.ObjectsInArea.Stone;
import TheBadParodyToGame.ObjectsInArea.fire.GameFire;
import TheBadParodyToGame.ObjectsInArea.player.Player;
import TheBadParodyToGame.ObjectsInArea.player.PlayerDiedException;
import TheBadParodyToGame.area.CheckeredArea;
import TheBadParodyToGame.area.position.GameIntegerPosition2D;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;
import TheBadParodyToGame.rooms.CheckeredAreaReader;
import TheBadParodyToGame.rooms.UnknownSymbolException;
import TheBadParodyToGame.visualizer.Visualizer;

public class Main {
    private static CheckeredArea area;
    private static Visualizer visualizer;
    private static Player player;
    private static Scanner in;
    private static boolean run;

    public static void main(String[] args) throws PositionException, IOException, UnknownSymbolException {
        initVariables();

        String input;
        while (run) {
            System.out.println(player);
            visualizer.showConsole();
            System.out.print("Use WASD to move and Q to quit:");

            input = in.next();

            if (input.equals("q") || input.equals("Q")) {
                run = false;
            }

            try {
                player.moveByDirections(input);
            } catch (PlayerDiedException e) {
                System.out.println("Game Over!");
                run = false;
            }
        }
    }

    private static void initVariables() throws PositionException, IOException, UnknownSymbolException {
        area = CheckeredAreaReader.readArea("TheBadParodyToGame\\rooms\\StartLevel.txt");

        visualizer = new Visualizer(new GameIntegerPosition2D(0, 0),
                new GameIntegerPosition2D(50, 30), area);
        HashMap<Class<?>, String> consoleVisualMap = visualizer.getConsoleVisualMap();
        consoleVisualMap.put(Player.class, "P");
        consoleVisualMap.put(Stone.class, "s");
        consoleVisualMap.put(GameFire.class, "f");

        IntegerPosition2D startPos = new GameIntegerPosition2D(1, 1);
        player = new Player("Valera", area, startPos);

        in = new Scanner(System.in);
        run = true;
    }
}
