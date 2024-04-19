package TheBadParodyToGame.area.position;

import java.util.Random;
import static java.lang.Math.min;
import static java.lang.Math.max;

public class Positions {
    private Positions() {
    }

    private static final Random random = new Random();

    public static Position[] get8NearestPositionsTo(Position pos) {
        Position[] result = new Position[8];
        Position[] nearest4 = get4NearestPositionsTo(pos);

        result[0] = nearest4[0];
        result[1] = nearest4[1];
        result[2] = nearest4[2];
        result[3] = nearest4[3];
        result[4] = pos.getUpLeft();
        result[5] = pos.getUpRight();
        result[6] = pos.getDownLeft();
        result[7] = pos.getDownRight();

        return result;
    }

    public static Position[] get4NearestPositionsTo(Position pos) {
        Position[] result = new Position[4];

        result[0] = pos.getUp();
        result[1] = pos.getDown();
        result[2] = pos.getLeft();
        result[3] = pos.getRight();

        return result;
    }

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
