package game_logic.objects_on_location.conditions.with_past;

import game_logic.objects_on_location.conditions.Direction;
import game_logic.objects_on_location.conditions.DirectionCondition;
import game_logic.objects_on_location.conditions.interfaces.DirectionConditionImp;
import game_logic.objects_on_location.conditions.interfaces.with_past.DirectionConditionWithPastImp;

public class DirectionConditionWithPast extends DirectionCondition implements DirectionConditionWithPastImp {
    private DirectionCondition past;

    public DirectionConditionWithPast(Direction dir) {
        super(dir);
        past = new DirectionCondition(dir);
    }

    public DirectionConditionImp getPast() {
        return past;
    }
}
