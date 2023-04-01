package TheBadParodyToGame.area.abstractions;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

/**
 * This is area, which can't be updated by user.
 */
public interface ConstantCheckeredArea<OBJ extends ObjectInArea> extends Iterable<IntegerPosition2D> {
    /**
     * @param pos
     * @return object at this {@code pos}
     * @throws EmptyPositionException             if {@code pos} is empty;
     * @throws PositionCannotExistInAreaException if {@code pos} can't exist in
     *                                            Area.
     */
    OBJ get(IntegerPosition2D pos) throws EmptyPositionException, PositionCannotExistInAreaException;

    /**
     * @param pos
     * @return if {@code pos} is empty
     */
    boolean positionIsEmpty(IntegerPosition2D pos) throws PositionCannotExistInAreaException;

    /**
     * @param pos
     * @return if {@code pos} is busy
     */
    boolean positionIsBusy(IntegerPosition2D pos) throws PositionCannotExistInAreaException;
}
