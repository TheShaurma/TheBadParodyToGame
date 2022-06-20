package area;

import java.util.HashMap;

/**
 * Visualizer
 */
public class Visualizer {
    private GameArea area;

    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    private HashMap<Class<?>, Color> visualMap = new HashMap<>();
    private HashMap<Class<?>, String> consoleVisualMap = new HashMap<>();

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
        for (int x = xMin; x <= xMax; x++) {
            System.out.print("=");
        }

        for (int y = yMax; y >= yMin; y--) {
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
            System.out.print("|");
            System.out.println();

            for (int x = xMin; x <= xMax; x++) {
                System.out.print("=");
            }
        }
    }
}