package game_logic.objects_on_zone.conditions;

import game_logic.abstractions.interfaces.Zone;
import game_logic.objects_on_zone.conditions.interfaces.cannot_update.LocationConditionImp;

public class LocationCondition implements LocationConditionImp {
    private final Zone location;

    public LocationCondition(Zone loc) {
        location = loc;
    }

    public Zone getLocation() {
        return location;
    }
}
