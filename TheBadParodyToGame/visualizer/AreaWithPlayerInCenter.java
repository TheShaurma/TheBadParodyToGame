package TheBadParodyToGame.visualizer;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.ObjectsInArea.player.Player;
import TheBadParodyToGame.area.GameArea;
import TheBadParodyToGame.area.position.GameIntegerPosition2D;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

/**
 * Like GameArea, but player always in [0; 0] coordinates.
 */
public class AreaWithPlayerInCenter extends GameArea {
    private Player player;

    public AreaWithPlayerInCenter(Player player) {
        this.player = player;
    }

    @Override
    public ObjectInArea get(IntegerPosition2D pos) throws PositionException {
        return super.get(convertPos(pos));
    }

    @Override
    public void set(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        super.set(convertPos(pos), obj);
    }

    @Override
    public void place(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        super.place(convertPos(pos), obj);
    }

    @Override
    public void tryPlace(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        super.tryPlace(convertPos(pos), obj);
    }

    @Override
    public void replace(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        super.replace(convertPos(pos), obj);
    }

    @Override
    public void tryReplace(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        super.tryReplace(convertPos(pos), obj);
    }

    @Override
    public void remove(IntegerPosition2D pos) throws PositionException {
        super.remove(convertPos(pos));
    }

    @Override
    public void tryRemove(IntegerPosition2D pos) throws PositionException {
        super.tryRemove(convertPos(pos));
    }

    @Override
    public void relocate(IntegerPosition2D oldPos, IntegerPosition2D newPos) throws PositionException {
        super.relocate(convertPos(oldPos), convertPos(newPos));
    }

    @Override
    public void tryRelocate(IntegerPosition2D oldPos, IntegerPosition2D newPos) throws PositionException {
        super.tryRelocate(convertPos(oldPos), convertPos(newPos));
    }

    @Override
    public boolean positionIsEmpty(IntegerPosition2D pos) {
        return super.positionIsEmpty(convertPos(pos));
    }

    @Override
    public boolean positionIsBusy(IntegerPosition2D pos) {
        return super.positionIsBusy(convertPos(pos));
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
