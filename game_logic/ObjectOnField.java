package game_logic;

import game_logic.intarfaces.iDot;
import game_logic.intarfaces.iField;
import game_logic.intarfaces.iObjectOnField;

public class ObjectOnField implements iObjectOnField {
    iField field;
    iDot pos;

    public ObjectOnField(iField field, iDot pos) {
        setField(field);
        setPos(pos);
    }

    public ObjectOnField(iField field, int x, int y) {
        setField(field);
        setPos(new Dot(x, y));
    }

    public String toString() {
        return "*";
    }

    //

    private void setField(iField field) {
        this.field = field;
    }

    private void setPos(iDot pos) {
        this.pos = pos;
    }
}
