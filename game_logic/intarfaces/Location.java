package game_logic.intarfaces;

public interface Location {
    void putObject(IntegerPos pos, ObjectOnField obj);

    void putObject(int x, int y, ObjectOnField obj);

    ObjectOnField getObject(IntegerPos pos);

    ObjectOnField getObject(int x, int y);

    void removeObject(IntegerPos pos);

    void removeObject(int x, int y);

    //

    int getXMinLimit();

    int getXMaxLimit();

    int getYMinLimit();

    int getYMaxLimit();
}
