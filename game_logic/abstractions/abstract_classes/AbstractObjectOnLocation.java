package game_logic.abstractions.abstract_classes;

import game_logic.abstractions.intarfaces.IntegerPos;
import game_logic.abstractions.intarfaces.Location;
import game_logic.abstractions.intarfaces.ObjectOnLocation;

public abstract class AbstractObjectOnLocation implements ObjectOnLocation {
    private Location location;
    private IntegerPos position;

    //

    protected Location getLocation() {
        return location;
    }

    protected void setLocation(Location location) {
        this.location = location;
    }

    protected IntegerPos getBallPosition() {
        return position;
    }

    protected void setPosition(IntegerPos position) {
        this.position = position;
    }
}
