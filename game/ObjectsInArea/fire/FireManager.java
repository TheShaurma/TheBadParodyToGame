package game.ObjectsInArea.fire;

import java.util.Iterator;
import java.util.Vector;

import game.ObjectsInArea.LostObjectException;
import game.area.CheckeredArea;
import game.area.position.IntegerPosition2D;
import game.area.position.PositionException;

/**
 * FireManager manage one "Fire" object in area.
 */
public class FireManager {
    private Vector<IntegerPosition2D> firePositions;
    private Iterator<IntegerPosition2D> firePositionIterator;
    private IntegerPosition2D currentPosition;
    private CheckeredArea area;
    private Fire fire;

    /**
     * When you create FireManager you should give it CheckeredArea where "Fire"
     * object
     * will be and Vector with all position where fire will be.
     * FireManager will create "Fire" object itself on first position of assigned
     * vector in area.
     * 
     * @param area
     * @param firePositions
     * @throws PositionException if can't place object on first position.
     *                           {@code area.place<firstFirePosition, fire)}
     */
    public FireManager(CheckeredArea area, Fire fire, Vector<IntegerPosition2D> firePositions)
            throws PositionException {
        this.firePositions = firePositions;
        firePositionIterator = firePositions.iterator();

        currentPosition = firePositionIterator.next();
        area.place(currentPosition, fire);
    }

    /**
     * Move fire to next position in "firePositions" vector.
     * 
     * @throws PositionException   if next position isn't empty or isn't valid.
     * @throws LostObjectException if Fire isn't at current position.
     */
    public void moveFire() throws PositionException, LostObjectException {
        if (!(area.get(currentPosition) == fire)) {
            throw new LostObjectException(currentPosition, fire);
        }

        IntegerPosition2D newPosition = getNextPosition();

        moveFire(newPosition);
    }

    private void moveFire(IntegerPosition2D newPos) throws PositionException {
        area.relocate(currentPosition, newPos);
        currentPosition = newPos;
    }

    private IntegerPosition2D getNextPosition() {
        IntegerPosition2D nextPos;
        if (!firePositionIterator.hasNext()) {
            firePositionIterator = firePositions.iterator();
        }
        nextPos = firePositionIterator.next();

        return nextPos;
    }
}
