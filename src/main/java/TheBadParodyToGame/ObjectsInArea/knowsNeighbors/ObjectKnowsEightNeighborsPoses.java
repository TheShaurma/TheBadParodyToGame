package TheBadParodyToGame.objectsInArea.knowsNeighbors;

import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;

public abstract class ObjectKnowsEightNeighborsPoses extends ObjectKnowsFourNeighborsPoses {
    public ObjectKnowsEightNeighborsPoses(Position pos) {
        super(pos);
    }

    public Position getUpLeftPos() {
        Position pos = getPosition();
        int x = pos.getX() - 1;
        int y = pos.getY() + 1;

        return new GamePosition(x, y);
    }

    public Position getUpRightPos() {
        Position pos = getPosition();
        int x = pos.getX() + 1;
        int y = pos.getY() + 1;

        return new GamePosition(x, y);
    }

    public Position getDownLeftPos() {
        Position pos = getPosition();
        int x = pos.getX() - 1;
        int y = pos.getY() - 1;

        return new GamePosition(x, y);
    }

    public Position getDownRightPos() {
        Position pos = getPosition();
        int x = pos.getX() + 1;
        int y = pos.getY() - 1;

        return new GamePosition(x, y);
    }

    @Override
    public Position[] getAllNeighborsPositions() {
        return new Position[] {
                getUpPos(),
                getDownPos(),
                getLeftPos(),
                getRightPos(),
                getUpLeftPos(),
                getUpRightPos(),
                getDownLeftPos(),
                getDownRightPos()
        };
    }
}
