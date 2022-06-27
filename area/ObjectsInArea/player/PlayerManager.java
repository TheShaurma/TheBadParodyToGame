package area.ObjectsInArea.player;

import area.GameArea;
import area.IntegerPosition2D;
import area.PositionException;

public class PlayerManager {
    private Thread thread;
    private PlayerThread playerThread;

    public PlayerManager(GameArea area, Player player, IntegerPosition2D startPosition) throws PositionException {
        playerThread = new PlayerThread(area, player, startPosition);
        thread = new Thread(playerThread);
    }

    public void start() {
        thread.start();
    }

    public void stop() {

    }
}

class PlayerThread implements Runnable {
    private GameArea area;
    private IntegerPosition2D playerPosition;
    private boolean running;

    public PlayerThread(GameArea area, Player player, IntegerPosition2D startPosition) throws PositionException {
        this.area = area;
        playerPosition = startPosition;
        area.place(playerPosition, player);
    }

    @Override
    public void run() {
        running = true;

        while (running) {
            try {
                wait(40);
                movePlayerUp();
                wait(40);
                movePlayerRight();
                wait(40);
                movePlayerDown();
                wait(40);
                movePlayerLeft();
            } catch (PositionException | InterruptedException e) {
            }
        }
    }

    public void stop() {
        running = false;
    }

    private void movePlayerUp() throws PositionException {
        int newX = playerPosition.getX();
        int newY = playerPosition.getY();
        IntegerPosition2D newPosition = new IntegerPosition2D(newX, newY);

        area.relocate(playerPosition, newPosition);
        playerPosition = newPosition;
    }

    private void movePlayerDown() throws PositionException {
        int newX = playerPosition.getX();
        int newY = playerPosition.getY();
        IntegerPosition2D newPosition = new IntegerPosition2D(newX, newY);

        area.relocate(playerPosition, newPosition);
        playerPosition = newPosition;
    }

    private void movePlayerRight() throws PositionException {
        int newX = playerPosition.getX();
        int newY = playerPosition.getY();
        IntegerPosition2D newPosition = new IntegerPosition2D(newX, newY);

        area.relocate(playerPosition, newPosition);
        playerPosition = newPosition;
    }

    private void movePlayerLeft() throws PositionException {
        int newX = playerPosition.getX();
        int newY = playerPosition.getY();
        IntegerPosition2D newPosition = new IntegerPosition2D(newX, newY);

        area.relocate(playerPosition, newPosition);
        playerPosition = newPosition;
    }
}
