package field_logic;

import field_logic.intarfaces.iField;
import field_logic.intarfaces.iObjectOnField;

public class ObjectOnField implements iObjectOnField {
    iField field;

    ObjectOnField(iField field) {
        this.field = field;
    }
}
