package game_logic.objects_on_zone.conditions;

import game_logic.abstractions.interfaces.CheckeredZone;
import game_logic.objects_on_zone.conditions.interfaces.cannot_update.LocationConditionImp;

public class LocationCondition implements LocationConditionImp {
    private final CheckeredZone location;

    public LocationCondition(CheckeredZone loc) {
        location = loc;
    }

    public CheckeredZone getLocation() {
        return location;
    }
}
