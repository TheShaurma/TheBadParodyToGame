package TheBadParodyToGame.visualization;

import java.util.HashMap;

import TheBadParodyToGame.area.ConstantArea;
import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionException;
import TheBadParodyToGame.objectsInArea.ObjectInArea;

/**
 * Visualizer
 */
public class SimpleVisualizer {
    private ConstantArea<?> area;

    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    public SimpleVisualizer(Position minPos, Position maxPos, ConstantArea<?> area) {
        this.area = area;
        int x1 = minPos.getX();
        int x2 = maxPos.getX();
        if (x1 > x2) {
            xMin = x2;
            xMax = x1;
        } else {
            xMin = x1;
            xMax = x2;
        }

        int y1 = minPos.getY();
        int y2 = maxPos.getY();
        if (y1 > y2) {
            yMin = y2;
            yMax = y1;
        } else {
            yMin = y1;
            yMax = y2;
        }
    }

    public void showConsole() throws PositionException {
        System.out.print(" ");
        for (int x = xMin; x <= xMax; x++) {
            if (x == 0) {
                System.out.print("X");
            } else {
                System.out.print(Math.abs(x % 10));
            }
        }
        System.out.println();

        for (int y = yMax; y >= yMin; y--) {
            System.out.print("|");

            for (int x = xMin; x <= xMax; x++) {
                Position currentPos = new GamePosition(x, y);

                if (area.positionIsEmpty(currentPos)) {
                    System.out.print(" ");
                } else {
                    ObjectInArea obj = area.get(currentPos);
                    String str = String.valueOf(obj.getChar());
                    System.out.print(str);
                }
            }
            System.out.print(y);
            System.out.println();

        }
        for (int x = xMin; x <= xMax; x++) {
            System.out.print("=");
        }
        System.out.println();
    }
}

class SymbolMap extends HashMap<Class<?>, String> {
    @Override
    public String get(Object key) {
        String out = super.get(key);

        if (out == null) {
            return "?";
        } else {
            return out;
        }
    }
}
