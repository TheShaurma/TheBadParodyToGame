import game_logic.Field;
import game_logic.FieldVisualization;
import game_logic.ObjectOnField;
import game_logic.intarfaces.iPos;

import game_logic.Pos;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        iPos pos = new Pos(0, 0);
        ObjectOnField obj = new ObjectOnField(field, pos);
        field.putObject(pos, obj);
        FieldVisualization visual = new FieldVisualization(field);

        visual.showField();
        System.out.println("The end!!!");
    }
}
