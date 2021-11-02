package game_logic;

import game_logic.intarfaces.iField;
import game_logic.intarfaces.iFieldVisualization;

public class FieldVisualization implements iFieldVisualization {
    iField field;

    public void setField(iField field) {
        this.field = field;
    }

    public void showField() {
        printLine();
        printField();
        printLine();
    }

    private void printLine() {
        for (

                int i = field.getXMinLimit(); i <= field.getXMaxLimit(); i++) {
            System.out.print('-');
        }
    }

    private void printField() {
        for (int y = field.getYMaxLimit(); y <= field.getYMaxLimit(); y--) {
            for (int x = field.getXMinLimit(); x < field.getXMaxLimit(); x++) {
                System.out.print(' ');
                System.out.print(field.getObject(new Dot(x, y)));
            }
            System.out.println();
        }
    }
}
