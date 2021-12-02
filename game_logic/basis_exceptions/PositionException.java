package game_logic.basis_exceptions;

import game_logic.intarfaces.IntegerPos;

public class PositionException extends LocationException {
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
