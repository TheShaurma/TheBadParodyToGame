package TheBadParodyToGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

import TheBadParodyToGame.area.AreaStub;
import TheBadParodyToGame.area.position.PositionStub;
import TheBadParodyToGame.ObjectsInArea.player.Player;
import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionException;
import TheBadParodyToGame.visualization.AreaWithPlayerInCenterAdapter;

public class AreaWithPlayerInCenterAdaptorTest {
    @Test
    public void convertPos() throws PositionException {
        Random random = new Random();
        Position playerPos = new PositionStub();
        int xDiff = random.nextInt(-1000000, 1000000);
        int yDiff = random.nextInt(-1000000, 1000000);
        Position posWillBeConverted = new PositionStub(xDiff, yDiff);
        Position expectedPos = new PositionStub(playerPos.getX() + xDiff, playerPos.getY() + yDiff);
        Position actualPos;
        AreaContainsAll area = new AreaStub();
        Player player = new Player(area, playerPos);
        AreaWithPlayerInCenterAdaptorStub playerArea = new AreaWithPlayerInCenterAdaptorStub(area, player);

        actualPos = playerArea.convertPos(posWillBeConverted);
        int expectedX = expectedPos.getX();
        int expectedY = expectedPos.getY();
        int actualX = actualPos.getX();
        int actualY = actualPos.getY();

        assertEquals(expectedX, actualX);
        assertEquals(expectedY, actualY);
    }
}

class AreaWithPlayerInCenterAdaptorStub extends AreaWithPlayerInCenterAdapter {
    public AreaWithPlayerInCenterAdaptorStub(AreaContainsAll area, Player player) {
        super(area, player);
    }

    @Override
    public Position convertPos(Position pos) {
        return super.convertPos(pos);
    }
}
