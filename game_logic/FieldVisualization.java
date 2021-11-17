package game_logic;

import game_logic.intarfaces.Location;
import game_logic.intarfaces.LocationVisualizationImp;

public class FieldVisualization implements LocationVisualizationImp {
    Location field;

    public FieldVisualization(Location field) {
        this.field = field;
    }

    public FieldVisualization() {
    }

    public void setField(Location field) {
        this.field = field;
    }

    public void showField() {
        printLine();
        printField();
        printLine();
    }

    private void printLine() {
        for (int i = field.getXMinLimit(); i <= field.getXMaxLimit(); i++) {
            System.out.print("--");
        }
        System.out.println();
    }

    private void printField() {
        for (int y = field.getYMaxLimit(); y >= field.getYMinLimit(); y--) {
            for (int x = field.getXMinLimit(); x < field.getXMaxLimit(); x++) {
                System.out.print(' ');
                System.out.print(field.getObject(new Pos(x, y)));
            }
            System.out.println(y);
        }
    }
}
