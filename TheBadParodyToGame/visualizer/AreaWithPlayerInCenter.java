package TheBadParodyToGame.visualizer;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.ObjectsInArea.player.Player;
import TheBadParodyToGame.area.CheckeredArea;
import TheBadParodyToGame.area.position.GameIntegerPosition2D;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

/**
 * Like GameArea, but player always in [0; 0] coordinates.
 */
public class AreaWithPlayerInCenter implements CheckeredArea {
    private CheckeredArea areaItself;
    private Player player;

    public AreaWithPlayerInCenter(CheckeredArea area, Player player) {
        areaItself = area;
        this.player = player;
    }

    @Override
    public ObjectInArea get(IntegerPosition2D pos) throws PositionException {
        return areaItself.get(convertPos(pos));
    }

    @Override
    public void set(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        areaItself.set(convertPos(pos), obj);
    }

    @Override
    public void place(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        areaItself.place(convertPos(pos), obj);
    }

    @Override
    public void tryPlace(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        areaItself.tryPlace(convertPos(pos), obj);
    }

    @Override
    public void replace(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        areaItself.replace(convertPos(pos), obj);
    }

    @Override
    public void tryReplace(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        areaItself.tryReplace(convertPos(pos), obj);
    }

    @Override
    public void remove(IntegerPosition2D pos) throws PositionException {
        areaItself.remove(convertPos(pos));
    }

    @Override
    public void tryRemove(IntegerPosition2D pos) throws PositionException {
        areaItself.tryRemove(convertPos(pos));
    }

    @Override
    public void relocate(IntegerPosition2D oldPos, IntegerPosition2D newPos) throws PositionException {
        areaItself.relocate(convertPos(oldPos), convertPos(newPos));
    }

    @Override
    public void tryRelocate(IntegerPosition2D oldPos, IntegerPosition2D newPos) throws PositionException {
        areaItself.tryRelocate(convertPos(oldPos), convertPos(newPos));
    }

    @Override
    public boolean positionIsEmpty(IntegerPosition2D pos) {
        return areaItself.positionIsEmpty(convertPos(pos));
    }

    @Override
    public boolean positionIsBusy(IntegerPosition2D pos) {
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
