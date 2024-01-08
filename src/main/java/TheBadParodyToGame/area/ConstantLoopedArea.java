package TheBadParodyToGame.area;

import java.util.Iterator;

import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.ObjectInArea;

// TODO: write docs
// TODO: create tests
public class ConstantLoopedArea<OBJ extends ObjectInArea> implements ConstantArea<OBJ> {
    private final ConstantArea<OBJ> areaItself;

    private final int xMin;
    private final int xMax;
    private final int yMin;
    private final int yMax;

    public ConstantLoopedArea(ConstantArea<OBJ> area, int xMax, int yMax) {
        areaItself = area;

        this.xMin = 0;
        this.xMax = xMax;
        this.yMin = 0;
        this.yMax = yMax;
    }

    @Override
    public Iterator<Position> iterator() {
        return areaItself.iterator();
    }

    @Override
    public OBJ get(Position pos) throws EmptyPositionException, PositionCannotExistInAreaException {
        return areaItself.get(convertPos(pos));
    }

    @Override
    public boolean positionIsEmpty(Position pos) throws PositionCannotExistInAreaException {
        return areaItself.positionIsEmpty(convertPos(pos));
    }

    @Override
    public boolean positionIsBusy(Position pos) throws PositionCannotExistInAreaException {
        return areaItself.positionIsBusy(convertPos(pos));
    }

    protected Position convertPos(Position pos) {
        int convertedX = pos.getX();
        int xLength = xMax - xMin + 1;
        while (convertedX < xMin) {
            convertedX += xLength;
        }
        while (convertedX > xMax) {
            convertedX -= xLength;
        }

        int convertedY = pos.getY();
        int yLength = yMax - yMin + 1;
        while (convertedY < yMin) {
            convertedY += yLength;
        }
        while (convertedY > yMax) {
            convertedY -= yLength;
        }

        return new GamePosition(convertedX, convertedY);
    }
}
