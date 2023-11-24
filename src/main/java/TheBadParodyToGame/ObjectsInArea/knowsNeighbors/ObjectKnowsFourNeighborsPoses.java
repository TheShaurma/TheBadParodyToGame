package TheBadParodyToGame.objectsInArea.knowsNeighbors;

import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.objectsInArea.ObjectKnowsPosition;

public abstract class ObjectKnowsFourNeighborsPoses extends ObjectKnowsPosition {
    public ObjectKnowsFourNeighborsPoses(Position pos) {
        super(pos);
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
