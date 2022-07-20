package game.ObjectsInArea.fire;

import java.util.Iterator;
import java.util.Vector;

import game.area.GameArea;
import game.area.IntegerPosition2D;
import game.area.PositionException;

public class FireManager {
    private Vector<IntegerPosition2D> firePositions;
    private Iterator<IntegerPosition2D> firePositionIterator;
    private IntegerPosition2D currentPosition;
    private GameArea area;
    private Fire fire = new Fire();

    public FireManager(GameArea area, Vector<IntegerPosition2D> firePositions) throws PositionException {
        this.firePositions = firePositions;
        firePositionIterator = firePositions.iterator();

        currentPosition = firePositionIterator.next();
        area.place(currentPosition, fire);
    }

    public void moveFire() throws PositionException, LostObjectException {
        if (!(area.get(currentPosition) == fire)) {
            throw new LostObjectException();
        }

        IntegerPosition2D newPosition;
        if (!firePositionIterator.hasNext()) {
            firePositionIterator = firePositions.iterator();
        }
        newPosition = firePositionIterator.next();

        moveFire(newPosition);
    }

    private void moveFire(IntegerPosition2D newPos) throws PositionException {
        area.relocate(currentPosition, newPos);
        currentPosition = newPos;
    }
}
