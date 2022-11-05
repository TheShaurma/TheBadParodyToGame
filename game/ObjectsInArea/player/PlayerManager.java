package game.ObjectsInArea.player;

import game.ObjectsInArea.fire.Fire;
import game.area.CheckeredArea;
import game.area.position.BusyPositionException;
import game.area.position.GameIntegerPosition2D;
import game.area.position.IntegerPosition2D;
import game.area.position.PositionException;

public class PlayerManager {
    private CheckeredArea area;
    private IntegerPosition2D playerPosition;

    private final static Class<?> fireClass = new Fire().getClass();

    public PlayerManager(CheckeredArea area, Player player, IntegerPosition2D startPlayerPosition)
            throws PositionException {
        area.place(startPlayerPosition, player);
        this.area = area;
        playerPosition = startPlayerPosition;
    }

    // TODO: move methods should be private in future
    public void movePlayerUp() throws PositionException, PlayerDiedException {
        int newX = playerPosition.getX();
        int newY = playerPosition.getY() + 1;
        IntegerPosition2D newPosition = new GameIntegerPosition2D(newX, newY);

        movePlayerToPosition(newPosition);
    }

    public void movePlayerDown() throws PositionException, PlayerDiedException {
        int newX = playerPosition.getX();
        int newY = playerPosition.getY() - 1;
        IntegerPosition2D newPosition = new GameIntegerPosition2D(newX, newY);

        movePlayerToPosition(newPosition);
    }

    public void movePlayerRight() throws PositionException, PlayerDiedException {
        int newX = playerPosition.getX() + 1;
        int newY = playerPosition.getY();
        IntegerPosition2D newPosition = new GameIntegerPosition2D(newX, newY);

        movePlayerToPosition(newPosition);
    }

    public void movePlayerLeft() throws PositionException, PlayerDiedException {
        int newX = playerPosition.getX() - 1;
        int newY = playerPosition.getY();
        IntegerPosition2D newPosition = new GameIntegerPosition2D(newX, newY);

        movePlayerToPosition(newPosition);
    }

    private void movePlayerToPosition(IntegerPosition2D newPos) throws PositionException, PlayerDiedException {
        try {
            area.relocate(playerPosition, newPos);
            playerPosition = newPos;
        } catch (BusyPositionException e) {
            if (area.get(newPos).getClass() == fireClass) {
                area.remove(playerPosition);
                throw new PlayerDiedException();
            }
        }
    }
}