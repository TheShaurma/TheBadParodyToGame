package Tests.ObjectsInArea;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import Tests.area.CheckeredAreaStub;
import Tests.area.position.IntegerPosition2DStub;
import TheBadParodyToGame.ObjectsInArea.CannotMoveObjectException;
import TheBadParodyToGame.ObjectsInArea.LostObjectException;
import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.CheckeredArea;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

public class ObjectManagerTest {
    @Test
    public void moveObjectUp_moveObjToEmptyPosition_objectMoved() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getUp();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        ObjectInArea actualObj;
        area.place(oldPos, expectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(oldPos, area, expectedObj);

        manager.moveObjectUp();
        actualObj = area.get(newPos);

        Assertions.assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveObjectDown_moveObjToEmptyPosition_objectMoved() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getDown();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        ObjectInArea actualObj;
        area.place(oldPos, expectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(oldPos, area, expectedObj);

        manager.moveObjectDown();
        actualObj = area.get(newPos);

        Assertions.assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveObjectLeft_moveObjToEmptyPosition_objectMoved() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getLeft();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        ObjectInArea actualObj;
        area.place(oldPos, expectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(oldPos, area, expectedObj);

        manager.moveObjectLeft();
        actualObj = area.get(newPos);

        Assertions.assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveObjectRight_moveObjToEmptyPosition_objectMoved() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getRight();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        ObjectInArea actualObj;
        area.place(oldPos, expectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(oldPos, area, expectedObj);

        manager.moveObjectRight();
        actualObj = area.get(newPos);

        Assertions.assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveObjectUpLeft_moveObjToEmptyPosition_objectMoved() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getUp().getLeft();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        ObjectInArea actualObj;
        area.place(oldPos, expectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(oldPos, area, expectedObj);

        manager.moveObjectUpLeft();
        actualObj = area.get(newPos);

        Assertions.assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveObjectUpRight_moveObjToEmptyPosition_objectMoved() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getUp().getRight();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        ObjectInArea actualObj;
        area.place(oldPos, expectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(oldPos, area, expectedObj);

        manager.moveObjectUpRight();
        actualObj = area.get(newPos);

        Assertions.assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveObjectDownLeft_moveObjToEmptyPosition_objectMoved() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getDown().getLeft();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        ObjectInArea actualObj;
        area.place(oldPos, expectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(oldPos, area, expectedObj);

        manager.moveObjectDownLeft();
        actualObj = area.get(newPos);

        Assertions.assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveObjectDownRight_moveObjToEmptyPosition_objectMoved() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getDown().getRight();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        ObjectInArea actualObj;
        area.place(oldPos, expectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(oldPos, area, expectedObj);

        manager.moveObjectDownRight();
        actualObj = area.get(newPos);

        Assertions.assertEquals(expectedObj, actualObj);
    }

    @Test
    public void moveObjectToPosition_moveObjToEmptyPosition_objectMoved() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub oldPos = new IntegerPosition2DStub();
        IntegerPosition2D newPos = oldPos.getOther();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        ObjectInArea actualObj;
        area.place(oldPos, expectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(oldPos, area, expectedObj);

        manager.moveObjectToPosition(newPos);
        actualObj = area.get(newPos);

        Assertions.assertEquals(expectedObj, actualObj);
    }

    // ======================================================================

    @Test
    public void moveObjectUp_moveObjToBusyPosition_cannotMoveObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        IntegerPosition2D otherPos = pos.getUp();
        ObjectInArea obj = new ObjectInAreaStub();
        ObjectInArea otherObj = new ObjectInAreaStub();
        area.place(pos, obj);
        area.place(otherPos, otherObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, obj);

        Assertions.assertThrows(CannotMoveObjectException.class, () -> {
            manager.moveObjectUp();
        });
    }

    @Test
    public void moveObjectDown_moveObjToBusyPosition_cannotMoveObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        IntegerPosition2D otherPos = pos.getDown();
        ObjectInArea obj = new ObjectInAreaStub();
        ObjectInArea otherObj = new ObjectInAreaStub();
        area.place(pos, obj);
        area.place(otherPos, otherObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, obj);

        Assertions.assertThrows(CannotMoveObjectException.class, () -> {
            manager.moveObjectDown();
        });
    }

    @Test
    public void moveObjectLeft_moveObjToBusyPosition_cannotMoveObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        IntegerPosition2D otherPos = pos.getLeft();
        ObjectInArea obj = new ObjectInAreaStub();
        ObjectInArea otherObj = new ObjectInAreaStub();
        area.place(pos, obj);
        area.place(otherPos, otherObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, obj);

        Assertions.assertThrows(CannotMoveObjectException.class, () -> {
            manager.moveObjectLeft();
        });
    }

    @Test
    public void moveObjectRight_moveObjToBusyPosition_cannotMoveObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        IntegerPosition2D otherPos = pos.getRight();
        ObjectInArea obj = new ObjectInAreaStub();
        ObjectInArea otherObj = new ObjectInAreaStub();
        area.place(pos, obj);
        area.place(otherPos, otherObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, obj);

        Assertions.assertThrows(CannotMoveObjectException.class, () -> {
            manager.moveObjectRight();
        });
    }

    @Test
    public void moveObjectUpLeft_moveObjToBusyPosition_cannotMoveObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        IntegerPosition2D otherPos = pos.getUp().getLeft();
        ObjectInArea obj = new ObjectInAreaStub();
        ObjectInArea otherObj = new ObjectInAreaStub();
        area.place(pos, obj);
        area.place(otherPos, otherObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, obj);

        Assertions.assertThrows(CannotMoveObjectException.class, () -> {
            manager.moveObjectUpLeft();
        });
    }

    @Test
    public void moveObjectUpRight_moveObjToBusyPosition_cannotMoveObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        IntegerPosition2D otherPos = pos.getUp().getRight();
        ObjectInArea obj = new ObjectInAreaStub();
        ObjectInArea otherObj = new ObjectInAreaStub();
        area.place(pos, obj);
        area.place(otherPos, otherObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, obj);

        Assertions.assertThrows(CannotMoveObjectException.class, () -> {
            manager.moveObjectUpRight();
        });
    }

    @Test
    public void moveObjectDownLeft_moveObjToBusyPosition_cannotMoveObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        IntegerPosition2D otherPos = pos.getDown().getLeft();
        ObjectInArea obj = new ObjectInAreaStub();
        ObjectInArea otherObj = new ObjectInAreaStub();
        area.place(pos, obj);
        area.place(otherPos, otherObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, obj);

        Assertions.assertThrows(CannotMoveObjectException.class, () -> {
            manager.moveObjectDownLeft();
        });
    }

