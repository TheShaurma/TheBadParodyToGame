package tests.area.position;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import game.area.position.GameIntegerPosition2D;

/**
 * This is test for IntegerPosition2DTest.
 */
public class GameIntegerPosition2DTest {
    private static int expectedX = 10;
    private static int expectedY = -10;
    private static GameIntegerPosition2D position = new GameIntegerPosition2D(expectedX, expectedY);

    @Test
    public void getXTest() {
        Assertions.assertEquals(expectedX, position.getX());
    }

    @Test
    public void getYTest() {
        Assertions.assertEquals(expectedY, position.getY());
    }
}
