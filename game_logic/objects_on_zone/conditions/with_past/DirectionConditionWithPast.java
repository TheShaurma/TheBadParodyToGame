package game_logic.objects_on_zone.conditions.with_past;

import game_logic.objects_on_zone.conditions.Direction;
import game_logic.objects_on_zone.conditions.DirectionCondition;
import game_logic.objects_on_zone.conditions.interfaces.cannot_update.DirectionConditionCannotUpdateImp;
import game_logic.objects_on_zone.conditions.interfaces.with_past.DirectionConditionWithPastImp;

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
