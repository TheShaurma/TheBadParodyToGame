package TheBadParodyToGame.area;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

public interface ConstantArea<OBJ extends ObjectInArea> {
    /**
     * @param pos
     * @return object at this {@code pos}
     * @throws EmptyPositionException             if {@code pos} is empty;
     * @throws PositionCannotExistInAreaException if {@code pos} can't exist in
     *                                            Area.
     */
    OBJ get(Position pos) throws EmptyPositionException, PositionCannotExistInAreaException;

    /**
     * @param pos
     * @return if {@code pos} is empty
     */
    boolean positionIsEmpty(Position pos) throws PositionCannotExistInAreaException;

    /**
     * @param pos
     * @return if {@code pos} is busy
     */
    boolean positionIsBusy(Position pos) throws PositionCannotExistInAreaException;
}
