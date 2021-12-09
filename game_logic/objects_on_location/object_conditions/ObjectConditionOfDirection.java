package game_logic.objects_on_location.object_conditions;

import game_logic.objects_on_location.object_conditions.interfaces.ObjectConditionOfDirectionImp;

public class ObjectConditionOfDirection implements ObjectConditionOfDirectionImp {
    private ObjectDirection direction;

    public ObjectConditionOfDirection(ObjectDirection dir) {
        direction = dir;
    }

    public void updateDirection(ObjectDirection dir) {
        direction = dir;
    }

    public ObjectDirection getDirection() {
        return direction;
    }
}