    @Test
    public void moveObjectDownRight_moveObjToBusyPosition_cannotMoveObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        IntegerPosition2D otherPos = pos.getDown().getRight();
        ObjectInArea obj = new ObjectInAreaStub();
        ObjectInArea otherObj = new ObjectInAreaStub();
        area.place(pos, obj);
        area.place(otherPos, otherObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, obj);

        Assertions.assertThrows(CannotMoveObjectException.class, () -> {
            manager.moveObjectDownRight();
        });
    }

    @Test
    public void moveObjectToPosition_moveObjToBusyPosition_cannotMoveObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        IntegerPosition2D otherPos = pos.getOther();
        ObjectInArea obj = new ObjectInAreaStub();
        ObjectInArea otherObj = new ObjectInAreaStub();
        area.place(pos, obj);
        area.place(otherPos, otherObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, obj);

        Assertions.assertThrows(CannotMoveObjectException.class, () -> {
            manager.moveObjectToPosition(otherPos);
        });
    }

    // ======================================================================

    @Test
    public void moveObjectUp_relocateObjAndTryToMove_lostObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        ObjectInArea ExpectedObj = new ObjectInAreaStub();
        area.place(pos, ExpectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, ExpectedObj);
        area.remove(pos);

        Assertions.assertThrows(LostObjectException.class, () -> {
            manager.moveObjectUp();
        });
    }

    @Test
    public void moveObjectDown_relocateObjAndTryToMove_lostObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        ObjectInArea ExpectedObj = new ObjectInAreaStub();
        area.place(pos, ExpectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, ExpectedObj);
        area.remove(pos);

        Assertions.assertThrows(LostObjectException.class, () -> {
            manager.moveObjectDown();
        });
    }

    @Test
    public void moveObjectLeft_relocateObjAndTryToMove_lostObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        ObjectInArea ExpectedObj = new ObjectInAreaStub();
        area.place(pos, ExpectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, ExpectedObj);
        area.remove(pos);

        Assertions.assertThrows(LostObjectException.class, () -> {
            manager.moveObjectLeft();
        });
    }

    @Test
    public void moveObjectRight_relocateObjAndTryToMove_lostObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        ObjectInArea ExpectedObj = new ObjectInAreaStub();
        area.place(pos, ExpectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, ExpectedObj);
        area.remove(pos);

        Assertions.assertThrows(LostObjectException.class, () -> {
            manager.moveObjectRight();
        });
    }

    @Test
    public void moveObjectUpLeft_relocateObjAndTryToMove_lostObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        ObjectInArea ExpectedObj = new ObjectInAreaStub();
        area.place(pos, ExpectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, ExpectedObj);
        area.remove(pos);

        Assertions.assertThrows(LostObjectException.class, () -> {
            manager.moveObjectUpLeft();
        });
    }

    @Test
    public void moveObjectUpRight_relocateObjAndTryToMove_lostObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        ObjectInArea ExpectedObj = new ObjectInAreaStub();
        area.place(pos, ExpectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, ExpectedObj);
        area.remove(pos);

        Assertions.assertThrows(LostObjectException.class, () -> {
            manager.moveObjectUpRight();
        });
    }

    @Test
    public void moveObjectDownLeft_relocateObjAndTryToMove_lostObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        ObjectInArea ExpectedObj = new ObjectInAreaStub();
        area.place(pos, ExpectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, ExpectedObj);
        area.remove(pos);

        Assertions.assertThrows(LostObjectException.class, () -> {
            manager.moveObjectDownLeft();
        });
    }

    @Test
    public void moveObjectDownRight_relocateObjAndTryToMove_lostObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        ObjectInArea ExpectedObj = new ObjectInAreaStub();
        area.place(pos, ExpectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, ExpectedObj);
        area.remove(pos);

        Assertions.assertThrows(LostObjectException.class, () -> {
            manager.moveObjectDownRight();
        });
    }

    @Test
    public void moveObjectToPosition_relocateObjAndTryToMove_lostObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        ObjectInArea ExpectedObj = new ObjectInAreaStub();
        area.place(pos, ExpectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, ExpectedObj);
        area.remove(pos);

        Assertions.assertThrows(LostObjectException.class, () -> {
            manager.moveObjectToPosition(pos);
        });
    }

    // ======================================================================

    @Test
    public void constructor_giveCorrectData_managerCreated() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea obj = new ObjectInAreaStub();
        area.place(pos, obj);

        new ObjectManagerStub(pos, area, obj);
    }

    @Test
    public void constructor_giveNotCorrectDate_lostObjectExceptionThrew() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea obj = new ObjectInAreaStub();

        Assertions.assertThrows(LostObjectException.class, () -> {
            new ObjectManagerStub(pos, area, obj);
        });
    }

    @Test
    public void getArea_call_areaReturned() throws PositionException {
        CheckeredArea expectedArea = new CheckeredAreaStub();
        CheckeredArea actualArea;
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea obj = new ObjectInAreaStub();
        expectedArea.place(pos, obj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, expectedArea, obj);

        actualArea = manager.getAreaCallForTest();

        Assertions.assertEquals(expectedArea, actualArea);
    }

    @Test
    public void getObject_call_objectReturned() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2D pos = new IntegerPosition2DStub();
        ObjectInArea expectedObj = new ObjectInAreaStub();
        ObjectInArea actualObj;
        area.place(pos, expectedObj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, expectedObj);

        actualObj = manager.getObjectCallForTest();

        Assertions.assertEquals(expectedObj, actualObj);
    }

    @Test
    public void getCurrentPosition_callAtStart_positionWhereObjIsReturned() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2D expectedPos = new IntegerPosition2DStub();
        IntegerPosition2D actualPos;
        ObjectInArea obj = new ObjectInAreaStub();
        area.place(expectedPos, obj);
        ObjectManagerStub manager = new ObjectManagerStub(expectedPos, area, obj);

        actualPos = manager.getCurrentPositionCallForTest();

        Assertions.assertEquals(expectedPos, actualPos);
    }

    @Test
    public void getCurrentPosition_callAfter1Move_positionWhereObjIsReturned() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        IntegerPosition2D expectedPos = pos.getOther();
        IntegerPosition2D actualPos;
        ObjectInArea obj = new ObjectInAreaStub();
        area.place(pos, obj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, obj);

        manager.moveObjectToPosition(expectedPos);
        actualPos = manager.getCurrentPositionCallForTest();

        Assertions.assertEquals(expectedPos, actualPos);
    }

    @Test
    public void getCurrentPosition_callAfterALotOfMoves_positionWhereObjIsReturned() throws PositionException {
        CheckeredArea area = new CheckeredAreaStub();
        IntegerPosition2DStub pos = new IntegerPosition2DStub();
        IntegerPosition2D expectedPos = pos.getOther();
        IntegerPosition2D actualPos;
        ObjectInArea obj = new ObjectInAreaStub();
        area.place(pos, obj);
        ObjectManagerStub manager = new ObjectManagerStub(pos, area, obj);

        for (int i = 0; i < 10000; i++) {
            pos = pos.getOther();
            manager.moveObjectToPosition(pos);
        }
        manager.moveObjectToPosition(expectedPos);
        actualPos = manager.getCurrentPositionCallForTest();

        Assertions.assertEquals(expectedPos, actualPos);
    }
}
