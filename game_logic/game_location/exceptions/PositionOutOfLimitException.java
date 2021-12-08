package game_logic.game_location.exceptions;

import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.intarfaces.IntegerPos;

public class PositionOutOfLimitException extends PositionException {
    private Limit limit;

    public PositionOutOfLimitException(IntegerPos pos, Limit lim) {
        super(pos);
        setLimit(lim);
    }

    public Limit getLimit() {
        return limit;
    }

    private void setLimit(Limit lim) {
        limit = lim;
    }

}
