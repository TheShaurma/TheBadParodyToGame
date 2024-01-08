package TheBadParodyToGame.area.withBorders;

import TheBadParodyToGame.area.AreaChecksPosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.area.position.exceptions.PositionOutOfBordersException;
import TheBadParodyToGame.area.withBorders.borders.Borders;
import TheBadParodyToGame.objectsInArea.ObjectInArea;

/**
 * Object of class contains borders.
 * Always when you call main methods (get, set, place and other...)
 * check wether position in borders.
 * If not, throw PositionOutOfBordersException.
 */
public abstract class AreaWithBorders<OBJ extends ObjectInArea>
        extends AreaChecksPosition<OBJ>
        implements ConstantAreaWithBorders<OBJ> {
    private final Borders borders;

    public AreaWithBorders(Borders borders) {
        this.borders = borders;
    }

    @Override
    public Borders getBorders() {
        return borders;
    }

    @Override
    protected void checkPosition(Position pos) throws PositionCannotExistInAreaException {
        int x = pos.getX();
        int y = pos.getY();
        Borders borders = getBorders();

        if (!(x >= borders.getXMin() &&
                x <= borders.getXMax() &&
                y >= borders.getYMin() &&
                y <= borders.getYMax())) {
            throw new PositionOutOfBordersException(pos);
        }
    }
}
