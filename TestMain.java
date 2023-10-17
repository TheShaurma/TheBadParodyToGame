import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import TheBadParodyToGame.ObjectsInArea.affectingToHP.Apple;
import TheBadParodyToGame.ObjectsInArea.affectingToHP.Fire;
import TheBadParodyToGame.ObjectsInArea.buildingMaterials.Stone;
import TheBadParodyToGame.ObjectsInArea.player.Player;
import TheBadParodyToGame.ObjectsInArea.player.PlayerDiedException;
import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionException;
import TheBadParodyToGame.read.AreaReader;
import TheBadParodyToGame.read.UnknownSymbolException;
import TheBadParodyToGame.visualization.AreaWithPlayerInCenterAdapter;
import TheBadParodyToGame.visualization.SimpleVisualizer;

public class TestMain {
    private static AreaContainsAll area;
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
        area = AreaReader.readArea("TheBadParodyToGame\\read\\StartLevel.txt");

        Position startPos = new GamePosition(1, 1);
        player = new Player("Valera", area, startPos);

        visualizer = new SimpleVisualizer(new GamePosition(-20, -10),
                new GamePosition(20, 10),
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
