package TheBadParodyToGame.gameManagers;

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
import TheBadParodyToGame.objectsInArea.movingObjects.mobs.EnemyFollowingPlayer;
import TheBadParodyToGame.objectsInArea.movingObjects.mobs.EnemyMovesRandomly;
import TheBadParodyToGame.objectsInArea.movingObjects.mobs.Mob;
import TheBadParodyToGame.objectsInArea.movingObjects.player.Player;
import TheBadParodyToGame.objectsInArea.movingObjects.player.PlayerDiedException;
import TheBadParodyToGame.visualization.AreaWithPlayerInCenterAdapter;
import TheBadParodyToGame.visualization.ConsoleVisualizer;
import TheBadParodyToGame.writeRead.AreaReader;
import TheBadParodyToGame.writeRead.UnknownSymbolException;

public class GameManager {
    private List<Mob> allMobs;
    private Scanner in;
    private AreaContainsAll area;
    private Player player;
    private ConsoleVisualizer visualizer;

    public void start()
            throws PositionCannotExistInAreaException, EmptyPositionException,
            LostObjectException,
            CannotMoveObjectException {
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
    }

    private void step(String input)
            throws LostObjectException,
            CannotMoveObjectException,
            PositionCannotExistInAreaException,
            PlayerDiedException {

        player.moveByDirections(input);

        for (Mob mob : allMobs) {
            mob.moveToStep();
        }
    }

    private String getPlayerInput() {
        System.out.print("Use WASD to move and Q to quit: ");
        return in.next();
    }

    public void init()
            throws PositionException,
            IOException,
            UnknownSymbolException {
        initVariables();
        placeEnemies(50);
    }

    private void initVariables()
            throws PositionException,
            IOException,
            UnknownSymbolException {
        area = AreaReader.readArea("StartLevel.txt");

        Position startPos = new GamePosition(1, 1);
        player = new Player("Valera", area, startPos);

        visualizer = new ConsoleVisualizer(
                new AreaWithPlayerInCenterAdapter(area, player),
                new GamePosition(-20, -10),
                new GamePosition(20, 10),
                player);

        in = new Scanner(System.in);

        allMobs = new ArrayList<>();
    }

    private void placeEnemies(int n)
            throws PositionCannotExistInAreaException {
        Position minPos = new GamePosition(0, 0);
        Position maxPos = new GamePosition(101, 29);
        for (int i = 0; i < n; i++) {
            Position pos = Positions.getRandomPosition(minPos, maxPos);
            try {
                var enemy = new EnemyMovesRandomly(area, pos, 40);
                allMobs.add(enemy);
            } catch (BusyPositionException e) {
            }
        }

        for (int i = 0; i < n; i++) {
            Position pos = Positions.getRandomPosition(minPos, maxPos);
            try {
                var enemy = new EnemyFollowingPlayer(area, pos, i, player);
                allMobs.add(enemy);
            } catch (BusyPositionException e) {
            }
        }
    }

    public void addMob(Mob mob) {
        allMobs.add(mob);
    }

    public void makeAllMobsStep()
            throws LostObjectException,
            CannotMoveObjectException,
            PositionCannotExistInAreaException {
        for (Mob mob : allMobs) {
            mob.moveToStep();
        }
    }
}
