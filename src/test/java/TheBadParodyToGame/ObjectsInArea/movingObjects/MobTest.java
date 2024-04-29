package TheBadParodyToGame.objectsInArea.movingObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.AreaStub;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionStub;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.CannotMoveObjectException;
import TheBadParodyToGame.objectsInArea.LostObjectException;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.DiedMobCannotMoveException;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.ObjectWithAI;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.ObjectWithHP;

public class MobTest {

    @Test
    public void getHP_callLotOfTimes_normalResultAllTimes()
            throws BusyPositionException, PositionCannotExistInAreaException {
        int expected = 100;
        ObjectWithHP mob = getMob(expected);
        int actual;

        for (int i = 0; i < 10000; i++) {
            actual = mob.getHP();
            assertEquals(expected, actual);
        }
    }

    @Test
    public void heal_call_mobHealed() throws BusyPositionException, PositionCannotExistInAreaException {
        int hp = 100;
        int heal = 50;
        int expected = hp + heal;
        ObjectWithHP mob = getMob(hp);

        mob.heal(heal);
        int actual = mob.getHP();

        assertEquals(expected, actual);
    }

    @Test
    public void hurt_call_mobHurt()
            throws BusyPositionException, PositionCannotExistInAreaException, LostObjectException {
        int hp = 100;
        int hurt = 50;
        int expected = hp - hurt;
        ObjectWithHP mob = getMob(hp);

        mob.hurt(hurt);
        int actual = mob.getHP();

        assertEquals(expected, actual);
    }

    @Test
    public void hurt_hurtToDead_mobDied()
            throws BusyPositionException, PositionCannotExistInAreaException, LostObjectException {
        int hp = 100;
        int hurt = 1000;
        AreaContainsAll area = new AreaStub();
        Position pos = new PositionStub();
        ObjectWithHP mob = new MobStub(area, pos, hp);

        mob.hurt(hurt);

        assertFalse(mob.isLiving());
    }

    @Test
    public void hurt_hurtToDead_mobRemovedFromMap()
            throws BusyPositionException, PositionCannotExistInAreaException, LostObjectException {
        int hp = 100;
        int hurt = 1000;
        AreaContainsAll area = new AreaStub();
        Position pos = new PositionStub();
        ObjectWithHP mob = new MobStub(area, pos, hp);

        mob.hurt(hurt);

        assertTrue(area.positionIsEmpty(pos));
    }

    @Test
    public void hurt_tryToMoveAfterDead_objectWasntMovedAndDiedMobCannotMoveExceptionThrown()
            throws BusyPositionException, PositionCannotExistInAreaException, LostObjectException,
            CannotMoveObjectException {
        int hp = 100;
        int hurt = 1000;
        AreaContainsAll area = new AreaStub();
        PositionStub pos = new PositionStub();
        Position otherPos = pos.getOther();
        MobStub mob = new MobStub(area, pos, hp);

        mob.hurt(hurt);

        assertFalse(mob.isLiving());
        assertThrows(DiedMobCannotMoveException.class, () -> {
            mob.moveToPosition(otherPos);
        });
        assertTrue(area.positionIsEmpty(pos));
        assertTrue(area.positionIsEmpty(otherPos));
    }

    public static MobStub getMob() throws BusyPositionException, PositionCannotExistInAreaException {
        return getMob(100);
    }

    public static MobStub getMob(int hp) throws BusyPositionException, PositionCannotExistInAreaException {
        return new MobStub(new AreaStub(), new PositionStub(), hp);
    }
}

class MobStub extends ObjectWithAI {
    public MobStub(AreaContainsAll area, Position pos, int hp)
            throws BusyPositionException, PositionCannotExistInAreaException {
        super(area, pos, hp);

        area.place(pos, this);
    }

    @Override
    public void moveToStep() throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        throw new UnsupportedOperationException("Unimplemented method 'moveToStep'");
    }

    @Override
    public void moveToPosition(Position newPos)
            throws LostObjectException, PositionCannotExistInAreaException, CannotMoveObjectException {
        super.moveToPosition(newPos);
    }
}
