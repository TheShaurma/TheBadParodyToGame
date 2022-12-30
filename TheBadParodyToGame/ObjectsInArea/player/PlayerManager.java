package TheBadParodyToGame.ObjectsInArea.player;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.ObjectsInArea.ObjectManager;
import TheBadParodyToGame.ObjectsInArea.fire.Fire;
import TheBadParodyToGame.area.CheckeredArea;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

public class PlayerManager extends ObjectManager {

    public PlayerManager(IntegerPosition2D pos, CheckeredArea area, ObjectInArea obj) throws PositionException {
        super(pos, area, obj);
    }

    /**
     * Takes string and iterate it.
     * w or W — move player up;
     * s ot S — move player down;
     * a or A — move player left;
     * d or D — move player right;
     * 
     * @param directions
     * @throws PositionException if moving has problems.
     */
    public void moveByDirections(String directions) throws PositionException {
        for (int i = 0; i < directions.length(); i++) {
            char d = directions.charAt(i);

            if (d == 'w' || d == 'W') {
                moveObjectUp();
            } else if (d == 's' || d == 'S') {
                moveObjectDown();
            } else if (d == 'a' || d == 'A') {
                moveObjectLeft();
            } else if (d == 'd' || d == 'D') {
                moveObjectRight();
            }
        }
    }

    /**
     * Move object to assigned position in checkered area.
     * 
     * If in {@code newPos} has a place a Fire, player will die (PlayerDiedException
     * will be thrawn).
     * 
     * @param pos
     * @throws LostObjectException       if obj isn't in pos;
     * @throws CannotMoveObjectException if position where object should be after
     *                                   moving is busy;
     * @throws PlayerDiedException       if player died;
     */
    @Override
    protected void moveObjectToPosition(IntegerPosition2D newPos) throws PositionException {
        CheckeredArea area = getArea();

        if (area.positionIsBusy(newPos)) {
            if (area.get(newPos).getClass() == Fire.class) {
                throw new PlayerDiedException(newPos);
            } else {
                return;
            }
        }

        super.moveObjectToPosition(newPos);
    }
}