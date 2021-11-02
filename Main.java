import game_logic.Field;
import game_logic.FieldVisualization;
import game_logic.ObjectOnField;
import game_logic.intarfaces.iDot;
import game_logic.Dot;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        iDot pos = new Dot(0, 0);
        ObjectOnField obj = new ObjectOnField(field, pos);
        field.putObject(pos, obj);
        FieldVisualization visual = new FieldVisualization();

        visual.showField();
    }
}
