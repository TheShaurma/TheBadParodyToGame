package game_logic.objects_in_area.conditions.with_past;

import game_logic.objects_in_area.conditions.Direction;
import game_logic.objects_in_area.conditions.DirectionCondition;
import game_logic.objects_in_area.conditions.interfaces.cannot_update.DirectionConditionCannotUpdateImp;
import game_logic.objects_in_area.conditions.interfaces.with_past.DirectionConditionWithPastImp;

public class DirectionConditionWithPast extends DirectionCondition implements DirectionConditionWithPastImp {
    private DirectionCondition past;

    public DirectionConditionWithPast(Direction dir) {
        super(dir);
        past = new DirectionCondition(dir);
    }

    public DirectionConditionCannotUpdateImp getPast() {
        return past;
    }

    @Override
    public void updateDirection(Direction dir) {
        past.updateDirection(getDirection());
        super.updateDirection(dir);
    }
}
