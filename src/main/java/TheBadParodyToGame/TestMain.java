package TheBadParodyToGame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.Positions;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.area.position.exceptions.PositionException;
import TheBadParodyToGame.objectsInArea.movingObjects.player.Player;
import TheBadParodyToGame.objectsInArea.movingObjects.player.PlayerDiedException;
import TheBadParodyToGame.objectsInArea.movingObjects.withAI.Enemy;
import TheBadParodyToGame.visualization.AreaWithPlayerInCenterAdapter;
import TheBadParodyToGame.visualization.ConsoleVisualizer;
import TheBadParodyToGame.visualization.WindowVisualizer;
import TheBadParodyToGame.writeRead.AreaReader;
import TheBadParodyToGame.writeRead.AreaWriteReader;
import TheBadParodyToGame.writeRead.UnknownSymbolException;

public class TestMain {
    private static AreaContainsAll area;
    private static ConsoleVisualizer visualizer;
    private static Player player;
    private static Scanner in;
    private static boolean run;
    private static AreaWriteReader writeReader;
    private static List<Enemy> enemies;

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

                // visualizer.closeWindow();

                File file = new File("TestRoom.json");
                file.createNewFile();
                FileWriter writer = new FileWriter(file);

                for (Position pos : area) {
                    writer.write(writeReader.convertPositionToString(pos));
                }

                writer.close();
            } else {
                try {
                    player.moveByDirections(input);
                } catch (PlayerDiedException e) {
                    System.out.println("Game Over!");
                    run = false;
                }

                for (Enemy enemy : enemies) {
                    enemy.moveToStep();
                }
            }
        }
    }

    private static void initVariables() throws PositionException, IOException, UnknownSymbolException {
        area = AreaReader.readArea("StartLevel.txt");

        Position startPos = new GamePosition(1, 1);
        player = new Player("Valera", area, startPos);

        visualizer = new ConsoleVisualizer(
                new AreaWithPlayerInCenterAdapter(area, player),
                new GamePosition(-20, -10),
                new GamePosition(20, 10));
        // player);

        writeReader = new AreaWriteReader();
        in = new Scanner(System.in);
        run = true;

        enemies = new ArrayList<>();

        placeEnemies(30);
    }

    private static void placeEnemies(int n) throws PositionCannotExistInAreaException {
        Position minPos = new GamePosition(0, 0);
        Position maxPos = new GamePosition(101, 29);
        for (int i = 0; i < n; i++) {
            Position pos = Positions.getRandomPosition(minPos, maxPos);
            try {
                Enemy enemy = new Enemy(area, pos);
                // area.place(pos, enemy);
                enemies.add(enemy);
            } catch (BusyPositionException e) {
                // System.out.println("kjsfad");
            }
        }
    }
}
