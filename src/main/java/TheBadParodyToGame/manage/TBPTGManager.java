package TheBadParodyToGame.manage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.Positions;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.area.position.exceptions.PositionException;
import TheBadParodyToGame.objectsInArea.CannotMoveObjectException;
import TheBadParodyToGame.objectsInArea.LostObjectException;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.DiedMobCannotMoveException;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.EnemyFollowsPlayer;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.EnemyMovesRandomly;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.ObjectWithAI;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.player.Player;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.player.PlayerDiedException;
import TheBadParodyToGame.visualization.AreaWithPlayerInCenterAdapter;
import TheBadParodyToGame.visualization.ConsoleVisualizer;
import TheBadParodyToGame.writeRead.AreaWriter;
import TheBadParodyToGame.writeRead.CannotFindFileException;
import TheBadParodyToGame.writeRead.GameAreaReader;
import TheBadParodyToGame.writeRead.InvalidFileException;

public class TBPTGManager implements Manager {
    private List<ObjectWithAI> allMobs;
    private Scanner in;
    private AreaContainsAll area;
    private Player player;
    private ConsoleVisualizer visualizer;
    private GameAreaReader areaReader;
    private AreaWriter<AreaContainsAll> areaWriter;

    @Override
    public void init()
            throws PositionException,
            IOException,
            CannotFindFileException,
            InvalidFileException {

        initVariables();
        placeEnemies(50);
    }

    @Override
    public void start()
            throws PositionCannotExistInAreaException,
            EmptyPositionException,
            LostObjectException,
            CannotMoveObjectException,
            IOException {

        for (;;) {
            visualizer.showGame();
            String input = getPlayerInput();

            if (input.equals("q") || input.equals("Q")) {
                break;
            }

            try {
                step(input);
            } catch (PlayerDiedException e) {
                System.out.println("Game Over!");
                break;
            }
        }

        areaWriter.writeArea();
        areaWriter.close();
    }

    @Override
    public void stop() {
    }

    private void step(String input)
            throws LostObjectException,
            CannotMoveObjectException,
            PositionCannotExistInAreaException,
            PlayerDiedException {

        player.moveByDirections(input);

        for (ObjectWithAI mob : allMobs) {
            try {
                mob.moveToStep();
            } catch (DiedMobCannotMoveException e) {
                System.out.println(String.format("%s died.", e.getObject()));
            }
        }

        player.checkAlive();
    }

    private String getPlayerInput() {
        System.out.print("Use WASD to move and Q to quit: ");
        return in.next();
    }

    private void initVariables()
            throws PositionException,
            IOException,
            CannotFindFileException,
            InvalidFileException {

        areaReader = new GameAreaReader();
        areaReader.setFileName("main-room");
        area = areaReader.readArea();

        Position startPos = new GamePosition(1, 1);
        player = new Player("Valera", area, startPos);
        area.place(startPos, player);

        visualizer = new ConsoleVisualizer(
                new AreaWithPlayerInCenterAdapter(area, player),
                new GamePosition(-20, -10),
                new GamePosition(20, 10),
                player);

        in = new Scanner(System.in);

        allMobs = new ArrayList<>();

        areaWriter = new AreaWriter<>();
        areaWriter.setFileName("main-room-after-game");
        areaWriter.setArea(area);
    }

    private void placeEnemies(int n)
            throws PositionCannotExistInAreaException {

        Position minPos = new GamePosition(0, 0);
        Position maxPos = new GamePosition(101, 29);
        for (int i = 0; i < n; i++) {
            Position pos = Positions.getRandomPosition(minPos, maxPos);
            try {
                var enemy = new EnemyMovesRandomly(area, pos, 40);

                area.place(pos, enemy);
                allMobs.add(enemy);
            } catch (BusyPositionException e) {
            }
        }

        for (int i = 1; i < n + 1; i++) {
            Position pos = Positions.getRandomPosition(minPos, maxPos);
            try {
                var enemy = new EnemyFollowsPlayer(area, pos, i, player);

                area.place(pos, enemy);
                allMobs.add(enemy);
            } catch (BusyPositionException e) {
            }
        }
    }

    public void addMob(ObjectWithAI mob) {
        allMobs.add(mob);
    }

    public void makeAllMobsStep()
            throws LostObjectException,
            CannotMoveObjectException,
            PositionCannotExistInAreaException {

        for (ObjectWithAI mob : allMobs) {
            mob.moveToStep();
        }
    }
}
