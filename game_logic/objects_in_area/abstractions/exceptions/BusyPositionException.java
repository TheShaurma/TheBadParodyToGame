package game_logic.objects_in_area.abstractions.exceptions;

import game_logic.abstractions.interfaces.Position;
import game_logic.abstractions.basis_exceptions.AreaException;

public class BusyPositionException extends AreaException {
    private Position<?> position;

    public BusyPositionException(Position<?> pos) {
        position = pos;
    }

    @Override
    public String toString() {
        return position + "is busy";
    }
}
