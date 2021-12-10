package game_logic.objects_on_location.object_abstractions;

import game_logic.abstractions.interfaces.Location;
import game_logic.abstractions.interfaces.ObjectOnLocation;
import game_logic.objects_on_location.conditions.LocationCondition;
import game_logic.objects_on_location.conditions.interfaces.LocationConditionImp;

public abstract class ObjectKnowsLocation implements ObjectOnLocation {
    private LocationConditionImp locationCondition;

    public ObjectKnowsLocation(Location loc) {
        locationCondition = new LocationCondition(loc);
    }

    protected ObjectKnowsLocation(LocationConditionImp locationCond) {
        locationCondition = locationCond;
    }

    protected LocationConditionImp getLocationCondition() {
        return locationCondition;
    }
}
