package tests.area.position;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import game.area.position.EmptyPositionException;
import game.area.position.Position2D;

public class EmptyPositionExceptionTest {
    @Test
    public void getPosition_call_minus1Minus1Returned() {
        Position2D<?> expectedPosition = new IntegerPosition2DStub();
        EmptyPositionException exception = new EmptyPositionException(expectedPosition);
        Position2D<?> actualPosition;

        try {
            throw exception;
        } catch (EmptyPositionException e) {
            actualPosition = e.getPosition();
        }

        Assertions.assertEquals(expectedPosition, actualPosition);
    }

    @Test
    public void toString_call_normalStringReturned() {
        Position2D<?> position = new IntegerPosition2DStub();
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