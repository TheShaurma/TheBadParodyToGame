package tests.area.position;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import game.area.position.BusyPositionException;
import game.area.position.Position2D;

public class BusyPositionExceptionTest {
    @Test
    public void getPosition_call_minus1Minus1Returned() {
        Position2D<?> expectedPosition = new IntegerPosition2DStub();
        BusyPositionException exception = new BusyPositionException(expectedPosition);
        Position2D<?> actualPosition;

        try {
            throw exception;
        } catch (BusyPositionException e) {
            actualPosition = e.getPosition();
        }

        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void toString_call_normalStringReturned() {
        Position2D<?> position = new IntegerPosition2DStub();
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
