package Tests.area;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import Tests.ObjectsInArea.ObjectInAreaStub;
import Tests.area.position.IntegerPosition2DStub;
import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.GameArea;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

// TODO: create test for try... methods
public class GameAreaTest {
    /**
     * Calls {@code get(pos)} besides {@code set(pos, obj)}.
     */
    @Test
    public void set_setObjectAtPosition_willSet() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        ObjectInArea actualObj;

        area.set(pos, expectedObj);
        actualObj = area.get(pos);

        Assertions.assertEquals(expectedObj, actualObj);
    }

    /**
     * Calls {@code set(pos, obj)} besides {@code get(pos)}.
     */
    @Test
    public void get_getFromBusyPosition_objectFromAreaReturned() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea obj = new ObjectInAreaStub();
        area.set(pos, obj);
        ObjectInArea expectedObj = obj;
        ObjectInArea actualObj;

        actualObj = area.get(pos);

        Assertions.assertEquals(expectedObj, actualObj);
    }

    /**
     * Calls {@code get(pos)} only.
     */
    @Test
    public void get_getFromEmptyPosition_willThrowEmptyPositionException() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();

        Assertions.assertThrows(EmptyPositionException.class, () -> {
            area.get(pos);
        });
    }

    /**
     * Call {@code get(pos)} beside {@code place()}.
     */
    @Test
    public void place_placeToEmptyPosition_willPlace() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        ObjectInArea actualObj;

        area.place(pos, expectedObj);
        actualObj = area.get(pos);

        Assertions.assertEquals(expectedObj, actualObj);
    }

    /**
     * Call {@code place()} not one time:
     * {@code area.place(pos, Obj);
     * area.place(pos, otherObj);}
     * Only second is tested.
     */
    @Test
    public void place_placeToBusyPosition_willThrowBusyPositionException() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea Obj = new ObjectInAreaStub();
        ObjectInArea otherObj = new ObjectInAreaStub();
        area.place(pos, Obj);

        Assertions.assertThrows(BusyPositionException.class, () -> {
            area.place(pos, otherObj);
        });
    }

    /**
     * Calls {@code set(pos)} and {@code get(pos)} beside {@code replace(pos, obj)}.
     */
    @Test
    public void replace_replaceAtBusyPosition_objectReplaced() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea oldObj = new ObjectInAreaStub();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        ObjectInArea actualObj;
        area.set(pos, oldObj);

        area.replace(pos, expectedObj);
        actualObj = area.get(pos);

        Assertions.assertEquals(expectedObj, actualObj);
    }

    /**
     * Calls {@code replace(pos, obj)} only.
     */
    @Test
    public void replace_replaceAtEmptyPosition_willThrowEmptyPositionException() {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea obj = new ObjectInAreaStub();

        Assertions.assertThrows(EmptyPositionException.class, () -> {
            area.replace(pos, obj);
        });
    }

    /**
     * Calls {@code get(pos, obj)} and {@code get(pos)} beside
     * {@code remove(oldPos, newPos)}.
     */
    @Test
    public void remove_removeFromBusyPosition_objectRemoved() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea obj = new ObjectInAreaStub();
        area.set(pos, obj);

        area.remove(pos);
        Assertions.assertThrows(EmptyPositionException.class, () -> {
            area.get(pos);
        });
    }

    /**
     * Calls {@code remove(pos)} only.
     */
    @Test
    public void remove_removeFromEmptyPosition_willThrowEmptyPositionException() {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();

        Assertions.assertThrows(EmptyPositionException.class, () -> {
            area.remove(pos);
        });
    }

    /**
     * Calls {@code get(pos)} and {@code set(pos, obj)} beside
     * {@code relocate(oldPos, newPos)}.
     */
    @Test
    public void relocate_callWithNormalInput_objectRelocated() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D oldPos = IntegerPosition2DStub.getRandomPosition();
        IntegerPosition2D newPos = IntegerPosition2DStub.getRandomPosition();
        ObjectInArea obj = new ObjectInAreaStub();
        ObjectInArea resultFromNewPos;
        area.set(oldPos, obj);

        area.relocate(oldPos, newPos);
        resultFromNewPos = area.get(newPos);

        Assertions.assertThrows(EmptyPositionException.class, () -> {
            area.get(oldPos);
        });
        Assertions.assertEquals(obj, resultFromNewPos);
    }

    /**
     * Calls {@code relocate(oldPos, newPos)} only.
     */
    @Test
    public void relocate_relocateFromEmptyPosition_willThrowEmptyPositionException() {
        GameArea area = new GameArea();
        IntegerPosition2D oldPos = IntegerPosition2DStub.getRandomPosition();
        IntegerPosition2D newPos = IntegerPosition2DStub.getRandomPosition();

        Assertions.assertThrows(EmptyPositionException.class, () -> {
            area.relocate(oldPos, newPos);
        });
    }

    /**
     * Calls {@code set(pos, obj)} beside {@code replace(oldPos, newPos)}.
     */
    @Test
    public void relocate_relocateToBusyPosition_willThrowBusyPositionException() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D oldPos = IntegerPosition2DStub.getRandomPosition();
        IntegerPosition2D newPos = IntegerPosition2DStub.getRandomPosition();
        ObjectInArea obj = new ObjectInAreaStub();
        area.set(oldPos, obj);
        ObjectInArea otherObj = new ObjectInAreaStub();
        area.set(newPos, otherObj);

        Assertions.assertThrows(BusyPositionException.class, () -> {
            area.relocate(oldPos, newPos);
        });
    }

    /**
     * Calls {@code set(pos. obj)} beside {@code relocate(oldPos, newPos)}.
     */
    @Test
    public void relocate_relocateFromEmptyPositionToBusyPosition_willThrowEmptyPositionException()
            throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D oldPos = IntegerPosition2DStub.getRandomPosition();
        IntegerPosition2D newPos = IntegerPosition2DStub.getRandomPosition();
        ObjectInArea obj = new ObjectInAreaStub();
        area.set(newPos, obj);

        Assertions.assertThrows(EmptyPositionException.class, () -> {
            area.relocate(oldPos, newPos);
        });
    }

    /**
     * Calls {@code positionIsEmpty(pos)} only.
     */
    @Test
    public void positionIsEmpty_callWithEmptyPosition_trueReturned() {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        boolean result;

        result = area.positionIsEmpty(pos);

        Assertions.assertEquals(result, true);
    }

    /**
     * Calls {@code set(pos, obj)} beside {@code positionIsEmpty(pos)}
     */
    @Test
    public void positionIsEmpty_callWithBusyPosition_falseReturned() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea obj = new ObjectInAreaStub();
        area.set(pos, obj);
        boolean result;

        result = area.positionIsEmpty(pos);

        Assertions.assertEquals(result, false);
    }

    /**
     * Calls {@code positionIsBusy(pos)} only.
     */
    @Test
    public void positionIsBusy_callWithEmptyPosition_falseReturned() {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        boolean result;

        result = area.positionIsBusy(pos);

        Assertions.assertEquals(result, false);
    }

    /**
     * Calls {@code set(pos, obj)} beside {@code positionIsBusy(pos)}.
     */
    @Test
    public void positionIsBusy_callWithEmptyPosition_trueReturned() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea obj = new ObjectInAreaStub();
        area.set(pos, obj);
        boolean result;

        result = area.positionIsBusy(pos);

        Assertions.assertEquals(result, true);
    }
}
