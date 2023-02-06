package Tests.visualization;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.Test;

import Tests.area.CheckeredAreaStub;
import Tests.area.position.IntegerPosition2DStub;
import TheBadParodyToGame.ObjectsInArea.player.Player;
import TheBadParodyToGame.area.CheckeredAreaContainsAll;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;
import TheBadParodyToGame.visualization.AreaWithPlayerInCenterAdapter;

public class AreaWithPlayerInCenterAdaptorTest {
    @Test
    public void convertPos() throws PositionException {
        Random random = new Random();
        IntegerPosition2D playerPos = new IntegerPosition2DStub();
        int xDiff = random.nextInt(-1000000, 1000000);
        int yDiff = random.nextInt(-1000000, 1000000);
        IntegerPosition2D posWillBeConverted = new IntegerPosition2DStub(xDiff, yDiff);
        IntegerPosition2D expectedPos = new IntegerPosition2DStub(playerPos.getX() + xDiff, playerPos.getY() + yDiff);
        IntegerPosition2D actualPos;
        CheckeredAreaContainsAll area = new CheckeredAreaStub();
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
    public AreaWithPlayerInCenterAdaptorStub(CheckeredAreaContainsAll area, Player player) {
        super(area, player);
    }

    @Override
    public IntegerPosition2D convertPos(IntegerPosition2D pos) {
        return super.convertPos(pos);
    }
}
