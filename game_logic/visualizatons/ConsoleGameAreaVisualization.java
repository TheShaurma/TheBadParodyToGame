package game_logic.visualizatons;

import game_logic.IntegerPosition;
import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.CheckeredArea;
import game_logic.abstractions.interfaces.AreaVisualization;

public class ConsoleGameAreaVisualization implements AreaVisualization {
    CheckeredArea field;

    public ConsoleGameAreaVisualization(CheckeredArea field) {
        this.field = field;
    }

    public ConsoleGameAreaVisualization() {
    }

    public void setField(CheckeredArea field) {
        this.field = field;
    }

    public void showField() throws PositionException {
        printNumericLine();
        printField();
        printLine();
    }

    private void printNumericLine() {
        for (int i = field.getXMinLimit(); i <= field.getXMaxLimit(); i++) {
            System.out.print("-" + i % 10);
        }
        System.out.println();
    }

    private void printLine() {
        for (int i = field.getXMinLimit(); i <= field.getXMaxLimit(); i++) {
            System.out.print("--");
        }
        System.out.println();
    }

    private void printField() throws PositionException {
        for (int y = field.getYMaxLimit(); y >= field.getYMinLimit(); y--) {
            for (int x = field.getXMinLimit(); x <= field.getXMaxLimit(); x++) {
                System.out.print(' ');
                System.out.print(field.getObject(new IntegerPosition(x, y)));
            }
            System.out.println(y);
        }
    }
}
