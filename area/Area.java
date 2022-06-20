package area;

public interface Area<P extends Position2D<?>> {
    /**
     * @param pos
     * @return object at this pos
     * @throws PositionException if pos is empty or can't exist in Area
     */
    ObjectInArea get(P pos) throws PositionException;

    /**
     * Anyways place obj at pos.
     * 
     * @param pos
     * @param obj
     * @throws PositionException if pos can't exist in Area.
     */
    void set(P pos, ObjectInArea obj) throws PositionException;

    /**
     * Place obj at pos in Area
     * 
     * @param pos
     * @param obj
     * @throws PositionException if pos isn't empty or can't exist in Area.
     */
    void place(P pos, ObjectInArea obj) throws PositionException;

    /**
     * Replace object at pos to assigned obj.
     * 
     * @param pos
     * @param obj
     * @throws PositionException if pos is empty or can't exist in Area.
     */
    void replace(P pos, ObjectInArea obj) throws PositionException;

    /**
     * Removes object from assigned pos.
     * 
     * @param pos
     * @throws PositionException if pos is empty.
     */
    void remove(P pos) throws PositionException;

    /**
     * Relocate object from oldPos to newPos.
     * 
     * @param oldPos
     * @param newPos
     * @throws PositionException if oldPos is empty ot newPos isn't empty.
     */
    void relocate(P oldPos, P newPos) throws PositionException;

    boolean positionIsEmpty(IntegerPosition2D pos);

    boolean positionIsBusy(IntegerPosition2D pos);
}
