package TheBadParodyToGame.objectsInArea.knowsNeighbors;

import TheBadParodyToGame.area.ConstantArea;
import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.objectsInArea.ObjectKnowsPositionInArea;

public abstract class ObjectKnowsFourNeighborsPoses<A extends ConstantArea<?>> extends ObjectKnowsPositionInArea<A> {

    public ObjectKnowsFourNeighborsPoses(A area, Position pos) {
        super(area, pos);
    }

    public Position getUpPos() {
        Position pos = getPosition();
        int x = pos.getX();
        int y = pos.getY() + 1;

        return new GamePosition(x, y);
    }

    public Position getDownPos() {
        Position pos = getPosition();
        int x = pos.getX();
        int y = pos.getY() - 1;

        return new GamePosition(x, y);
    }

    public Position getLeftPos() {
        Position pos = getPosition();
        int x = pos.getX() - 1;
        int y = pos.getY();

        return new GamePosition(x, y);
    }

    public Position getRightPos() {
        Position pos = getPosition();
        int x = pos.getX() + 1;
        int y = pos.getY();

        return new GamePosition(x, y);
    }

    public Position[] getAllNeighborsPositions() {
        return new Position[] {
                getUpPos(),
                getDownPos(),
                getLeftPos(),
                getRightPos()
        };
    }
}
