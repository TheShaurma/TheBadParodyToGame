package game_logic.objects_on_location.object_conditions;

import game_logic.abstractions.interfaces.Location;
import game_logic.objects_on_location.object_conditions.interfaces.ObjectConditionOfLocationImp;

public class ObjectConditionOfLocation implements ObjectConditionOfLocationImp {
    private final Location location;

    public ObjectConditionOfLocation(Location loc) {
        location = loc;
    }

    public Location getLocation() {
        return location;
    }
}
