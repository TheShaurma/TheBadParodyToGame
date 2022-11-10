package tests.ObjectsInArea;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import game.ObjectsInArea.LostObjectException;
import game.ObjectsInArea.ObjectInArea;
import game.area.position.IntegerPosition2D;
import game.area.position.Position2D;
import tests.area.position.IntegerPosition2DStub;

public class LostObjectExceptionTest {
    @Test
    public void getPosition_call_positionReturned() {
        IntegerPosition2D expectedPos = new IntegerPosition2DStub();
        ObjectInArea obj = new ObjectInAreaStub();
        LostObjectException exception = new LostObjectException(expectedPos, obj);
        Position2D<?> actualPos;

        actualPos = exception.getPosition();

        Assertions.assertEquals(expectedPos, actualPos);
    }

    @Test
    public void getObject_call_objectReturned() {
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        LostObjectException exception = new LostObjectException(pos, expectedObj);
        ObjectInArea actualObj;

        actualObj = exception.getObject();

        Assertions.assertEquals(expectedObj, actualObj);
    }

    @Test
    public void toString_Call_normalStringReturned() {
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea obj = new ObjectInAreaStub();
        LostObjectException exception = new LostObjectException(pos, obj);
        String expectedString = "Manager lost its object in position:" + exception.getPosition() + ".";
        String actualString;

        actualString = exception.toString();

        Assertions.assertEquals(expectedString, actualString);
    }
}
