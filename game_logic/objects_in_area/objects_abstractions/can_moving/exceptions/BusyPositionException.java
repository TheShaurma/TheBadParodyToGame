package game_logic.objects_in_area.objects_abstractions.can_moving.exceptions;

import game_logic.abstractions.interfaces.Position;

public class BusyPositionException extends Exception {
    private final Position<?> position;

    public BusyPositionException(Position<?> pos) {
        position = pos;
    }

    public Position<?> getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return getPosition() + "is busy.";
    }
}
