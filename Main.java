import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import TheBadParodyToGame.ObjectsInArea.affectingToHP.Apple;
import TheBadParodyToGame.ObjectsInArea.affectingToHP.Fire;
import TheBadParodyToGame.ObjectsInArea.buildingMaterials.Stone;
import TheBadParodyToGame.ObjectsInArea.player.Player;
import TheBadParodyToGame.ObjectsInArea.player.PlayerDiedException;
import TheBadParodyToGame.area.abstractions.CheckeredAreaContainsAll;
import TheBadParodyToGame.area.position.GameIntegerPosition2D;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;
import TheBadParodyToGame.read.CheckeredAreaReader;
import TheBadParodyToGame.read.UnknownSymbolException;
import TheBadParodyToGame.visualization.AreaWithPlayerInCenterAdapter;
import TheBadParodyToGame.visualization.SimpleVisualizer;

public class Main {
    private static CheckeredAreaContainsAll area;
    private static SimpleVisualizer visualizer;
    private static Player player;
    private static Scanner in;
    private static boolean run;

    public static void main(String[] args) throws PositionException, IOException, UnknownSymbolException {
        initVariables();

        String input;
        while (run) {
            System.out.println(player.getHPString() + " - " + player.getName());
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
        area = CheckeredAreaReader.readArea("TheBadParodyToGame\\read\\StartLevel.txt");

        IntegerPosition2D startPos = new GameIntegerPosition2D(1, 1);
        player = new Player("Valera", area, startPos);

        visualizer = new SimpleVisualizer(new GameIntegerPosition2D(-20, -10),
                new GameIntegerPosition2D(20, 10),
                new AreaWithPlayerInCenterAdapter(area, player));
        HashMap<Class<?>, String> consoleVisualMap = visualizer.getConsoleVisualMap();
        consoleVisualMap.put(Player.class, "P");
        consoleVisualMap.put(Stone.class, "s");
        consoleVisualMap.put(Fire.class, "f");
        consoleVisualMap.put(Apple.class, "a");

        in = new Scanner(System.in);
        run = true;
    }
}
