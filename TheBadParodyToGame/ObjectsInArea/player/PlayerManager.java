package TheBadParodyToGame.ObjectsInArea.player;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.RetryableErrorHandler;

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
     * 
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