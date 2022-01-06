package game_logic.abstractions.interfaces;

import game_logic.abstractions.basis_exceptions.PositionException;

public interface ZoneVisualization {
    void setField(CheckeredZone field);

    void showField() throws PositionException;

    default public void close() {
    }
}
