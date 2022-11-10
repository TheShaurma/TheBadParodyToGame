package Tests.area.position;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import TheBadParodyToGame.area.position.GameIntegerPosition2D;;

/**
 * This is test for IntegerPosition2DTest.
 */
public class GameIntegerPosition2DTest {
    @Test
    public void getX_call_10Returned() {
        GameIntegerPosition2D pos = new GameIntegerPosition2D(10, -10);

        int result = pos.getX();

        Assertions.assertEquals(10, result);
    }

    @Test
    public void getY_call_minus10Returned() {
        GameIntegerPosition2D position = new GameIntegerPosition2D(10, -10);

        int result = position.getY();

        Assertions.assertEquals(-10, result);
    }
}
