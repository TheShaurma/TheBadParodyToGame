package game_logic.intarfaces;

public interface Location {
    void putObject(IntegerPos pos, ObjectOnLocation obj);

    void putObject(int x, int y, ObjectOnLocation obj);

    ObjectOnLocation getObject(IntegerPos pos);

    ObjectOnLocation getObject(int x, int y);

    void removeObject(IntegerPos pos);

    void removeObject(int x, int y);

    //

    int getXMinLimit();

    int getXMaxLimit();

    int getYMinLimit();

    int getYMaxLimit();
}
