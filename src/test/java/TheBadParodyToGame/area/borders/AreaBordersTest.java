package TheBadParodyToGame.area.borders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionStub;

public class AreaBordersTest {
    @Test
    public void getMovedInBorders_callWithNormalPosition_unchangedPositionReturned() {
        Borders borders = new AreaBorders(100, 100);
        Position expected = new PositionStub(10, 10);
        Position actual = borders.getMovedInBorders(expected);

        assertEquals(expected, actual);
    }

    @Test
    public void getMovedInBorder_giveAnglePosition_unchangedPositionReturned() {
        Borders borders = new AreaBorders(100, 100);
        Position expected = new PositionStub(100, 100);
        Position actual = borders.getMovedInBorders(expected);

        assertEquals(expected, actual);
    }

    @Test
    public void getMovedInBorder_givePositionOutOfBorders_positionInBordersReturned() {
        Borders borders = new AreaBorders(100, 100);
        Position pos = new PositionStub(1000, -1000);
        Position expected = new PositionStub(91, -91);
        Position actual = borders.getMovedInBorders(pos);

        assertEquals(expected, actual);
    }

    @Test
    public void positionInBorders_givePositionInBorders_trueReturned() {
        Borders borders = new AreaBorders(100, 100);
        Position pos = new PositionStub(10, 10);

        assertTrue(borders.positionInBorders(pos));
    }

    @Test
    public void positionInBorders_givePositionOutOfBorders_falseReturned() {
        Borders borders = new AreaBorders(100, 100);
        Position pos = new PositionStub(10, 10);

        assertTrue(borders.positionInBorders(pos));
    }

    @Test
    public void constructor_givePositiveValues_rightBordersCreated() {
        Borders borders = new AreaBorders(100, 100);

        assertEquals(0, borders.getXMin());
        assertEquals(100, borders.getXMax());
        assertEquals(0, borders.getYMin());
        assertEquals(100, borders.getYMax());
    }

    @Test
    public void constructor_giveNegativeValues_rightBordersCreated() {
        Borders borders = new AreaBorders(-100, -100);

        assertEquals(-100, borders.getXMin());
        assertEquals(0, borders.getXMax());
        assertEquals(-100, borders.getYMin());
        assertEquals(0, borders.getYMax());
    }
}
