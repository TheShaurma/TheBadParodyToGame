package Tests.area.position;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;

public class EmptyPositionExceptionTest {
    @Test
    public void getPosition_call_minus1Minus1Returned() {
        IntegerPosition2D expectedPosition = new IntegerPosition2DStub();
        EmptyPositionException exception = new EmptyPositionException(expectedPosition);
        IntegerPosition2D actualPosition;

        try {
            throw exception;
        } catch (EmptyPositionException e) {
            actualPosition = e.getPosition();
        }

        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void toString_call_normalStringReturned() {
        IntegerPosition2D position = new IntegerPosition2DStub();
        EmptyPositionException exception = new EmptyPositionException(position);
        String expectedString = "Position is empty: " + position.toString();
        String actualString;

        try {
            throw exception;
        } catch (EmptyPositionException e) {
            actualString = e.toString();
        }

        Assertions.assertEquals(expectedString, actualString);
    }
}
