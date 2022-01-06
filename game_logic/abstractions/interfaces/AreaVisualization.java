package game_logic.abstractions.interfaces;

import game_logic.abstractions.basis_exceptions.PositionException;

public interface AreaVisualization {
    void setField(CheckeredArea field);

    void showField() throws PositionException;

    default public void close() {
    }
}
