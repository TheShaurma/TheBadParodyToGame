package game_logic;

import game_logic.intarfaces.iPos;
import game_logic.intarfaces.iField;
import game_logic.intarfaces.iObjectOnField;

public class ObjectOnField implements iObjectOnField {
    private iField field;
    private iPos pos;

    public ObjectOnField(iField field, iPos pos) {
        setField(field);
        setPos(pos);
    }

    public ObjectOnField(iField field, int x, int y) {
        setField(field);
        setPos(new Pos(x, y));
    }

    public String toString() {
        return "*";
    }

    //

    private void setField(iField field) {
        this.field = field;
    }

    private void setPos(iPos pos) {
        this.pos = pos;
    }
}
