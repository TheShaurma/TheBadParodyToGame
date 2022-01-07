package game_logic.abstractions.interfaces;

import game_logic.abstractions.basis_exceptions.PositionException;

public interface Area<PT extends Position<?>> {
    void putObject(PT pos, ObjectInArea obj) throws PositionException;

    void putObject(int x, int y, ObjectInArea obj) throws PositionException;

    ObjectInArea getObject(PT pos) throws PositionException;

    ObjectInArea getObject(int x, int y) throws PositionException;

    void removeObject(PT pos) throws PositionException;

    void removeObject(int x, int y) throws PositionException;

    boolean posIsEmpty(PT pos) throws PositionException;

    //
    int getXMinLimit();

    int getXMaxLimit();

    int getYMinLimit();

    int getYMaxLimit();
}
