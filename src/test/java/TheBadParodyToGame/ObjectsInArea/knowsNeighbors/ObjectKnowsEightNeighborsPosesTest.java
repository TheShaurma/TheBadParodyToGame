package TheBadParodyToGame.objectsInArea.knowsNeighbors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionStub;

public class ObjectKnowsEightNeighborsPosesTest {
    @Test
    public void getUpLeftPos_call_upLeftPosGot() {
        PositionStub pos = new PositionStub();
        Position expected = pos.getUp().getLeft();
        ObjectKnowsEightNeighborsPoses obj = new ObjectKnowsEightNeighborsPosesStub(pos);
        Position actual = obj.getUpLeftPos();

        assertEquals(expected, actual);
    }

    @Test
    public void getUpRightPos_call_UpRightPosGot() {
        PositionStub pos = new PositionStub();
        Position expected = pos.getUp().getRight();
        ObjectKnowsEightNeighborsPoses obj = new ObjectKnowsEightNeighborsPosesStub(pos);
        Position actual = obj.getUpRightPos();

        assertEquals(expected, actual);
    }

    @Test
    public void getDownLeftPos_call_DownLeftPosGot() {
        PositionStub pos = new PositionStub();
        Position expected = pos.getDown().getLeft();
        ObjectKnowsEightNeighborsPoses obj = new ObjectKnowsEightNeighborsPosesStub(pos);
        Position actual = obj.getDownLeftPos();

        assertEquals(expected, actual);
    }

    @Test
    public void getDownRightPos_call_downRightPosGot() {
        PositionStub pos = new PositionStub();
        Position expected = pos.getDown().getRight();
        ObjectKnowsEightNeighborsPoses obj = new ObjectKnowsEightNeighborsPosesStub(pos);
        Position actual = obj.getDownRightPos();

        assertEquals(expected, actual);
    }

    @Test
    public void getAllPosition_call_allPositionsGot() {
        PositionStub pos = new PositionStub();
        ObjectKnowsEightNeighborsPoses obj = new ObjectKnowsEightNeighborsPosesStub(pos);
        var poses = Arrays.asList(obj.getAllNeighborsPositions());

        assertTrue(poses.contains(pos.getUp()));
        assertTrue(poses.contains(pos.getDown()));
        assertTrue(poses.contains(pos.getLeft()));
        assertTrue(poses.contains(pos.getRight()));
        assertTrue(poses.contains(pos.getUp().getLeft()));
        assertTrue(poses.contains(pos.getUp().getRight()));
        assertTrue(poses.contains(pos.getDown().getLeft()));
        assertTrue(poses.contains(pos.getDown().getRight()));
    }

    private class ObjectKnowsEightNeighborsPosesStub extends ObjectKnowsEightNeighborsPoses {
        public ObjectKnowsEightNeighborsPosesStub(Position pos) {
            super(pos);
        }
    }
}
