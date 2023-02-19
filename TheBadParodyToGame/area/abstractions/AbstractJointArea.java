package TheBadParodyToGame.area.abstractions;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.GameIntegerPosition2D;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

/**
 * You can add in this area all objects from other area.
 */
public abstract class AbstractJointArea<OBJ extends ObjectInArea> extends AbstractCheckeredArea<OBJ> {
    /**
     * Add ALL object from {@code area} in current area.
     * All positions from {@code area} will be converted:
     * {@code convertedPosX = upperLeftAnglePos.x + posInArea.x};
     * {@code convertedPosY = upperLeftAnglePos.y - posInArea.y}
     * 
     * If you will change {@code area} after, changes won't transferred if current
     * area.
     * 
     * @param upperLeftAnglePos
     * @param area
     * @throws PositionCannotExistInAreaException if pos can't exist if current or
     *                                            given area
     * @throws EmptyPositionException             if given area's iterator given
     *                                            empty position
     */
    public void addArea(IntegerPosition2D upperLeftAnglePos, ConstantCheckeredArea<OBJ> area)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        for (IntegerPosition2D posInArea : area) {
            int newX = upperLeftAnglePos.getX() + posInArea.getX();
            int newY = upperLeftAnglePos.getY() - posInArea.getY();
            IntegerPosition2D newPos = new GameIntegerPosition2D(newX, newY);
            OBJ obj = area.get(posInArea);

            set(newPos, obj);
        }
    }
}
