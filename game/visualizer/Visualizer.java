package game.visualizer;

import java.util.HashMap;

import game.ObjectsInArea.ObjectInArea;
import game.area.GameArea;
import game.area.IntegerPosition2D;
import game.area.PositionException;

/**
 * Visualizer
 */
public class Visualizer {
    private GameArea area;

    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    private HashMap<Class<?>, Color> visualMap = new ColorMap();
    private HashMap<Class<?>, String> consoleVisualMap = new SymbolMap();

    public Visualizer(IntegerPosition2D minPos, IntegerPosition2D maxPos, GameArea area) {
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

    public HashMap<Class<?>, Color> getVisualMap() {
        return visualMap;
    }

    public HashMap<Class<?>, String> getConsoleVisualMap() {
        return consoleVisualMap;
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
                IntegerPosition2D currentPos = new IntegerPosition2D(x, y);

                if (area.positionIsEmpty(currentPos)) {
                    System.out.print(" ");
                } else {
                    ObjectInArea obj = area.get(currentPos);
                    Class<?> objClass = obj.getClass();
                    String str = consoleVisualMap.get(objClass);
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

class ColorMap extends HashMap<Class<?>, Color> {
    @Override
    public Color get(Object key) {
        Color out = super.get(key);

        if (out == null) {
            return new Color(200, 50, 200);
        } else {
            return out;
        }
    }
}