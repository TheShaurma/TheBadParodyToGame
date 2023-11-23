package TheBadParodyToGame.area.position;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.Position;

public class EmptyPositionExceptionTest {
    @Test
    public void getPosition_call_minus1Minus1Returned() {
        Position expectedPosition = new PositionStub();
        EmptyPositionException exception = new EmptyPositionException(expectedPosition);
        Position actualPosition;

        try {
            throw exception;
        } catch (EmptyPositionException e) {
            actualPosition = e.getPosition();
        }

        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void toString_call_normalStringReturned() {
        Position position = new PositionStub();
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
