package game_logic.objects_in_area.objects_abstractions.can_moving;

import game_logic.IntegerPosition;
import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.CheckeredArea;
import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_in_area.conditions.Direction;
import game_logic.objects_in_area.conditions.multiple.interfaces.ConditionOfAreaPositionAndDirectionImp;
import game_logic.objects_in_area.conditions.single.interfaces.AreaConditionImp;
import game_logic.objects_in_area.conditions.single.interfaces.can_update.DirectionConditionCanUpdateImp;
import game_logic.objects_in_area.conditions.single.interfaces.can_update.PositionConditionCanUpdateImp;
import game_logic.objects_in_area.objects_abstractions.can_moving.exceptions.BusyPositionException;

public abstract class ObjectCanMovingByCurrentDirectionInCheckeredArea<C extends ConditionOfAreaPositionAndDirectionImp<? extends AreaConditionImp<CheckeredArea>, ? extends PositionConditionCanUpdateImp<IntegerPos>, ? extends DirectionConditionCanUpdateImp>>
        extends ObjectCanMoving<CheckeredArea, IntegerPos, C> {

    protected ObjectCanMovingByCurrentDirectionInCheckeredArea(C condWillBeUse) throws PositionException {
        super(condWillBeUse);
    }

    protected void moveByCurrentDirection() throws PositionException, BusyPositionException {
        Direction dir = getCondition().getDirectionCondition().getValue();
        moveByDirection(dir);
    }

    private void moveByDirection(Direction dir) throws PositionException, BusyPositionException {
        if (dir == Direction.UP) {
            moveUp();
        } else if (dir == Direction.DOWN) {
            moveDown();
        } else if (dir == Direction.LEFT) {
            moveLeft();
        } else if (dir == Direction.RIGHT) {
            moveRight();
        } else if (dir == Direction.UP_LEFT) {
            moveUpLeft();
        } else if (dir == Direction.UP_RIGHT) {
            moveUpRight();
        } else if (dir == Direction.DOWN_LEFT) {
            moveDownLeft();
        } else if (dir == Direction.DOWN_RIGHT) {
            moveDownRight();
        }
    }

    private void moveDownRight() throws PositionException, BusyPositionException {
        int newX = getCondition().getPositionCondition().getValue().getX();
        int newY = getCondition().getPositionCondition().getValue().getY();
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPosition(newPos);
    }

    private void moveDownLeft() throws PositionException, BusyPositionException {
        int newX = getCondition().getPositionCondition().getValue().getX();
        int newY = getCondition().getPositionCondition().getValue().getY();
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPosition(newPos);
    }

    private void moveUpRight() throws PositionException, BusyPositionException {
        int newX = getCondition().getPositionCondition().getValue().getX();
        int newY = getCondition().getPositionCondition().getValue().getY();
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPosition(newPos);
    }

    private void moveRight() throws PositionException, BusyPositionException {
        int newX = getCondition().getPositionCondition().getValue().getX();
        int newY = getCondition().getPositionCondition().getValue().getY();
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPosition(newPos);
    }

    private void moveUpLeft() throws PositionException, BusyPositionException {
        int newX = getCondition().getPositionCondition().getValue().getX();
        int newY = getCondition().getPositionCondition().getValue().getY();
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPosition(newPos);
    }

    private void moveLeft() throws PositionException, BusyPositionException {
        int newX = getCondition().getPositionCondition().getValue().getX();
        int newY = getCondition().getPositionCondition().getValue().getY();
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPosition(newPos);
    }

    private void moveDown() throws PositionException, BusyPositionException {
        int newX = getCondition().getPositionCondition().getValue().getX();
        int newY = getCondition().getPositionCondition().getValue().getY();
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPosition(newPos);
    }

    private void moveUp() throws PositionException, BusyPositionException {
        int newX = getCondition().getPositionCondition().getValue().getX();
        int newY = getCondition().getPositionCondition().getValue().getY();
        IntegerPos newPos = new IntegerPosition(newX, newY);

        moveToPosition(newPos);
    }
}
