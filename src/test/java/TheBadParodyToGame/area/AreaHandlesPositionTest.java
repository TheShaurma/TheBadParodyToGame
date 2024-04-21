package TheBadParodyToGame.area;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionStub;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.ObjectInAreaStub;

public class AreaHandlesPositionTest {
    @Test
    public void get_call_handlePositionCalled() {
        AreaHandlesPositionStub area = new AreaHandlesPositionStub();
        try {
            area.get(new PositionStub());
        } catch (EmptyPositionException | PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.handlePositionCalled);
    }

    @Test
    public void set_call_handlePositionCalled() {
        AreaHandlesPositionStub area = new AreaHandlesPositionStub();
        try {
            area.set(new PositionStub(), new ObjectInAreaStub());
        } catch (PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.handlePositionCalled);
    }

    @Test
    public void place_call_handlePositionCalled() {
        AreaHandlesPositionStub area = new AreaHandlesPositionStub();
        try {
            area.place(new PositionStub(), new ObjectInAreaStub());
        } catch (BusyPositionException | PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.handlePositionCalled);
    }

    @Test
    public void tryPlace_call_handlePositionCalled() {
        AreaHandlesPositionStub area = new AreaHandlesPositionStub();
        try {
            area.tryPlace(new PositionStub(), new ObjectInAreaStub());
        } catch (PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.handlePositionCalled);
    }

    @Test
    public void replace_call_handlePositionCalled() {
        AreaHandlesPositionStub area = new AreaHandlesPositionStub();
        try {
            area.replace(new PositionStub(), new ObjectInAreaStub());
        } catch (EmptyPositionException | PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.handlePositionCalled);
    }

    @Test
    public void tryReplace_call_handlePositionCalled() {
        AreaHandlesPositionStub area = new AreaHandlesPositionStub();
        try {
            area.tryReplace(new PositionStub(), new ObjectInAreaStub());
        } catch (PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.handlePositionCalled);
    }

    @Test
    public void remove_call_handlePositionCalled() {
        AreaHandlesPositionStub area = new AreaHandlesPositionStub();
        try {
            area.remove(new PositionStub());
        } catch (EmptyPositionException | PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.handlePositionCalled);
    }

    @Test
    public void tryRemove_call_handlePositionCalled() {
        AreaHandlesPositionStub area = new AreaHandlesPositionStub();
        try {
            area.tryRemove(new PositionStub());
        } catch (PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.handlePositionCalled);
    }

    @Test
    public void relocate_call_handlePositionCalled() {
        AreaHandlesPositionStub area = new AreaHandlesPositionStub();
        try {
            area.relocate(new PositionStub(), new PositionStub());
        } catch (EmptyPositionException | BusyPositionException | PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.handlePositionCalled);
    }

    @Test
    public void tryRelocate_call_handlePositionCalled() {
        AreaHandlesPositionStub area = new AreaHandlesPositionStub();
        try {
            area.tryRelocate(new PositionStub(), new PositionStub());
        } catch (PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.handlePositionCalled);
    }

    @Test
    public void relocateToEverywhere_call_handlePositionCalled() {
        AreaHandlesPositionStub area = new AreaHandlesPositionStub();
        try {
            area.relocateToEverywhere(new PositionStub(), new PositionStub());
        } catch (EmptyPositionException | PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.handlePositionCalled);
    }

    @Test
    public void positionIsEmpty_call_handlePositionCalled() {
        AreaHandlesPositionStub area = new AreaHandlesPositionStub();
        try {
            area.positionIsEmpty(new PositionStub());
        } catch (PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.handlePositionCalled);
    }

    @Test
    public void positionIsBusy_call_handlePositionCalled() {
        AreaHandlesPositionStub area = new AreaHandlesPositionStub();
        try {
            area.positionIsBusy(new PositionStub());
        } catch (PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.handlePositionCalled);
    }
}

class AreaHandlesPositionStub extends AreaHandlesPosition<ObjectInAreaStub> {
    public boolean handlePositionCalled = false;

    @Override
    public Position handlePosition(Position pos) {
        handlePositionCalled = true;
        return pos;
    }

    @Override
    protected void checkPosition(Position pos) throws PositionCannotExistInAreaException {
    }

}