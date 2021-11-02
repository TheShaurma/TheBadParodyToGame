package game_logic;

import game_logic.intarfaces.iDot;
import game_logic.intarfaces.iField;
import game_logic.intarfaces.iObjectOnField;

public class ObjectOnField implements iObjectOnField {
    iField field;
    iDot pos;

    ObjectOnField(iField field, iDot pos) {
        this.field = field;
        this.pos = pos;
    }
}
