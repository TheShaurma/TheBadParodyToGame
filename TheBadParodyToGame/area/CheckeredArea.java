package TheBadParodyToGame.area;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

// TODO: PositionException is abstraction it can't be thrown
// TODO: replace PositionException to PositionCannotExistException in javadocs
public interface CheckeredArea {
    /**
     * @param pos
     * @return object at this pos
     * @throws EmptyPositionException if pos is empty;
     * @throws PositionException      if pos can't exist in Area.
     */
    ObjectInArea get(IntegerPosition2D pos) throws PositionException;

    /**
     * Anyways place obj at pos.
     * 
     * @param pos
     * @param obj
     * @throws PositionException if pos can't exist in Area.
     */
    void set(IntegerPosition2D pos, ObjectInArea obj) throws PositionException;

    /**
     * Place obj at pos in Area
     * 
     * @param pos
     * @param obj
     * @throws BusyPositionException if pos is busy;
     * @throws PositionException     if pos can't exist in Area.
     */
    void place(IntegerPosition2D pos, ObjectInArea obj) throws PositionException;

    // TODO: create tryPlace(pos, obj): place, if pos is busy nothing will happen

    /**
     * Replace old object at pos to new assigned obj.
     * 
     * @param pos
     * @param obj
     * @throws EmptyPositionException if pos is empty;
     * @throws PositionException      if pos can't exist in Area.
     */
    void replace(IntegerPosition2D pos, ObjectInArea obj) throws PositionException;
    // TODO: create tryReplace(pos, obj): if pos is empty, nothing will happen

    /**
     * Removes object from assigned pos.
     * 
     * @param pos
     * @throws EmptyPositionException if pos is empty;
     * @throws PositionException      if pos can't exist in Area.
     */
    void remove(IntegerPosition2D pos) throws PositionException;
    // TODO: create tryRemove(pos): if pos is empty, nothing will happen

    /**
     * Relocate object from oldPos to newPos.
     * 
     * @param oldPos
     * @param newPos
     * @throws EmptyPositionException if oldPos is empty;
     * @throws BusyPositionException  newPos is busy;
     *                                If oldPos is empty and newPos is Busy
     *                                synchronically, throws EmptyPositionException
     * @throws PositionException      if oldPos or newPos can't exist in Area.
     */
    void relocate(IntegerPosition2D oldPos, IntegerPosition2D newPos) throws PositionException;

    // TODO: create tryRelocate(oldPos, newPos): if oldPos is empty or/end newPos is
    // busy, nothing will happen

    /**
     * @param pos
     * @return if position is empty
     */
    boolean positionIsEmpty(IntegerPosition2D pos);

    /**
     * @param pos
     * @return if position is busy
     */
    boolean positionIsBusy(IntegerPosition2D pos);
}
