package game_logic.objects_on_location.conditions;

import game_logic.abstractions.interfaces.Location;
import game_logic.objects_on_location.conditions.interfaces.cannot_update.LocationConditionImp;

public class LocationCondition implements LocationConditionImp {
    private final Location location;

    public LocationCondition(Location loc) {
        location = loc;
    }

    public Location getLocation() {
        return location;
    }
}
