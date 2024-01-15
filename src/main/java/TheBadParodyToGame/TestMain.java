package TheBadParodyToGame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.PositionException;
import TheBadParodyToGame.objectsInArea.movingObjects.player.Player;
import TheBadParodyToGame.objectsInArea.movingObjects.player.PlayerDiedException;
import TheBadParodyToGame.visualization.AreaWithPlayerInCenterAdapter;
import TheBadParodyToGame.visualization.WindowVisualizer;
import TheBadParodyToGame.writeRead.AreaReader;
import TheBadParodyToGame.writeRead.AreaWriteReader;
import TheBadParodyToGame.writeRead.UnknownSymbolException;

public class TestMain {
    private static AreaContainsAll area;
    private static WindowVisualizer visualizer;
    private static Player player;
    private static Scanner in;
    private static boolean run;
    private static AreaWriteReader writeReader;

    public static void main(String[] args) throws PositionException, IOException, UnknownSymbolException {
        initVariables();

        String input;
        while (run) {
            System.out.println(player.getHPString() + " - " + player.getName());
            visualizer.showArea();
            System.out.print("Use WASD to move and Q to quit: ");

            input = in.next();

            if (input.equals("q") || input.equals("Q")) {
                run = false;

                visualizer.closeWindow();

                File file = new File("TestRoom.json");
                file.createNewFile();
                FileWriter writer = new FileWriter(file);

                for (Position pos : area) {
                    writer.write(writeReader.convertPositionToString(pos));
                }

                writer.close();
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
        area = AreaReader.readArea("StartLevel.txt");

        Position startPos = new GamePosition(1, 1);
        player = new Player("Valera", area, startPos);

        visualizer = new WindowVisualizer(
                new AreaWithPlayerInCenterAdapter(area, player),
                new GamePosition(-20, -10),
                new GamePosition(20, 10),
                player);

        writeReader = new AreaWriteReader();
        in = new Scanner(System.in);
        run = true;
    }
}
