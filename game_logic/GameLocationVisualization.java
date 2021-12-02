package game_logic;

import game_logic.basis_exceptions.PositionException;
import game_logic.intarfaces.Location;
import game_logic.intarfaces.LocationVisualization;

public class GameLocationVisualization implements LocationVisualization {
    Location field;

    public GameLocationVisualization(Location field) {
        this.field = field;
    }

    public GameLocationVisualization() {
    }

    public void setField(Location field) {
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
