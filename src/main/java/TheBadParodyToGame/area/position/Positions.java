package TheBadParodyToGame.area.position;

import java.util.Random;
import static java.lang.Math.min;
import static java.lang.Math.max;

public class Positions {
    private static final Random random = new Random();

    public static Position getRandomPosition(Position minPos, Position maxPos) {
        int minX = min(minPos.getX(), maxPos.getX());
        int maxX = max(minPos.getX(), maxPos.getX());
        int minY = min(minPos.getY(), maxPos.getY());
        int maxY = max(minPos.getY(), maxPos.getY());

        int x = getRandomIntInBorders(minX, maxX);
        int y = getRandomIntInBorders(minY, maxY);

        return new GamePosition(x, y);
    }

    protected static int getRandomIntInBorders(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
