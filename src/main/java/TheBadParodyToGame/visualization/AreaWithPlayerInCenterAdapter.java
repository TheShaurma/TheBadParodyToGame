package TheBadParodyToGame.visualization;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.ObjectInArea;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.player.Player;

/**
 * Like GameArea, but player always in (0; 0) coordinates.
 * 
 * Used only for visualization. That's why this class isn't in area package.
 */
public class AreaWithPlayerInCenterAdapter implements AreaContainsAll {
    private AreaContainsAll areaItself;
    private Player player;

    public AreaWithPlayerInCenterAdapter(AreaContainsAll area, Player player) {
        areaItself = area;
        this.player = player;
    }

    @Override
    public ObjectInArea get(Position pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        return areaItself.get(convertPos(pos));
    }

    @Override
    public void set(Position pos, ObjectInArea obj) throws PositionCannotExistInAreaException {
        areaItself.set(convertPos(pos), obj);
    }

    @Override
    public void place(Position pos, ObjectInArea obj)
            throws BusyPositionException, PositionCannotExistInAreaException {
        areaItself.place(convertPos(pos), obj);
    }

    @Override
    public void tryPlace(Position pos, ObjectInArea obj) throws PositionCannotExistInAreaException {
        areaItself.tryPlace(convertPos(pos), obj);
    }

    @Override
    public void replace(Position pos, ObjectInArea obj)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        areaItself.replace(convertPos(pos), obj);
    }

    @Override
    public void tryReplace(Position pos, ObjectInArea obj) throws PositionCannotExistInAreaException {
        areaItself.tryReplace(convertPos(pos), obj);
    }

    @Override
    public void remove(Position pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        areaItself.remove(convertPos(pos));
    }

    @Override
    public void tryRemove(Position pos) throws PositionCannotExistInAreaException {
        areaItself.tryRemove(convertPos(pos));
    }

    @Override
    public void relocate(Position oldPos, Position newPos)
            throws EmptyPositionException, BusyPositionException, PositionCannotExistInAreaException {
        areaItself.relocate(convertPos(oldPos), convertPos(newPos));
    }

    @Override
    public void tryRelocate(Position oldPos, Position newPos)
            throws PositionCannotExistInAreaException {
        areaItself.tryRelocate(convertPos(oldPos), convertPos(newPos));
    }

    @Override
    public void relocateToEverywhere(Position oldPos, Position newPos)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        areaItself.relocateToEverywhere(convertPos(oldPos), convertPos(newPos));
    }

    @Override
    public boolean positionIsEmpty(Position pos) throws PositionCannotExistInAreaException {
        return areaItself.positionIsEmpty(convertPos(pos));
    }

    @Override
    public boolean positionIsBusy(Position pos) throws PositionCannotExistInAreaException {
        return areaItself.positionIsBusy(convertPos(pos));
    }

    protected Player getPlayer() {
        return player;
    }

    protected Position convertPos(Position pos) {
        Position playerPosition = getPlayer().getPos();
        int playerX = playerPosition.getX();
        int playerY = playerPosition.getY();
        Position convertedPos = new GamePosition(playerX + pos.getX(), playerY + pos.getY());

        return convertedPos;
    }

    @Override
    public Iterable<Position> getAllBusyPositions() {
        return areaItself.getAllBusyPositions();
    }

    @Override
    public Iterable<ObjectInArea> getAllObjects() {
        return areaItself.getAllObjects();
    }
}
