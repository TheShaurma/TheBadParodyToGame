package game_logic.visualizatons;

import game_logic.IntegerPosition;
import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.Zone;
import game_logic.abstractions.interfaces.ZoneVisualization;

public class ConsoleGameLocationVisualization implements ZoneVisualization {
    Zone field;

    public ConsoleGameLocationVisualization(Zone field) {
        this.field = field;
    }

    public ConsoleGameLocationVisualization() {
    }

    public void setField(Zone field) {
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
