package game_logic.objects_on_location.conditions.interfaces;

import game_logic.objects_on_location.conditions.Direction;

public interface DirectionConditionImp {
    Direction getDirection();

    void updateDirection(Direction dir);
}
