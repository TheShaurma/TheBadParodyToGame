package Tests.area;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import Tests.ObjectsInArea.ObjectInAreaStub;
import Tests.area.position.IntegerPosition2DStub;
import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.GameArea;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;
import TheBadParodyToGame.area.position.PositionException;

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
     * Call {@code get(pos)} beside {@code tryPlace()}.
     */
    @Test
    public void tryPlace_placeToEmptyPosition_willPlace() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        ObjectInArea actualObj;

        area.tryPlace(pos, expectedObj);
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
        ObjectInArea obj = new ObjectInAreaStub();
        ObjectInArea otherObj = new ObjectInAreaStub();

        area.place(pos, obj);

        Assertions.assertThrows(BusyPositionException.class, () -> {
            area.place(pos, otherObj);
        });
    }

    /**
     * Call {@code place} beside {@code tryPlace}
     */
    @Test
    public void tryPlace_placeToBusyPosition_nothingHappened() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea obj = new ObjectInAreaStub();
        ObjectInArea otherObj = new ObjectInAreaStub();

        area.place(pos, obj);

        area.tryPlace(pos, otherObj);
        assertEquals(area.get(pos), obj);
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
     * Calls {@code set(pos)} and {@code get(pos)} beside
     * {@code tryReplace(pos, obj)}.
     */
    @Test
    public void tryReplace_replaceAtBusyPosition_objectReplaced() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea oldObj = new ObjectInAreaStub();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        ObjectInArea actualObj;
        area.set(pos, oldObj);

        area.tryReplace(pos, expectedObj);
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
     * Calls {@code positionIsEmpty} beside {@code tryReplace}.
     * 
     * @throws PositionCannotExistInAreaException
     */
    @Test
    public void tryReplace_replaceAtEmptyPosition_nothingHappened() throws PositionCannotExistInAreaException {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea obj = new ObjectInAreaStub();

        area.tryReplace(pos, obj);
        assertTrue(area.positionIsEmpty(pos));
    }

    /**
     * Calls {@code set(pos, obj)} and {@code get(pos)} beside
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
     * Calls {@code set(pos, obj)} and {@code get(pos)} beside
     * {@code tryRemove(oldPos, newPos)}.
     */
    @Test
    public void tryRemove_removeFromBusyPosition_objectRemoved() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea obj = new ObjectInAreaStub();
        area.set(pos, obj);

        area.tryRemove(pos);

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
     * Calls {@code tryRemove(pos)} only.
     * 
     * @throws PositionCannotExistInAreaException
     * @throws EmptyPositionException
     */
    @Test
    public void tryRemove_removeFromEmptyPosition_nothingHappened()
            throws EmptyPositionException, PositionCannotExistInAreaException {
        GameArea area = new GameArea();
        IntegerPosition2D pos = new IntegerPosition2DStub();

        area.tryRemove(pos);
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
     * Calls {@code get(pos)} and {@code set(pos, obj)} beside
     * {@code tryRelocate(oldPos, newPos)}.
     */
    @Test
    public void tryRelocate_callWithNormalInput_objectRelocated() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D oldPos = IntegerPosition2DStub.getRandomPosition();
        IntegerPosition2D newPos = IntegerPosition2DStub.getRandomPosition();
        ObjectInArea obj = new ObjectInAreaStub();
        ObjectInArea resultFromNewPos;
        area.set(oldPos, obj);

        area.tryRelocate(oldPos, newPos);
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
     * Calls {@code tryRelocate(oldPos, newPos)} only.
     * 
     * @throws PositionCannotExistInAreaException
     */
    @Test
    public void tryRelocate_relocateFromEmptyPosition_nothingHappened() throws PositionCannotExistInAreaException {
        GameArea area = new GameArea();
        IntegerPosition2D oldPos = IntegerPosition2DStub.getRandomPosition();
        IntegerPosition2D newPos = IntegerPosition2DStub.getRandomPosition();

        area.tryRelocate(oldPos, newPos);
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
     * Calls {@code set(pos, obj)} beside {@code tryReplace(oldPos, newPos)}.
     */
    @Test
    public void tryRelocate_relocateToBusyPosition_nothingHappened() throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D oldPos = IntegerPosition2DStub.getRandomPosition();
        IntegerPosition2D newPos = IntegerPosition2DStub.getRandomPosition();
        ObjectInArea obj = new ObjectInAreaStub();
        area.set(oldPos, obj);
        ObjectInArea otherObj = new ObjectInAreaStub();
        area.set(newPos, otherObj);

        area.tryRelocate(oldPos, newPos);
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
     * Calls {@code set(pos. obj)} beside {@code tryRxelocate(oldPos, newPos)}.
     */
    @Test
    public void tryRelocate_relocateFromEmptyPositionToBusyPosition_nothingHappened()
            throws PositionException {
        GameArea area = new GameArea();
        IntegerPosition2D oldPos = IntegerPosition2DStub.getRandomPosition();
        IntegerPosition2D newPos = IntegerPosition2DStub.getRandomPosition();
        ObjectInArea obj = new ObjectInAreaStub();
        area.set(newPos, obj);

        area.tryRelocate(oldPos, newPos);
    }

    /**
     * Calls {@code positionIsEmpty(pos)} only.
     * 
     * @throws PositionCannotExistInAreaException
     */
    @Test
    public void positionIsEmpty_callWithEmptyPosition_trueReturned() throws PositionCannotExistInAreaException {
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
     * 
     * @throws PositionCannotExistInAreaException
     */
    @Test
    public void positionIsBusy_callWithEmptyPosition_falseReturned() throws PositionCannotExistInAreaException {
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

    @Test
    public void iterator_iterate_iterated() throws BusyPositionException, PositionCannotExistInAreaException {
        GameArea area = new GameArea();
        IntegerPosition2DStub pos1 = new IntegerPosition2DStub();
        IntegerPosition2DStub pos2 = pos1.getOther();
        IntegerPosition2D pos3 = pos2.getOther(pos1);
        area.place(pos1, new ObjectInAreaStub());
        area.place(pos2, new ObjectInAreaStub());
        area.place(pos3, new ObjectInAreaStub());

        for (IntegerPosition2D pos : area) {

            assertTrue(area.positionIsBusy(pos));
        }
    }
}
