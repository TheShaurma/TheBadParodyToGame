package game_logic.objects_in_area.conditions;

import game_logic.abstractions.interfaces.Position;
import game_logic.objects_in_area.conditions.interfaces.ConditionCanUpdate;
import game_logic.objects_in_area.conditions.interfaces.PositionConditionImp;

public class PositionConditionCanUpdate implements ConditionCanUpdate<Position<?>>, PositionConditionImp {
    Position<?> position;

    public Position<?> getValue() {
        return position;
    }

    public void setValue(Position<?> pos) {
        position = pos;
    }
}
