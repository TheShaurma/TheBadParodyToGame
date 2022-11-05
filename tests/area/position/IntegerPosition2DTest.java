package tests.area.position;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import game.area.position.IntegerPosition2D;

/**
 * This is test for IntegerPosition2DTest.
 */
public class IntegerPosition2DTest {
    private static int expectedX = 10;
    private static int expectedY = -10;
    private static IntegerPosition2D position = new IntegerPosition2D(expectedX, expectedY);

    @Test
    public void getXTest() {
        assertEquals(position.getX(), expectedX);
    }

    @Test
    public void getYTest() {
        assertEquals(position.getY(), expectedY);
    }
}
