package game_logic.abstractions.intarfaces;

import game_logic.abstractions.basis_exceptions.PositionException;

public interface LocationVisualization {
    void setField(Location field);

    void showField() throws PositionException;
}
