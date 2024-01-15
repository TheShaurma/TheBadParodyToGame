package TheBadParodyToGame.area.position;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * This is test for PositionTest.
 */
public class PositionTest {
    private static final Random random = new Random();

    @Test
    public void getX_call_10Returned() {
        Position pos = new GamePosition(10, -10);

        int result = pos.getX();

        Assertions.assertEquals(10, result);
    }

    @Test
    public void getY_call_minus10Returned() {
        Position position = new GamePosition(10, -10);

        int result = position.getY();

        Assertions.assertEquals(-10, result);
    }

    @Test
    public void getUp_call_positionUpperTo1Returned() {
        int x = random.nextInt();
        int y = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position excepted = new GamePosition(x, y + 1);
        Position actual = pos.getUp();

        assertEquals(excepted, actual);
    }

    @Test
    public void getDown_call_positionBelowTo1Returned() {
        int x = random.nextInt();
        int y = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position excepted = new GamePosition(x, y - 1);
        Position actual = pos.getDown();

        assertEquals(excepted, actual);
    }

    @Test
    public void getLeft_call_positionLefterTo1Returned() {
        int x = random.nextInt();
        int y = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position excepted = new GamePosition(x - 1, y);
        Position actual = pos.getLeft();

        assertEquals(excepted, actual);
    }

    @Test
    public void getRight_call_positionRighterTo1Returned() {
        int x = random.nextInt();
        int y = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position excepted = new GamePosition(x + 1, y);
        Position actual = pos.getRight();

        assertEquals(excepted, actual);
    }

    @Test
    public void getUpLeft_call_positionUpperAndLefterTo1Returned() {
        int x = random.nextInt();
        int y = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position excepted = new GamePosition(x - 1, y + 1);
        Position actual = pos.getUpLeft();

        assertEquals(excepted, actual);
    }

    @Test
    public void getUp_call_positionUpperAndRighterTo1Returned() {
        int x = random.nextInt();
        int y = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position excepted = new GamePosition(x + 1, y + 1);
        Position actual = pos.getUpRight();

        assertEquals(excepted, actual);
    }

    @Test
    public void getDownLeft_call_positionBelowAndLefterTo1Returned() {
        int x = random.nextInt();
        int y = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position excepted = new GamePosition(x - 1, y - 1);
        Position actual = pos.getDownLeft();

        assertEquals(excepted, actual);
    }

    @Test
    public void getDownRight_call_positionBelowAndRighterTo1Returned() {
        int x = random.nextInt();
        int y = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position excepted = new GamePosition(x + 1, y - 1);
        Position actual = pos.getDownRight();

        assertEquals(excepted, actual);
    }

    @Test
    public void getUpToN_call_positionUpperToNReturned() {
        int x = random.nextInt();
        int y = random.nextInt();
        int n = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position expected = new GamePosition(x, y + n);
        Position actual = pos.getUp(n);

        assertEquals(expected, actual);
    }

    @Test
    public void getDownToN_call_positionBelowToNReturned() {
        int x = random.nextInt();
        int y = random.nextInt();
        int n = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position expected = new GamePosition(x, y - n);
        Position actual = pos.getDown(n);

        assertEquals(expected, actual);
    }

    @Test
    public void getLeftToN_call_positionLefterToNReturned() {
        int x = random.nextInt();
        int y = random.nextInt();
        int n = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position expected = new GamePosition(x - n, y);
        Position actual = pos.getLeft(n);

        assertEquals(expected, actual);
    }

    @Test
    public void getRightToN_call_positionRighterToNReturned() {
        int x = random.nextInt();
        int y = random.nextInt();
        int n = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position expected = new GamePosition(x + n, y);
        Position actual = pos.getRight(n);

        assertEquals(expected, actual);
    }

    @Test
    public void getUpLeftToN_call_positionUpperAndLefterToNReturned() {
        int x = random.nextInt();
        int y = random.nextInt();
        int n = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position expected = new GamePosition(x - n, y + n);
        Position actual = pos.getUpLeft(n);

        assertEquals(expected, actual);
    }

    @Test
    public void getUpRightToN_call_positionUpperAndRighterToNReturned() {
        int x = random.nextInt();
        int y = random.nextInt();
        int n = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position expected = new GamePosition(x + n, y + n);
        Position actual = pos.getUpRight(n);

        assertEquals(expected, actual);
    }

    @Test
    public void getDownLeftToN_call_positionBelowAndLefterToNReturned() {
        int x = random.nextInt();
        int y = random.nextInt();
        int n = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position expected = new GamePosition(x - n, y - n);
        Position actual = pos.getDownLeft(n);

        assertEquals(expected, actual);
    }

    @Test
    public void getDownRightToN_call_positionBelowAndRighterToNReturned() {
        int x = random.nextInt();
        int y = random.nextInt();
        int n = random.nextInt();
        Position pos = new GamePosition(x, y);
        Position expected = new GamePosition(x + n, y - n);
        Position actual = pos.getDownRight(n);

        assertEquals(expected, actual);
    }

    @Test
    public void getUpToYLeftToX_call_positionUpperToXAndRighterToYReturned() {
        int posX = random.nextInt();
        int posY = random.nextInt();
        int xMove = random.nextInt();
        int yMove = random.nextInt();
        Position pos = new GamePosition(posX, posY);
        Position expected = new GamePosition(
                posX - xMove,
                posY + yMove);
        Position actual = pos.getUpLeft(xMove, yMove);

        assertEquals(expected, actual);
    }

    @Test
    public void getUpToYRightToX_call_positionUpperToXAndRighterToYReturned() {
        int posX = random.nextInt();
        int posY = random.nextInt();
        int xMove = random.nextInt();
        int yMove = random.nextInt();
        Position pos = new GamePosition(posX, posY);
        Position expected = new GamePosition(
                posX + xMove,
                posY + yMove);
        Position actual = pos.getUpRight(xMove, yMove);

        assertEquals(expected, actual);
    }

    @Test
    public void getDownToYLeftToX_call_positionBelowToXAndLefterToYReturned() {
        int posX = random.nextInt();
        int posY = random.nextInt();
        int xMove = random.nextInt();
        int yMove = random.nextInt();
        Position pos = new GamePosition(posX, posY);
        Position expected = new GamePosition(
                posX - xMove,
                posY - yMove);
        Position actual = pos.getDownLeft(xMove, yMove);

        assertEquals(expected, actual);
    }

    @Test
    public void getDownToYRightToX_call_positionBelowToXAndRighterToYReturned() {
        int posX = random.nextInt();
        int posY = random.nextInt();
        int xMove = random.nextInt();
        int yMove = random.nextInt();
        Position pos = new GamePosition(posX, posY);
        Position expected = new GamePosition(
                posX + xMove,
                posY - yMove);
        Position actual = pos.getDownRight(xMove, yMove);

        assertEquals(expected, actual);
    }

    /**
     * 
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
