package field_logic;

import field_logic.intarfaces.iDot;
import field_logic.intarfaces.iField;
import field_logic.intarfaces.iObjectOnField;

public class ObjectOnField implements iObjectOnField {
    iField field;
    iDot pos;

    ObjectOnField(iField field, iDot pos) {
        this.field = field;
        this.pos = pos;
    }
}
