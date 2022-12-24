package TheBadParodyToGame.area;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

public interface CheckeredArea {
    /**
     * @param pos
     * @return object at this pos
     * @throws PositionException if pos is empty or can't exist in Area
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
     * @throws EmptyPositionException if pos is empty;
     * @throws PositionException      if pos can't exist in Area.
     */
    void place(IntegerPosition2D pos, ObjectInArea obj) throws PositionException;

    /**
     * Replace old object at pos to new assigned obj.
     * 
     * @param pos
     * @param obj
     * @throws EmptyPositionException if pos is empty;
     * @throws PositionException      if pos can't exist in Area.
     */
    void replace(IntegerPosition2D pos, ObjectInArea obj) throws PositionException;

    /**
     * Removes object from assigned pos.
     * 
     * @param pos
     * @throws EmptyPositionException if pos is empty;
     * @throws PositionException      if pos can't exist in Area.
     */
    void remove(IntegerPosition2D pos) throws PositionException;

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
