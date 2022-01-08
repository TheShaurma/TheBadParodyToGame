package game_logic.objects_in_area.objects_abstractions.can_moving;

import game_logic.IntegerPosition;
import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.CheckeredArea;
import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_in_area.conditions.Direction;
import game_logic.objects_in_area.conditions.multiple.ConditionOfAreaPositionAndDirection;
import game_logic.objects_in_area.conditions.multiple.interfaces.ConditionOfAreaPositionAndDirectionImp;
import game_logic.objects_in_area.conditions.single.AreaCondition;
import game_logic.objects_in_area.conditions.single.DirectionConditionCanUpdate;
import game_logic.objects_in_area.conditions.single.PositionConditionCanUpdate;
import game_logic.objects_in_area.conditions.single.interfaces.AreaConditionImp;
import game_logic.objects_in_area.conditions.single.interfaces.DirectionConditionCanUpdateImp;
import game_logic.objects_in_area.conditions.single.interfaces.PositionConditionCanUpdateImp;
import game_logic.objects_in_area.objects_abstractions.can_moving.exceptions.BusyPositionException;

public abstract class ObjectCanMovingByCurrentDirectionInCheckeredArea extends
        ObjectCanMoving<CheckeredArea, IntegerPos, ConditionOfAreaPositionAndDirectionImp<AreaConditionImp<CheckeredArea>, PositionConditionCanUpdateImp<IntegerPos>, DirectionConditionCanUpdateImp>> {

    public ObjectCanMovingByCurrentDirectionInCheckeredArea(CheckeredArea area, IntegerPos pos, Direction dir)
            throws PositionException {
        super(new ConditionOfAreaPositionAndDirection<>(
                new AreaCondition<>(area),
                new PositionConditionCanUpdate<>(pos),
                new DirectionConditionCanUpdate(dir)));
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
