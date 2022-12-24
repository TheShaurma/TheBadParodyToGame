package Tests.area.position;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;

public class BusyPositionExceptionTest {
    @Test
    public void getPosition_call_minus1Minus1Returned() {
        IntegerPosition2D expectedPosition = new IntegerPosition2DStub();
        BusyPositionException exception = new BusyPositionException(expectedPosition);
        IntegerPosition2D actualPosition;

        try {
            throw exception;
        } catch (BusyPositionException e) {
            actualPosition = e.getPosition();
        }

        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void toString_call_normalStringReturned() {
        IntegerPosition2D position = new IntegerPosition2DStub();
        BusyPositionException exception = new BusyPositionException(position);
        String expectedString = "Position is busy: " + position.toString();
        String actualString;

        try {
            throw exception;
        } catch (BusyPositionException e) {
            actualString = e.toString();
        }

        Assertions.assertEquals(expectedString, actualString);
    }
}
