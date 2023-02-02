package TheBadParodyToGame.area;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

// TODO: PositionException is abstraction, it can't be thrown
// TODO: replace PositionException to PositionCannotExistException in javadocs
public interface CheckeredArea {
    /**
     * @param pos
     * @return object at this {@code pos}
     * @throws EmptyPositionException if {@code pos} is empty;
     * @throws PositionException      if {@code pos} can't exist in Area.
     */
    ObjectInArea get(IntegerPosition2D pos) throws PositionException;

    /**
     * Anyways place {@code obj} at {@code pos}.
     * 
     * @param pos
     * @param obj
     * @throws PositionException if {@code pos} can't exist in Area.
     */
    void set(IntegerPosition2D pos, ObjectInArea obj) throws PositionException;

    /**
     * Place {@code obj} at {@code pos} in Area
     * 
     * @param pos
     * @param obj
     * @throws BusyPositionException if {@code pos} is busy;
     * @throws PositionException     if {@code pos} can't exist in Area.
     */
    void place(IntegerPosition2D pos, ObjectInArea obj) throws PositionException;

    /**
     * If {@code pos} is busy, nothing will happen,
     * else place {@code obj} at {@code pos} in Area.
     * 
     * @param pos
     * @param obj
     * @throws PositionException if pos can't exist in Area.
     */

    default public void tryPlace(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        if (positionIsEmpty(pos)) {
            place(pos, obj);
        }
    }

    /**
     * Replace old object at {@code pos} to new assigned {@code obj}.
     * 
     * @param pos
     * @param obj
     * @throws EmptyPositionException if {@code pos} is empty;
     * @throws PositionException      if {@code pos} can't exist in Area.
     */
    void replace(IntegerPosition2D pos, ObjectInArea obj) throws PositionException;

    /**
     * If {@code pos} is empty do nothing, else replace old object at {@code pos} to
     * new assigned {@code obj}.
     * 
     * @param pos
     * @param obj
     * @throws PositionException if {@code pos} can't exist in Area.
     */
    default public void tryReplace(IntegerPosition2D pos, ObjectInArea obj) throws PositionException {
        if (positionIsBusy(pos)) {
            replace(pos, obj);
        }
    }

    /**
     * Removes object from assigned {@code pos}.
     * 
     * @param pos
     * @throws EmptyPositionException if {@code pos} is empty;
     * @throws PositionException      if {@code pos} can't exist in Area.
     */
    void remove(IntegerPosition2D pos) throws PositionException;

    /**
     * If {@code pos} is empty, nothing will happen,
     * else remove object from assigned {@code pos}.
     * 
     * @param pos
     * @throws PositionException if {@code pos} can't exist in Area.
     */
    default public void tryRemove(IntegerPosition2D pos) throws PositionException {
        if (positionIsBusy(pos)) {
            remove(pos);
        }
    }

    /**
     * Relocate object from {@code oldPos} to {@code newPos}.
     * 
     * @param oldPos
     * @param newPos
     * @throws EmptyPositionException if {@code oldPos} is empty;
     * @throws BusyPositionException  {@code newPos} is busy;
     *                                If {@code oldPos} is empty and {@code newPos}
     *                                is Busy
     *                                synchronically, throws
     *                                {@code EmptyPositionException}
     * @throws PositionException      if {@code oldPos} or {@code newPos} can't
     *                                exist in Area.
     */
    void relocate(IntegerPosition2D oldPos, IntegerPosition2D newPos) throws PositionException;

    /**
     * If {@code oldPos} is empty or/and {@code newPos} is busy nothing will happen,
     * else relocate object from {@code oldPos} to {@code newPos}.
     * 
     * @param oldPos
     * @param newPos
     * @throws PositionException if {@code oldPos} or {@code newPos} can't
     *                           exist in Area.
     */
    default public void tryRelocate(IntegerPosition2D oldPos, IntegerPosition2D newPos) throws PositionException {
        if (positionIsBusy(oldPos) && positionIsEmpty(newPos)) {
            relocate(oldPos, newPos);
        }
    }

    /**
     * @param pos
     * @return if {@code pos} is empty
     */
    boolean positionIsEmpty(IntegerPosition2D pos);

    /**
     * @param pos
     * @return if {@code pos} is busy
     */
    boolean positionIsBusy(IntegerPosition2D pos);
}
