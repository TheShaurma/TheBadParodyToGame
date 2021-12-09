package game_logic.objects_on_location.conditions;

import game_logic.abstractions.interfaces.Location;
import game_logic.objects_on_location.conditions.interfaces.ConditionOfLocationImp;

public class ConditionOfLocation implements ConditionOfLocationImp {
    private final Location location;

    public ConditionOfLocation(Location loc) {
        location = loc;
    }

    public Location getLocation() {
        return location;
    }
}
