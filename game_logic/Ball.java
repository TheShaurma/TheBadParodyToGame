package game_logic;

import game_logic.intarfaces.IntegerPos;
import game_logic.intarfaces.Location;
import game_logic.intarfaces.ObjectOnField;

public class Ball implements ObjectOnField {
    private Location field;
    private IntegerPos pos;

    public Ball(Location field, IntegerPos pos) {
        setField(field);
        setPos(pos);
    }

    public Ball(Location field, int x, int y) {
        setField(field);
        setPos(new Pos(x, y));
    }

    public String toString() {
        return "*";
    }

    //

    private void setField(Location field) {
        this.field = field;
    }

    private void setPos(IntegerPos pos) {
        this.pos = pos;
    }
}
