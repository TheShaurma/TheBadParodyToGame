package Tests.ObjectsInArea;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.Test;

import Tests.area.CheckeredAreaStub;
import Tests.area.position.IntegerPosition2DStub;
import TheBadParodyToGame.ObjectsInArea.CannotMoveObjectException;
import TheBadParodyToGame.ObjectsInArea.LostObjectException;
import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

public class MovingObjectTest {
    // Move from busy to empty pos: obj moved:
    // Move methods without parameters:

    @Test
    public void moveUp_moveFromBusyToEmptyPosition_objectMovedTo1() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getUp();
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveUp();
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveDown_moveFromBusyToEmptyPosition_objectMovedTo1() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getDown();
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveDown();
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveLeft_moveFromBusyToEmptyPosition_objectMovedTo1() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getLeft();
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveLeft();
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveRight_moveFromBusyToEmptyPosition_objectMovedTo1() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getRight();
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveRight();
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveUpLeft_moveFromBusyToEmptyPosition_objectMovedTo1() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getUp().getLeft();
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveUpLeft();
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveUpRight_moveFromBusyToEmptyPosition_objectMovedTo1() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getUp().getRight();
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveUpRight();
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveDownLeft_moveFromBusyToEmptyPosition_objectMovedTo1() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getDown().getLeft();
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveDownLeft();
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveDownRight_moveFromBusyToEmptyPosition_objectMovedTo1() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getDown().getRight();
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveDownRight();
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    // Move methods with 1 parameter:

