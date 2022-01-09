package game_logic.objects_in_area.conditions.single.can_update;

import game_logic.abstractions.interfaces.Position;
import game_logic.objects_in_area.conditions.single.interfaces.can_update.PositionConditionCanUpdateImp;

public class PositionConditionCanUpdate<P extends Position<?>> implements PositionConditionCanUpdateImp<P> {
    private P position;

    public PositionConditionCanUpdate(P pos) {
        position = pos;
    }

    public P getValue() {
        return position;
    }

    public void setValue(P pos) {
        position = pos;
    }
}
