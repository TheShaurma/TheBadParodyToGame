package game_logic.objects_in_area.conditions.single;

import game_logic.abstractions.interfaces.Position;
import game_logic.objects_in_area.conditions.single.interfaces.PositionConditionCanUpdateImp;

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
