package game_logic.objects_on_location.object_conditions.interfaces;

import game_logic.objects_on_location.object_conditions.ObjectDirection;

public interface ObjectConditionOfDirectionImp {
    ObjectDirection getDirection();

    void updateDirection(ObjectDirection dir);
}
