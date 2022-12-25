package Tests.ObjectsInArea;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.ObjectsInArea.ObjectManager;
import TheBadParodyToGame.area.CheckeredArea;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

public class ObjectManagerStub extends ObjectManager {

    public ObjectManagerStub(IntegerPosition2D pos, CheckeredArea area, ObjectInArea obj) throws PositionException {
        super(pos, area, obj);
    }

    public void moveObjectUp() throws PositionException {
        super.moveObjectUp();
    }

    public void moveObjectDown() throws PositionException {
        super.moveObjectDown();
    }

    public void moveObjectLeft() throws PositionException {
        super.moveObjectLeft();
    }

    public void moveObjectRight() throws PositionException {
        super.moveObjectRight();
    }

    public void moveObjectUpLeft() throws PositionException {
        super.moveObjectUpLeft();
    }

    public void moveObjectUpRight() throws PositionException {
        super.moveObjectUpRight();
    }

    public void moveObjectDownLeft() throws PositionException {
        super.moveObjectDownLeft();
    }

    public void moveObjectDownRight() throws PositionException {
        super.moveObjectDownRight();
    }

    public void moveObjectToPosition(IntegerPosition2D newPos) throws PositionException {
        super.moveObjectToPosition(newPos);
    }

    public CheckeredArea getAreaCallForTest() {
        return getArea();
    }

    public ObjectInArea getObjectCallForTest() {
        return getObject();
    }

    public IntegerPosition2D getCurrentPositionCallForTest() {
        return getCurrentPosition();
    }
}
