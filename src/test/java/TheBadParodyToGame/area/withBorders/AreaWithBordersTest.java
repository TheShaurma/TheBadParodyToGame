package TheBadParodyToGame.area.withBorders;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import TheBadParodyToGame.area.position.PositionStub;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.area.position.exceptions.PositionOutOfBordersException;
import TheBadParodyToGame.objectsInArea.ObjectInAreaStub;

public class AreaWithBordersTest {
    @Test
    public void checkPosition_givePositionInBorders_nothingHappened() throws PositionCannotExistInAreaException {
        AreaWithBordersStub area = new AreaWithBordersStub();
        area.checkPosition(new PositionStub(0, 0));
    }

    @Test
    public void checkPosition_givePositionInBorders_exceptionThrown() {
        AreaWithBordersStub area = new AreaWithBordersStub();
        assertThrows(
                PositionOutOfBordersException.class, () -> {
                    area.checkPosition(new PositionStub(100, 100));
                });
    }
}

class AreaWithBordersStub extends AbstractAreaWithBorders<ObjectInAreaStub> {
    public AreaWithBordersStub() {
        super(new BordersStub());
    }
}
