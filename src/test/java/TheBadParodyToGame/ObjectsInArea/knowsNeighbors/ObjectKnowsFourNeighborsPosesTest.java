package TheBadParodyToGame.objectsInArea.knowsNeighbors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import TheBadParodyToGame.area.AreaStub;
import TheBadParodyToGame.area.ConstantArea;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionStub;
import TheBadParodyToGame.objectsInArea.ObjectInArea;

public class ObjectKnowsFourNeighborsPosesTest {
    @Test
    public void getUpPos_call_upPosGot() {
        PositionStub pos = new PositionStub();
        Position expected = pos.getUp();
        ObjectKnowsFourNeighborsPoses<ConstantArea<ObjectInArea>> obj = new ObjectKnowsFourNeighborsPosesStub(area,
                pos);
        Position actual = obj.getUpPos();

        assertEquals(expected, actual);
    }

    @Test
    public void getDownPos_call_downPosGot() {
        PositionStub pos = new PositionStub();
        Position expected = pos.getDown();
        ObjectKnowsFourNeighborsPoses<ConstantArea<ObjectInArea>> obj = new ObjectKnowsFourNeighborsPosesStub(area,
                pos);
        Position actual = obj.getDownPos();

        assertEquals(expected, actual);
    }

    @Test
    public void getLeftPos_call_LeftPosGot() {
        PositionStub pos = new PositionStub();
        Position expected = pos.getLeft();
        ObjectKnowsFourNeighborsPoses<ConstantArea<ObjectInArea>> obj = new ObjectKnowsFourNeighborsPosesStub(area,
                pos);
        Position actual = obj.getLeftPos();

        assertEquals(expected, actual);
    }

    @Test
    public void getRightPos_call_RightPosGot() {
        PositionStub pos = new PositionStub();
        Position expected = pos.getRight();
        ObjectKnowsFourNeighborsPoses<ConstantArea<ObjectInArea>> obj = new ObjectKnowsFourNeighborsPosesStub(area,
                pos);
        Position actual = obj.getRightPos();

        assertEquals(expected, actual);
    }

    @Test
    public void getAllPosition_call_allPositionsGot() {
        PositionStub pos = new PositionStub();
        ObjectKnowsFourNeighborsPoses<ConstantArea<ObjectInArea>> obj = new ObjectKnowsFourNeighborsPosesStub(area,
                pos);
        var poses = Arrays.asList(obj.getAllNeighborsPositions());

        assertTrue(poses.contains(pos.getUp()));
        assertTrue(poses.contains(pos.getDown()));
        assertTrue(poses.contains(pos.getLeft()));
        assertTrue(poses.contains(pos.getRight()));
    }

    private static final ConstantArea<ObjectInArea> area = new AreaStub();

    private class ObjectKnowsFourNeighborsPosesStub extends ObjectKnowsEightNeighborsPoses<ConstantArea<ObjectInArea>> {
        public ObjectKnowsFourNeighborsPosesStub(ConstantArea<ObjectInArea> area, Position pos) {
            super(area, pos);
        }
    }
}