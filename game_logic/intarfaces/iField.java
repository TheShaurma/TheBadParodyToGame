package game_logic.intarfaces;

public interface iField {
    void putObject(iDot pos, iObjectOnField obj);

    void putObject(int x, int y, iObjectOnField obj);

    iObjectOnField getObject(iDot pos);

    iObjectOnField getObject(int x, int y);

    void removeObject(iDot pos);

    void removeObject(int x, int y);

    void iteration();

    int getXMinLimit();

    int getXMaxLimit();

    int getYMinLimit();

    int getYMaxLimit();
}
