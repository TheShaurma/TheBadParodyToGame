package TheBadParodyToGame.area;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionStub;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.ObjectInAreaStub;

public class AreaChecksPositionTest {
    @Test
    public void get_call_checkPositionCalled() throws EmptyPositionException, PositionCannotExistInAreaException {
        AreaChecksPositionStub area = new AreaChecksPositionStub();
        try {
            area.get(new PositionStub());
        } catch (EmptyPositionException e) {
            // do nothing
        }
        assertTrue(area.checkPositionCalled);
    }

    @Test
    public void set_call_checkPositionCalled() {
        AreaChecksPositionStub area = new AreaChecksPositionStub();
        try {
            area.set(new PositionStub(), new ObjectInAreaStub());
        } catch (PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.checkPositionCalled);
    }

    @Test
    public void place_call_checkPositionCalled() {
        AreaChecksPositionStub area = new AreaChecksPositionStub();
        try {
            area.place(new PositionStub(), new ObjectInAreaStub());
        } catch (BusyPositionException | PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.checkPositionCalled);
    }

    @Test
    public void tryPlace_call_checkPositionCalled() {
        AreaChecksPositionStub area = new AreaChecksPositionStub();
        try {
            area.tryPlace(new PositionStub(), new ObjectInAreaStub());
        } catch (PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.checkPositionCalled);
    }

    @Test
    public void replace_call_checkPositionCalled() {
        AreaChecksPositionStub area = new AreaChecksPositionStub();
        try {
            area.replace(new PositionStub(), new ObjectInAreaStub());
        } catch (EmptyPositionException | PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.checkPositionCalled);
    }

    @Test
    public void tryReplace_call_checkPositionCalled() {
        AreaChecksPositionStub area = new AreaChecksPositionStub();
        try {
            area.tryReplace(new PositionStub(), new ObjectInAreaStub());
        } catch (PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.checkPositionCalled);
    }

    @Test
    public void remove_call_checkPositionCalled() {
        AreaChecksPositionStub area = new AreaChecksPositionStub();
        try {
            area.remove(new PositionStub());
        } catch (EmptyPositionException | PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.checkPositionCalled);
    }

    @Test
    public void tryRemove_call_checkPositionCalled() {
        AreaChecksPositionStub area = new AreaChecksPositionStub();
        try {
            area.tryRemove(new PositionStub());
        } catch (PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.checkPositionCalled);
    }

    @Test
    public void relocate_call_checkPositionCalled() {
        AreaChecksPositionStub area = new AreaChecksPositionStub();
        try {
            area.relocate(new PositionStub(), new PositionStub());
        } catch (EmptyPositionException | BusyPositionException | PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.checkPositionCalled);
    }

    @Test
    public void tryRelocate_call_checkPositionCalled() {
        AreaChecksPositionStub area = new AreaChecksPositionStub();
        try {
            area.tryRelocate(new PositionStub(), new PositionStub());
        } catch (PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.checkPositionCalled);
    }

    @Test
    public void relocateToEverywhere_call_checkPositionCalled() {
        AreaChecksPositionStub area = new AreaChecksPositionStub();
        try {
            area.relocateToEverywhere(new PositionStub(), new PositionStub());
        } catch (EmptyPositionException | PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.checkPositionCalled);
    }

    @Test
    public void positionIsEmpty_call_checkPositionCalled() {
        AreaChecksPositionStub area = new AreaChecksPositionStub();
        try {
            area.positionIsEmpty(new PositionStub());
        } catch (PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.checkPositionCalled);
    }

    @Test
    public void positionIsBusy_call_checkPositionCalled() {
        AreaChecksPositionStub area = new AreaChecksPositionStub();
        try {
            area.positionIsBusy(new PositionStub());
        } catch (PositionCannotExistInAreaException e) {
            // do nothing
        }
        assertTrue(area.checkPositionCalled);
    }
}

class AreaChecksPositionStub extends AreaChecksPosition<ObjectInAreaStub> {
    public boolean checkPositionCalled = false;

    @Override
    protected void checkPosition(Position pos) throws PositionCannotExistInAreaException {
        checkPositionCalled = true;
    }
}