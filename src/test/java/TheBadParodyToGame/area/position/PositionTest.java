package TheBadParodyToGame.area.position;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;;

/**
 * This is test for PositionTest.
 */
public class PositionTest {
    private static final Random random = new Random();

    @Test
    public void getX_call_10Returned() {
        GamePosition pos = new GamePosition(10, -10);

        int result = pos.getX();

        Assertions.assertEquals(10, result);
    }

    @Test
    public void getY_call_minus10Returned() {
        GamePosition position = new GamePosition(10, -10);

        int result = position.getY();

        Assertions.assertEquals(-10, result);
    }

    /**
     * x.equals(x) — true
     */
    @Test
    public void equals_testReflection_trueReturned() {
        Position pos = getRandomPosition();

        Assertions.assertTrue(pos.equals(pos));
    }

    /**
     * x.equals(y) <=> y.equals(x)
     */
    @Test
    public void equals_testSymmetry_doubleTrueAndDoubleFalseReturned() {
        Position pos = getRandomPosition();
        Position posCopy = getPositionCopy(pos);
        Position otherPos = getOtherPosition(pos);

        Assertions.assertTrue(pos.equals(posCopy));
        Assertions.assertTrue(posCopy.equals(pos));
        Assertions.assertFalse(pos.equals(otherPos));
        Assertions.assertFalse(otherPos.equals(pos));
    }

    /**
     * x.equals(y) <=> y.equals(z) <=> x.equals(z)
     */
    @Test
    public void equals_testTransitivity_tripleTrueAndTripleFalseReturned() {
        Position pos = getRandomPosition();
        Position posCopy1 = getPositionCopy(pos);
        Position posCopy2 = getPositionCopy(pos);
        Position otherPos1 = new GamePosition(pos.getX() + random.nextInt(), pos.getY());
        Position otherPos2 = new GamePosition(pos.getX(), pos.getY() + random.nextInt());

        Assertions.assertTrue(pos.equals(posCopy1));
        Assertions.assertTrue(posCopy1.equals(posCopy2));
        Assertions.assertTrue(pos.equals(posCopy2));
        Assertions.assertFalse(pos.equals(otherPos1));
        Assertions.assertFalse(otherPos1.equals(otherPos2));
        Assertions.assertFalse(pos.equals(otherPos2));
    }

    /**
     * x.equals(y) shouldn't change
     */
    @Test
    public void equals_testCoherence_alwaysOneValueReturned() {
        Position pos = getRandomPosition();
        Position posCopy = getPositionCopy(pos);
        Position otherPos = getOtherPosition(pos);

        for (int i = 0; i < 100000; i++) {
            Assertions.assertTrue(pos.equals(posCopy));
            Assertions.assertFalse(pos.equals(otherPos));
        }
    }

    /**
     * x.equals(null) is always false
     */
    @Test
    public void equals_compareNull_falseReturned() {
        Position pos = getRandomPosition();

        Assertions.assertFalse(pos.equals(null));
    }

    @Test
    public void hashCode_multipleCallForSingePos_singleHashCode() {
        Position pos = getRandomPosition();

        final int COUNT = 1000;
        int prevHash;
        int currentHash = pos.hashCode();
        for (int i = 0; i < COUNT; i++) {
            prevHash = currentHash;
            currentHash = pos.hashCode();

            Assertions.assertEquals(prevHash, currentHash);
        }
    }

    @Test
    public void hashCode_callForEqualsPoses_singleHashReturned() {
        final int COUNT = 1000;
        Position pos = getRandomPosition();
        Position[] poses = new Position[COUNT];
        for (int i = 0; i < COUNT; i++) {
            poses[i] = getPositionCopy(pos);
        }

        for (Position i : poses) {
            for (Position j : poses) {
                Assertions.assertEquals(i.hashCode(), j.hashCode());
            }
        }
    }

    private static Position getRandomPosition() {
        return new GamePosition(random.nextInt(), random.nextInt());
    }

    private static Position getOtherPosition(Position pos) {
        while (true) {
            Position otherPos = new GamePosition(
                    pos.getX() + random.nextInt(),
                    pos.getY() + random.nextInt());

            if (!pos.equals(otherPos)) {
                return otherPos;
            }
        }
    }

    private static Position getPositionCopy(Position pos) {
        return new GamePosition(pos.getX(), pos.getY());
    }
}
