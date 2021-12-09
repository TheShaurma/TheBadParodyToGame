package game_logic.objects_on_location.object_abstractions;

import game_logic.abstractions.interfaces.Location;
import game_logic.abstractions.interfaces.ObjectOnLocation;
import game_logic.objects_on_location.conditions.ConditionOfLocation;
import game_logic.objects_on_location.conditions.interfaces.ConditionOfLocationImp;

public abstract class ObjectKnowsLocation implements ObjectOnLocation {
    private ConditionOfLocationImp locationCondition;

    public ObjectKnowsLocation(Location loc) {
        locationCondition = new ConditionOfLocation(loc);
    }

    protected ObjectKnowsLocation(ConditionOfLocationImp locationCond) {
        locationCondition = locationCond;
    }

    protected ConditionOfLocationImp getLocationCondition() {
        return locationCondition;
    }
}
