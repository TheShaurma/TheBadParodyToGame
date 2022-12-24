package Tests.ObjectsInArea;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import Tests.area.position.IntegerPosition2DStub;
import TheBadParodyToGame.ObjectsInArea.LostObjectException;
import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.IntegerPosition2D;

public class LostObjectExceptionTest {
    @Test
    public void getPosition_call_positionReturned() {
        IntegerPosition2D expectedPos = new IntegerPosition2DStub();
        ObjectInArea obj = new ObjectInAreaStub();
        LostObjectException exception = new LostObjectException(expectedPos, obj);
        IntegerPosition2D actualPos;

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
