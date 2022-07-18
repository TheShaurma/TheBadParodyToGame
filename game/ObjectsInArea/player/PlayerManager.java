package game.ObjectsInArea.player;

import game.area.GameArea;
import game.area.IntegerPosition2D;
import game.area.PositionException;

public class PlayerManager {
    private GameArea area;
    private IntegerPosition2D playerPosition;

    public PlayerManager(GameArea area, Player player, IntegerPosition2D startPlayerPosition) throws PositionException {
        area.place(startPlayerPosition, player);
        this.area = area;
        playerPosition = startPlayerPosition;
    }

    // TODO: move methods should be private in future
    public void movePlayerUp() throws PositionException {
        int newX = playerPosition.getX();
        int newY = playerPosition.getY() + 1;
        IntegerPosition2D newPosition = new IntegerPosition2D(newX, newY);

        area.relocate(playerPosition, newPosition);
        playerPosition = newPosition;
    }

    public void movePlayerDown() throws PositionException {
        int newX = playerPosition.getX();
        int newY = playerPosition.getY() - 1;
        IntegerPosition2D newPosition = new IntegerPosition2D(newX, newY);

        area.relocate(playerPosition, newPosition);
        playerPosition = newPosition;
    }

    public void movePlayerRight() throws PositionException {
        int newX = playerPosition.getX() + 1;
        int newY = playerPosition.getY();
        IntegerPosition2D newPosition = new IntegerPosition2D(newX, newY);

        area.relocate(playerPosition, newPosition);
        playerPosition = newPosition;
    }

    public void movePlayerLeft() throws PositionException {
        int newX = playerPosition.getX() - 1;
        int newY = playerPosition.getY();
        IntegerPosition2D newPosition = new IntegerPosition2D(newX, newY);

        area.relocate(playerPosition, newPosition);
        playerPosition = newPosition;
    }

}