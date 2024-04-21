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
public abstract class AbstractAreaWithBorders<OBJ extends ObjectInArea>
        extends AreaChecksPosition<OBJ>
        implements AreaWithBorders<OBJ> {

    private final Borders borders;

    public AbstractAreaWithBorders(Borders borders) {
        this.borders = borders;
    }

    @Override
    public Borders getBorders() {
        return borders;
    }

    @Override
    protected void checkPosition(Position pos)
            throws PositionCannotExistInAreaException {

        Borders borders = getBorders();

        if (!borders.positionInBorders(pos)) {
            throw new PositionOutOfBordersException(pos);
        }
    }
}
