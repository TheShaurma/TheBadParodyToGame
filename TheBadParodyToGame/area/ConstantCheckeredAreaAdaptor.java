package TheBadParodyToGame.area;

import java.util.Iterator;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.abstractions.CheckeredAreaContainsAll;
import TheBadParodyToGame.area.abstractions.ConstantCheckeredAreaContainsAll;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

/**
 * This class is an adaptor for {@code CheckeredAreaContainsAll}.
 * When you create object of this class, you should give an area.
 * Created area will be taking information from given area.
 */
public class ConstantCheckeredAreaAdaptor implements ConstantCheckeredAreaContainsAll {
    private CheckeredAreaContainsAll area;

    /**
     * 
     * @param area
     */
    public ConstantCheckeredAreaAdaptor(CheckeredAreaContainsAll area) {
        this.area = area;
    }

    @Override
    public Iterator<IntegerPosition2D> iterator() {
        return area.iterator();
    }

    @Override
    public ObjectInArea get(IntegerPosition2D pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        return area.get(pos);
    }

    @Override
    public boolean positionIsEmpty(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        return area.positionIsEmpty(pos);
    }

    @Override
    public boolean positionIsBusy(IntegerPosition2D pos) throws PositionCannotExistInAreaException {
        return area.positionIsBusy(pos);
    }

}
