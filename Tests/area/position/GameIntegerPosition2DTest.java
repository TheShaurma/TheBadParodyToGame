package Tests.area.position;

import java.util.Random;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import TheBadParodyToGame.area.position.GameIntegerPosition2D;
import TheBadParodyToGame.area.position.IntegerPosition2D;;

/**
 * This is test for IntegerPosition2DTest.
 */
public class GameIntegerPosition2DTest {
    private static final Random random = new Random();

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

    /**
     * x.equals(x) — true
     */
    @Test
    public void equals_testReflection_trueReturned() {
        IntegerPosition2D pos = getRandomPosition();

        Assertions.assertTrue(pos.equals(pos));
    }

    /**
     * x.equals(y) <=> y.equals(x)
     */
    @Test
    public void equals_testSymmetry_doubleTrueAndDoubleFalseReturned() {
        IntegerPosition2D pos = getRandomPosition();
        IntegerPosition2D posCopy = getPositionCopy(pos);
        IntegerPosition2D otherPos = getOtherPosition(pos);

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
        IntegerPosition2D pos = getRandomPosition();
        IntegerPosition2D posCopy1 = getPositionCopy(pos);
        IntegerPosition2D posCopy2 = getPositionCopy(pos);
        IntegerPosition2D otherPos1 = new GameIntegerPosition2D(pos.getX() + random.nextInt(), pos.getY());
        IntegerPosition2D otherPos2 = new GameIntegerPosition2D(pos.getX(), pos.getY() + random.nextInt());

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
        IntegerPosition2D pos = getRandomPosition();
        IntegerPosition2D posCopy = getPositionCopy(pos);
        IntegerPosition2D otherPos = getOtherPosition(pos);

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
        IntegerPosition2D pos = getRandomPosition();

        Assertions.assertFalse(pos.equals(null));
    }

    /*
     * Повторный вызов hashCode для одного и того же объекта должен возвращать
     * одинаковые хеш-значения, если поля объекта, участвующие в вычислении
     * значения, не менялись.
     * Если equals() для двух объектов возвращает true, hashCode() также должен
     * возвращать для них одно и то же число.
     * При этом неравные между собой объекты могут иметь одинаковый hashCode.
     */

    @Test
    public void hashCode_multipleCallForSingePos_singleHashCode() {
        IntegerPosition2D pos = getRandomPosition();

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
        IntegerPosition2D pos = getRandomPosition();
        IntegerPosition2D[] poses = new IntegerPosition2D[COUNT];
        for (int i = 0; i < COUNT; i++) {
            poses[i] = getPositionCopy(pos);
        }

        for (IntegerPosition2D i : poses) {
            for (IntegerPosition2D j : poses) {
                Assertions.assertEquals(i.hashCode(), j.hashCode());
            }
        }
    }

    private static IntegerPosition2D getRandomPosition() {
        return new GameIntegerPosition2D(random.nextInt(), random.nextInt());
    }

    private static IntegerPosition2D getOtherPosition(IntegerPosition2D pos) {
        while (true) {
            IntegerPosition2D otherPos = new GameIntegerPosition2D(
                    pos.getX() + random.nextInt(),
                    pos.getY() + random.nextInt());

            if (!pos.equals(otherPos)) {
                return otherPos;
            }
        }
    }

    private static IntegerPosition2D getPositionCopy(IntegerPosition2D pos) {
        return new GameIntegerPosition2D(pos.getX(), pos.getY());
    }
}
