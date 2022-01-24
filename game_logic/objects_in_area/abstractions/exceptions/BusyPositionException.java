package game_logic.objects_in_area.abstractions.exceptions;

import game_logic.abstractions.basis_exceptions.ObjectOnAreaException;
import game_logic.abstractions.interfaces.Position;

public class BusyPositionException extends ObjectOnAreaException {
    private Position<?> position;

    public BusyPositionException(Position<?> pos) {
        position = pos;
    }

    public Position<?> getPosition() {
        return position;
    }
}
