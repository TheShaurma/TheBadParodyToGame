package TheBadParodyToGame.objectsInArea;

import TheBadParodyToGame.area.ConstantArea;
import TheBadParodyToGame.area.position.Position;

public abstract class ObjectKnowsPositionInArea<A extends ConstantArea<?>> extends ObjectKnowsPosition {
    private final A area;

    public ObjectKnowsPositionInArea(A area, Position pos) {
        super(pos);
        this.area = area;
    }

    protected A getArea() {
        return area;
    }
}
