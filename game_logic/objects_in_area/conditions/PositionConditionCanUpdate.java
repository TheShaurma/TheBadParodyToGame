package game_logic.objects_in_area.conditions;

import game_logic.abstractions.interfaces.Position;
import game_logic.objects_in_area.conditions.interfaces.ConditionCanUpdate;

public class PositionConditionCanUpdate implements ConditionCanUpdate<Position<?>> {
    Position<?> position;

    public Position<?> getValue() {
        return position;
    }

    public void setValue(Position<?> pos) {
        position = pos;
    }
}
