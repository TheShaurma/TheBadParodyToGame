package game_logic.intarfaces;

public interface iField {
    void putObject(iPos pos, iObjectOnField obj);

    void putObject(int x, int y, iObjectOnField obj);

    iObjectOnField getObject(iPos pos);

    iObjectOnField getObject(int x, int y);

    void removeObject(iPos pos);

    void removeObject(int x, int y);

    //

    int getXMinLimit();

    int getXMaxLimit();

    int getYMinLimit();

    int getYMaxLimit();
}
