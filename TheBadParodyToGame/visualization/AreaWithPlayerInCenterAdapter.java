package TheBadParodyToGame.visualization;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.ObjectsInArea.player.Player;
import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.GameIntegerPosition2D;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

/**
 * Like GameArea, but player always in [0; 0] coordinates.
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
    public ObjectInArea get(IntegerPosition2D pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        return areaItself.get(convertPos(pos));
    }

    @Override
    public void set(IntegerPosition2D pos, ObjectInArea obj) throws PositionCannotExistInAreaException {
        areaItself.set(convertPos(pos), obj);
    }

    @Override
    public void place(IntegerPosition2D pos, ObjectInArea obj)
            throws BusyPositionException, PositionCannotExistInAreaException {
        areaItself.place(convertPos(pos), obj);
    }

    @Override
    public void tryPlace(IntegerPosition2D pos, ObjectInArea obj) throws PositionCannotExistInAreaException {
        areaItself.tryPlace(convertPos(pos), obj);
    }

    @Override
    public void replace(IntegerPosition2D pos, ObjectInArea obj)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        areaItself.replace(convertPos(pos), obj);
    }

    @Override
    public void tryReplace(IntegerPosition2D pos, ObjectInArea obj) throws PositionCannotExistInAreaException {
        areaItself.tryReplace(convertPos(pos), obj);
    }

    @Override
    public void remove(IntegerPosition2D pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        areaItself.remove(convertPos(pos));
    }

    @Override
    public void tryRemove(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        areaItself.tryRemove(convertPos(pos));
    }

    @Override
    public void relocate(IntegerPosition2D oldPos, IntegerPosition2D newPos)
            throws EmptyPositionException, BusyPositionException, PositionCannotExistInAreaException {
        areaItself.relocate(convertPos(oldPos), convertPos(newPos));
    }

    @Override
    public void tryRelocate(IntegerPosition2D oldPos, IntegerPosition2D newPos)
            throws PositionCannotExistInAreaException {
        areaItself.tryRelocate(convertPos(oldPos), convertPos(newPos));
    }

    @Override
    public void relocateToEverywhere(IntegerPosition2D oldPos, IntegerPosition2D newPos)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        areaItself.relocateToEverywhere(convertPos(oldPos), convertPos(newPos));
    }

    @Override
    public boolean positionIsEmpty(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        return areaItself.positionIsEmpty(convertPos(pos));
    }

    @Override
    public boolean positionIsBusy(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        return areaItself.positionIsBusy(convertPos(pos));
    }

    protected Player getPlayer() {
        return player;
    }

    protected IntegerPosition2D convertPos(IntegerPosition2D pos) {
        IntegerPosition2D playerPosition = getPlayer().getPos();
        int playerX = playerPosition.getX();
        int playerY = playerPosition.getY();
        IntegerPosition2D convertedPos = new GameIntegerPosition2D(playerX + pos.getX(), playerY + pos.getY());

        return convertedPos;
    }

}
