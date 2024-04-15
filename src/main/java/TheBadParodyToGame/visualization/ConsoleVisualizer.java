package TheBadParodyToGame.visualization;

import java.util.HashMap;

import TheBadParodyToGame.area.ConstantArea;
import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.ObjectInArea;
import TheBadParodyToGame.objectsInArea.movingObjects.player.Player;

/**
 * Visualizer
 */
public class ConsoleVisualizer {
    private ConstantArea<?> area;

    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    private Player player;

    public ConsoleVisualizer(ConstantArea<?> area, Position minPos, Position maxPos, Player player) {
        this.area = area;

        int x1 = minPos.getX();
        int x2 = maxPos.getX();
        xMin = Math.min(x1, x2);
        xMax = Math.max(x1, x2);

        int y1 = minPos.getY();
        int y2 = maxPos.getY();
        yMin = Math.min(y1, y2);
        yMax = Math.max(y1, y2);

        this.player = player;
    }

    public void showGame() throws PositionCannotExistInAreaException, EmptyPositionException {
        System.out.println(player.getHPString() + " - " + player.getName());
        System.out.println(getAreaString());
    }

    public String getAreaString() throws PositionCannotExistInAreaException {

        String result = "";
        result += " ";
        for (int x = xMin; x <= xMax; x++) {
            if (x == 0) {
                result += "X";
            } else {
                result += Math.abs(x % 10);
            }
        }
        result += '\n';

        for (int y = yMax; y >= yMin; y--) {
            result += "|";

            for (int x = xMin; x <= xMax; x++) {
                Position currentPos = new GamePosition(x, y);

                try {
                    ObjectInArea obj = area.get(currentPos);
                    String str = String.valueOf(obj.getChar());
                    result += str;
                } catch (EmptyPositionException e) {
                    result += " ";
                }
            }
            result += y;
            result += '\n';
        }
        for (int x = xMin; x <= xMax; x++) {
            result += "=";
        }
        // result += '\n';

        return result;
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
