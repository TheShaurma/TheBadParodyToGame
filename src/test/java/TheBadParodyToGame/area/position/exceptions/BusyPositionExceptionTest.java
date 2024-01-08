package TheBadParodyToGame.area.position.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionStub;

public class BusyPositionExceptionTest {
    @Test
    public void getPosition_call_minus1Minus1Returned() {
        Position expectedPosition = new PositionStub();
        BusyPositionException exception = new BusyPositionException(expectedPosition);
        Position actualPosition;

        try {
            throw exception;
        } catch (BusyPositionException e) {
            actualPosition = e.getPosition();
        }

        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void toString_call_normalStringReturned() {
        Position position = new PositionStub();
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
