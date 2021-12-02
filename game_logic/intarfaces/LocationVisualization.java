package game_logic.intarfaces;

import game_logic.basis_exceptions.PositionException;

public interface LocationVisualization {
    void setField(Location field);

    void showField() throws PositionException;
}
