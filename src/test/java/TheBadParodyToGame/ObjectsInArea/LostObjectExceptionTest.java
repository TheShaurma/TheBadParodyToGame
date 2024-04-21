package TheBadParodyToGame.objectsInArea;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import TheBadParodyToGame.area.position.PositionStub;
import TheBadParodyToGame.area.position.Position;

public class LostObjectExceptionTest {
    @Test
    public void getPosition_call_positionReturned() {
        Position expectedPos = new PositionStub();
        ObjectInArea obj = new ObjectInAreaStub();
        LostObjectException exception = new LostObjectException(expectedPos, obj);
        Position actualPos;

        actualPos = exception.getPosition();

        Assertions.assertEquals(expectedPos, actualPos);
    }

    @Test
    public void getObject_call_objectReturned() {
        Position pos = new PositionStub();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        LostObjectException exception = new LostObjectException(pos, expectedObj);
        ObjectInArea actualObj;

        actualObj = exception.getObject();

        Assertions.assertEquals(expectedObj, actualObj);
    }

    @Test
    public void toString_call_exceptionWasntThrown() {
        Position pos = new PositionStub();
        ObjectInArea obj = new ObjectInAreaStub();
        LostObjectException exception = new LostObjectException(pos, obj);

        exception.toString();
    }
}
