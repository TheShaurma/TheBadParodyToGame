package TheBadParodyToGame.area;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

public interface CheckeredArea<OBJ extends ObjectInArea> {
    /**
     * @param pos
     * @return object at this {@code pos}
     * @throws EmptyPositionException             if {@code pos} is empty;
     * @throws PositionCannotExistInAreaException if {@code pos} can't exist in
     *                                            Area.
     */
    OBJ get(IntegerPosition2D pos) throws EmptyPositionException, PositionCannotExistInAreaException;

    /**
     * Anyways place {@code obj} at {@code pos}.
     * 
     * @param pos
     * @param obj
     * @throws PositionCannotExistInAreaException if {@code pos} can't exist in
     *                                            Area.
     */
    void set(IntegerPosition2D pos, OBJ obj) throws PositionCannotExistInAreaException;

    /**
     * Place {@code obj} at {@code pos} in Area
     * 
     * @param pos
     * @param obj
     * @throws BusyPositionException              if {@code pos} is busy;
     * @throws PositionCannotExistInAreaException if {@code pos} can't exist in
     *                                            Area.
     */
    void place(IntegerPosition2D pos, OBJ obj) throws BusyPositionException, PositionCannotExistInAreaException;

    /**
     * If {@code pos} is busy, nothing will happen,
     * else place {@code obj} at {@code pos} in Area.
     * 
     * @param pos
     * @param obj
     * @throws PositionCannotExistInAreaException if pos can't exist in Area.
     */
    void tryPlace(IntegerPosition2D pos, OBJ obj) throws PositionCannotExistInAreaException;

    /**
     * Replace old object at {@code pos} to new assigned {@code obj}.
     * 
     * @param pos
     * @param obj
     * @throws EmptyPositionException             if {@code pos} is empty;
     * @throws PositionCannotExistInAreaException if {@code pos} can't exist in
     *                                            Area.
     */
    void replace(IntegerPosition2D pos, OBJ obj) throws EmptyPositionException, PositionCannotExistInAreaException;

    /**
     * If {@code pos} is empty do nothing, else replace old object at {@code pos} to
     * new assigned {@code obj}.
     * 
     * @param pos
     * @param obj
     * @throws PositionCannotExistInAreaException if {@code pos} can't exist in
     *                                            Area.
     */
    void tryReplace(IntegerPosition2D pos, OBJ obj) throws PositionCannotExistInAreaException;

    /**
     * Removes object from assigned {@code pos}.
     * 
     * @param pos
     * @throws EmptyPositionException             if {@code pos} is empty;
     * @throws PositionCannotExistInAreaException if {@code pos} can't exist in
     *                                            Area.
     */
    void remove(IntegerPosition2D pos) throws EmptyPositionException, PositionCannotExistInAreaException;

    /**
     * If {@code pos} is empty, nothing will happen,
     * else remove object from assigned {@code pos}.
     * 
     * @param pos
     * @throws PositionCannotExistInAreaException if {@code pos} can't exist in
     *                                            Area.
     */
    void tryRemove(IntegerPosition2D pos) throws PositionCannotExistInAreaException;

    /**
     * Relocate object from {@code oldPos} to {@code newPos}.
     * 
     * @param oldPos
     * @param newPos
     * @throws EmptyPositionException             if {@code oldPos} is empty;
     * @throws BusyPositionException              {@code newPos} is busy;
     *                                            If {@code oldPos} is empty and
     *                                            {@code newPos}
     *                                            is Busy
     *                                            synchronically, throws
     *                                            {@code EmptyPositionException}
     * @throws PositionCannotExistInAreaException if {@code oldPos} or
     *                                            {@code newPos} can't
     *                                            exist in Area.
     */
    void relocate(IntegerPosition2D oldPos, IntegerPosition2D newPos)
            throws EmptyPositionException, BusyPositionException, PositionCannotExistInAreaException;

    /**
     * If {@code oldPos} is empty or/and {@code newPos} is busy nothing will happen,
     * else relocate object from {@code oldPos} to {@code newPos}.
     * 
     * @param oldPos
     * @param newPos
     * @throws PositionCannotExistInAreaException if {@code oldPos} or
     *                                            {@code newPos} can't
     *                                            exist in Area.
     */
    void tryRelocate(IntegerPosition2D oldPos, IntegerPosition2D newPos) throws PositionCannotExistInAreaException;

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
