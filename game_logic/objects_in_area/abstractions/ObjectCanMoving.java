package game_logic.objects_in_area.abstractions;

import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.Area;
import game_logic.abstractions.interfaces.ObjectInArea;
import game_logic.abstractions.interfaces.Position;
import game_logic.objects_in_area.abstractions.exceptions.BusyPositionException;

public abstract class ObjectCanMoving<A extends Area<P>, P extends Position<?>> implements ObjectInArea {
    private A area;
    private P position;

    public ObjectCanMoving(A ar, P pos) throws PositionException {
        area = ar;
        position = pos;

        area.putObject(position, this);
    }

    protected void moveToPos(P newPos) throws PositionException, BusyPositionException {
        if (!area.posIsEmpty(newPos)) {
            throw new BusyPositionException(newPos);
        }

        area = getArea();
        P oldPosition = getPosition();

        area.removeObject(oldPosition);
        area.putObject(newPos, this);
        setPosition(newPos);
    }

    protected A getArea() {
        return area;
    }

    protected P getPosition() {
        return position;
    }

    protected void setPosition(P pos) {
        position = pos;
    }
}
