package game_logic.abstractions.basis_exceptions;

import game_logic.abstractions.interfaces.IntegerPos;

public class PositionException extends ZoneException {
    private IntegerPos position;

    public PositionException(IntegerPos pos) {
        setPosition(pos);
    }

    public IntegerPos getPosition() {
        return position;
    }

    private void setPosition(IntegerPos pos) {
        position = pos;
    }
}