    @Test
    public void moveUpToN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX(),
                oldPos.getY() + n);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveUp(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveDownToN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX(),
                oldPos.getY() - n);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveDown(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveLeftToN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - n,
                oldPos.getY());
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveLeft(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveRightToN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + n,
                oldPos.getY());
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveRight(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveUpLeftToN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - n,
                oldPos.getY() + n);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveUpLeft(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveUpRightToN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + n,
                oldPos.getY() + n);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveUpRight(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveDownLeftToN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - n,
                oldPos.getY() - n);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveDownLeft(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveDownRightToN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + n,
                oldPos.getY() - n);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveDownRight(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    // Move methods with 2 parameters:

    @Test
    public void moveUpLeftBy2N_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int inUp = getRandomPositiveInt();
        int inLeft = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - inLeft,
                oldPos.getY() + inUp);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveUpLeft(inUp, inLeft);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveUpRightBy2N_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int inUp = getRandomPositiveInt();
        int inRight = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + inRight,
                oldPos.getY() + inUp);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveUpRight(inUp, inRight);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveDownLeftBy2N_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int inDown = getRandomPositiveInt();
        int inLeft = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - inLeft,
                oldPos.getY() - inDown);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveDownLeft(inDown, inLeft);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveDownRightBy2N_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int inDown = getRandomPositiveInt();
        int inRight = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + inRight,
                oldPos.getY() - inDown);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveDownRight(inDown, inRight);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    // Move to negative number:
    // Move methods with 1 parameter:

    @Test
    public void moveUpToNegativeN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = -getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX(),
                oldPos.getY() + n);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveUp(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveDownToNegativeN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = -getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX(),
                oldPos.getY() - n);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveDown(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveLeftToNegativeN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = -getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - n,
                oldPos.getY());
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveLeft(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveRightToNegativeN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = -getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + n,
                oldPos.getY());
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveRight(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveUpLeftToNegativeN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = -getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - n,
                oldPos.getY() + n);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveUpLeft(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveUpRightToNegativeN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = -getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + n,
                oldPos.getY() + n);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveUpRight(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveDownLeftToNegativeN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = -getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - n,
                oldPos.getY() - n);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveDownLeft(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveDownRight2NegativeN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int n = -getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + n,
                oldPos.getY() - n);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveDownRight(n);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    // Move methods with 2 parameters:

    @Test
    public void moveUpLeftBy2NegativeN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int inUp = -getRandomPositiveInt();
        int inLeft = -getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - inLeft,
                oldPos.getY() + inUp);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveUpLeft(inUp, inLeft);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveUpRightBy2NegativeN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int inUp = -getRandomPositiveInt();
        int inRight = -getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + inRight,
                oldPos.getY() + inUp);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveUpRight(inUp, inRight);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveDownLeftBy2NegativeN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int inDown = -getRandomPositiveInt();
        int inLeft = -getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - inLeft,
                oldPos.getY() - inDown);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveDownLeft(inDown, inLeft);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveDownRightBy2NegativeN_moveFromBusyToEmptyPosition_objectMoveToN() throws PositionException {
        int inDown = -getRandomPositiveInt();
        int inRight = -getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + inRight,
                oldPos.getY() - inDown);
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveDownRight(inDown, inRight);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    // Move move from busy to busy pos: CannotMoveObjectException:
    // Move methods without parameters:

    @Test
    public void moveUp_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getUp();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveUp();
        });
    }

    @Test
    public void moveDown_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getDown();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveDown();
        });
    }

    @Test
    public void moveLeft_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getLeft();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveLeft();
        });
    }

    @Test
    public void moveRight_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getRight();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveRight();
        });
    }

    @Test
    public void moveUpLeft_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getUp().getLeft();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveUpLeft();
        });
    }

    @Test
    public void moveUpRight_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getUp().getRight();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveUpRight();
        });
    }

    @Test
    public void moveDownLeft_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getDown().getLeft();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveDownLeft();
        });
    }

    @Test
    public void moveDownRight_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getDown().getRight();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveDownRight();
        });
    }

    // Move methods with 1 parameter:

    @Test
    public void moveUpToN_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX(),
                oldPos.getY() + n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveUp(n);
        });
    }

    @Test
    public void moveDownToN_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX(),
                oldPos.getY() - n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveDown(n);
        });
    }

    @Test
    public void moveLeftToN_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - n,
                oldPos.getY());
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveLeft(n);
        });
    }

    @Test
    public void moveRightToN_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + n,
                oldPos.getY());
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveRight(n);
        });
    }

    @Test
    public void moveUpLeftToN_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - n,
                oldPos.getY() + n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveUpLeft(n);
        });
    }

    @Test
    public void moveUpRightToN_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + n,
                oldPos.getY() + n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveUpRight(n);
        });
    }

    @Test
    public void moveDownLeftToN_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - n,
                oldPos.getY() - n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveDownLeft(n);
        });
    }

    @Test
    public void moveDownRightToN_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + n,
                oldPos.getY() - n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveDownRight(n);
        });
    }

    // Move methods with 2 parameters:

    @Test
    public void moveUpLeftBy2N_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        int inUp = getRandomPositiveInt();
        int inLeft = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - inLeft,
                oldPos.getY() + inUp);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveUpLeft(inUp, inLeft);
        });
    }

    @Test
    public void moveUpRightBy2N_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        int inUp = getRandomPositiveInt();
        int inRight = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + inRight,
                oldPos.getY() + inUp);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveUpRight(inUp, inRight);
        });
    }

    @Test
    public void moveDownLeftBy2N_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        int inDown = getRandomPositiveInt();
        int inLeft = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - inLeft,
                oldPos.getY() - inDown);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveDownLeft(inDown, inLeft);
        });
    }

    @Test
    public void moveDownRightBy2N_moveObjectToBusyPos_CannotMoveObjectException() throws PositionException {
        int inDown = getRandomPositiveInt();
        int inRight = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + inRight,
                oldPos.getY() - inDown);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveDownRight(inDown, inRight);
        });
    }

    // Move from empty to empty pos: LostObjectException:
    // Move methods without parameters:

    @Test
    public void moveUp_relocateObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getUp();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUp();
        });
    }

    @Test
    public void moveDown_relocateObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getDown();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveDown();
        });
    }

    @Test
    public void moveLeft_relocateObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getLeft();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveLeft();
        });
    }

    @Test
    public void moveRight_relocateObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getRight();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveRight();
        });
    }

    @Test
    public void moveUpLeft_relocateObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getUp().getLeft();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpLeft();
        });
    }

    @Test
    public void moveUpRight_relocateObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getUp().getRight();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpRight();
        });
    }

    @Test
    public void moveDownLeft_relocateObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getDown().getLeft();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownLeft();
        });
    }

    @Test
    public void moveDownRight_relocateObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getDown().getRight();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownRight();
        });
    }

    // Move methods with 1 parameter:

    @Test
    public void moveUpToN_moveObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX(),
                oldPos.getY() + n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUp(n);
        });
    }

    @Test
    public void moveDownToN_moveObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX(),
                oldPos.getY() - n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveDown(n);
        });
    }

    @Test
    public void moveLeftToN_moveObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - n,
                oldPos.getY());
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveLeft(n);
        });
    }

    @Test
    public void moveRightToN_moveObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + n,
                oldPos.getY());
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveRight(n);
        });
    }

    @Test
    public void moveUpLeftToN_moveObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - n,
                oldPos.getY() + n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpLeft(n);
        });
    }

    @Test
    public void moveUpRightToN_moveObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + n,
                oldPos.getY() + n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpRight(n);
        });
    }

    @Test
    public void moveDownLeftToN_moveObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - n,
                oldPos.getY() - n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpRight();
        });
    }

    @Test
    public void moveDownRIghtToN_moveObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + n,
                oldPos.getY() - n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownRight(n);
        });
    }

    // Move methods with 2 parameters:

    @Test
    public void moveUpLeftBy2N_moveObjectManuallyThenCall_LostObjectException()
            throws PositionException {
        int inUp = getRandomPositiveInt();
        int inLeft = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - inLeft,
                oldPos.getY() + inUp);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpLeft(inUp, inLeft);
        });
    }

    @Test
    public void moveUpRightBy2N_moveObjectManuallyThenCall_LostObjectException()
            throws PositionException {
        int inUp = getRandomPositiveInt();
        int inRight = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + inRight,
                oldPos.getY() + inUp);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpRight(inUp, inRight);
        });
    }

    @Test
    public void moveDownLeftBy2N_moveObjectManuallyThenCall_LostObjectException()
            throws PositionException {
        int inDown = getRandomPositiveInt();
        int inLeft = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - inLeft,
                oldPos.getY() - inDown);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownLeft(inDown, inLeft);
        });
    }

    @Test
    public void moveDownRightBy2N_moveObjectManuallyThenCall_LostObjectException()
            throws PositionException {
        int inDown = getRandomPositiveInt();
        int inRight = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + inRight,
                oldPos.getY() - inDown);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownRight(inDown, inRight);
        });
    }

    // Move from empty to busy pos: LostObjectException:
    // Move methods without parameters:

    @Test
    public void moveUp_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getUp();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUp();
        });
    }

    @Test
    public void moveDown_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getDown();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveDown();
        });
    }

    @Test
    public void moveLeft_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getLeft();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveLeft();
        });
    }

    @Test
    public void moveRight_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getRight();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveRight();
        });
    }

    @Test
    public void moveUpLeft_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getUp().getLeft();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpLeft();
        });
    }

    @Test
    public void moveUpRight_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getUp().getRight();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpRight();
        });
    }

    @Test
    public void moveDownLeft_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getDown().getLeft();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownLeft();
        });
    }

    @Test
    public void moveDownRight_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getDown().getRight();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownRight();
        });
    }

    // Move methods with 1 parameter:

    @Test
    public void moveUpToN_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX(),
                oldPos.getY() + n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUp(n);
        });
    }

    @Test
    public void moveDownToN_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX(),
                oldPos.getY() - n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveDown(n);
        });
    }

    @Test
    public void moveLeftToN_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - n,
                oldPos.getY());
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveLeft(n);
        });
    }

    @Test
    public void moveRightToN_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + n,
                oldPos.getY());
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveRight(n);
        });
    }

    @Test
    public void moveUpLeftToN_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - n,
                oldPos.getY() + n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpLeft(n);
        });
    }

    @Test
    public void moveUpRightToN_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + n,
                oldPos.getY() + n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpRight(n);
        });
    }

    @Test
    public void moveDownLeftToN_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - n,
                oldPos.getY() - n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownLeft(n);
        });
    }

    @Test
    public void moveDownRightToN_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + n,
                oldPos.getY() - n);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownRight(n);
        });
    }

    // Move method with 2 parameters:

    @Test
    public void moveUpLeftToTwoN_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        int inUp = getRandomPositiveInt();
        int inLeft = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - inLeft,
                oldPos.getY() + inUp);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpLeft(inUp, inLeft);
        });
    }

    @Test
    public void moveUpRightToTwoN_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        int inUp = getRandomPositiveInt();
        int inRight = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + inRight,
                oldPos.getY() + inUp);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpRight(inUp, inRight);
        });
    }

    @Test
    public void moveDownLeftToTwoN_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        int inDown = getRandomPositiveInt();
        int inLeft = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() - inLeft,
                oldPos.getY() - inDown);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownLeft(inDown, inLeft);
        });
    }

    @Test
    public void moveDownRightToTwoN_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        int inDown = getRandomPositiveInt();
        int inRight = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = new IntegerPosition2DStub(
                oldPos.getX() + inRight,
                oldPos.getY() - inDown);
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());
        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownRight(inDown, inRight);
        });
    }

    // Replace obj manually then try to call: LostObjectException
    // Move methods without parameters:

    @Test
    public void moveUp_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveUp();
        });
    }

    @Test
    public void moveDown_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveDown();
        });
    }

    @Test
    public void moveLeft_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveLeft();
        });
    }

    @Test
    public void moveRight_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveRight();
        });
    }

    @Test
    public void moveUpLeft_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpLeft();
        });
    }

    @Test
    public void moveUpRight_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpRight();
        });
    }

    @Test
    public void moveDownLeft_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownLeft();
        });
    }

    @Test
    public void moveDownRight_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownRight();
        });
    }

    // Move methods with 1 parameter:

    @Test
    public void moveUpToN_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveUp(n);
        });
    }

    @Test
    public void moveDownToN_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveDown(n);
        });
    }

    @Test
    public void moveLeftToN_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveLeft(n);
        });
    }

    @Test
    public void moveRightToN_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveRight(n);
        });
    }

    @Test
    public void moveUpLeftToN_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpLeft(n);
        });
    }

    @Test
    public void moveUpRightToN_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpRight(n);
        });
    }

    @Test
    public void moveDownLeftToN_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownLeft(n);
        });
    }

    @Test
    public void moveDownRightToN_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        int n = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownRight(n);
        });
    }

    // Move methods with 2 parameters:

    @Test
    public void moveUpLeftBy2N_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        int inUp = getRandomPositiveInt();
        int inLeft = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpLeft(inUp, inLeft);
        });
    }

    @Test
    public void moveUpRightBy2N_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        int inUp = getRandomPositiveInt();
        int inRight = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveUpRight(inUp, inRight);
        });
    }

    @Test
    public void moveDownLeftBy2N_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        int inDown = getRandomPositiveInt();
        int inLeft = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownLeft(inDown, inLeft);
        });
    }

    @Test
    public void moveDownRightBy2N_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        int inDown = getRandomPositiveInt();
        int inRight = getRandomPositiveInt();
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveDownRight(inDown, inRight);
        });
    }

    // moveToPositionTests:

    @Test
    public void moveToPosition_moveFromBusyToEmptyPosition_objectMoved() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getOther();
        MovingObjectStub expectedObj = new MovingObjectStub(area, oldPos);
        ObjectInArea actualObj;

        expectedObj.moveToPosition(newPos);
        actualObj = area.get(newPos);

        assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveToPosition_moveToBusyPos_CannotMoveObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getOther();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.place(newPos, new ObjectInAreaStub());

        assertThrows(CannotMoveObjectException.class, () -> {
            obj.moveToPosition(newPos);
        });
    }

    @Test
    public void moveToPosition_relocateObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getOther();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));

        assertThrows(LostObjectException.class, () -> {
            obj.moveToPosition(newPos);
        });
    }

    @Test
    public void moveToPosition_moveFromEmptyToBusyPosition_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getOther();
        MovingObjectStub obj = new MovingObjectStub(area, oldPos);

        area.relocate(oldPos, oldPos.getOther(newPos));
        area.place(newPos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveToPosition(newPos);
        });
    }

    @Test
    public void moveToPosition_replaceObjectManuallyThenCall_LostObjectException() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        MovingObjectStub obj = new MovingObjectStub(area, pos);

        area.replace(pos, new ObjectInAreaStub());

        assertThrows(LostObjectException.class, () -> {
            obj.moveToPosition(pos.getOther());
        });
    }

    @Test
    public void allMoveMethods_moveALotOfTimes_objectMoved() throws PositionException {
        AreaContainsAll area = new CheckeredAreaStub();
        int inUp = getRandomPositiveInt();
        int inDown = getRandomPositiveInt();
        int inLeft = getRandomPositiveInt();
        int inRight = getRandomPositiveInt();
        int inUpLeft = getRandomPositiveInt();
        int inUpRight = getRandomPositiveInt();
        int inDownLeft = getRandomPositiveInt();
        int inDownRight = getRandomPositiveInt();
        int inUp1 = getRandomPositiveInt();
        int inLeft1 = getRandomPositiveInt();
        int inUp2 = getRandomPositiveInt();
        int inRight2 = getRandomPositiveInt();
        int intDown3 = getRandomPositiveInt();
        int inLeft3 = getRandomPositiveInt();
        int intDown4 = getRandomPositiveInt();
        int inRight4 = getRandomPositiveInt();
        IntegerPosition2DStub startPos = new IntegerPosition2DStub();
        IntegerPosition2D middlePos = startPos.getOther();
        IntegerPosition2D finalPos = new IntegerPosition2DStub(
                middlePos.getX() + inRight + inRight2 + inRight4
                        + inUpRight + inDownRight
                        - inLeft - inLeft1 - inLeft3
                        - inUpLeft - inDownLeft,
                middlePos.getY() + inUp + inUp1 + inUp2
                        + inUpLeft + inUpRight
                        - inDown - intDown3 - intDown4
                        - inDownLeft - inDownRight);
        MovingObjectStub expectedObj = new MovingObjectStub(area, startPos);
        ObjectInArea actualObj;

        expectedObj.moveToPosition(middlePos);
        expectedObj.moveUp();
        expectedObj.moveDown();
        expectedObj.moveLeft();
        expectedObj.moveRight();
        expectedObj.moveUp(inUp);
        expectedObj.moveDown(inDown);
        expectedObj.moveLeft(inLeft);
        expectedObj.moveRight(inRight);
        expectedObj.moveUpLeft(inUpLeft);
        expectedObj.moveUpRight(inUpRight);
        expectedObj.moveDownLeft(inDownLeft);
        expectedObj.moveDownRight(inDownRight);
        expectedObj.moveUpLeft(inUp1, inLeft1);
        expectedObj.moveUpRight(inUp2, inRight2);
        expectedObj.moveDownLeft(intDown3, inLeft3);
        expectedObj.moveDownRight(intDown4, inRight4);
        actualObj = area.get(finalPos);

        assertEquals(expectedObj, actualObj);
    }

    private static Random random = new Random();

    public int getRandomPositiveInt() {
        return Math.abs(random.nextInt());
    }
}
