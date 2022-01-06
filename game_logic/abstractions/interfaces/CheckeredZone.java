package game_logic.abstractions.interfaces;

import game_logic.abstractions.basis_exceptions.PositionException;

public interface CheckeredZone {
    void putObject(IntegerPos pos, ObjectOnLocation obj) throws PositionException;

    void putObject(int x, int y, ObjectOnLocation obj) throws PositionException;

    ObjectOnLocation getObject(IntegerPos pos) throws PositionException;

    ObjectOnLocation getObject(int x, int y) throws PositionException;

    void removeObject(IntegerPos pos) throws PositionException;

    void removeObject(int x, int y) throws PositionException;

    //
    int getXMinLimit();

    int getXMaxLimit();

    int getYMinLimit();

    int getYMaxLimit();
}
