package TheBadParodyToGame.objectsInArea.movingObjects.mobs;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.CannotMoveObjectException;
import TheBadParodyToGame.objectsInArea.LostObjectException;
import TheBadParodyToGame.objectsInArea.movingObjects.Entity;
import TheBadParodyToGame.objectsInArea.movingObjects.MoveableObject;

public abstract class Mob extends MoveableObject implements Entity {

    private int hp;

    public Mob(AreaContainsAll area, Position pos, int hp)
            throws BusyPositionException, PositionCannotExistInAreaException {
        super(area, pos);
        this.hp = hp;
    }

    @Override
    public void kill()
            throws LostObjectException, PositionCannotExistInAreaException {
        AreaContainsAll area = getArea();
        Position pos = getCurrentPosition();
        try {
            area.remove(pos);
        } catch (EmptyPositionException e) {
            throw new LostObjectException(pos, this);
        }

        setHP(0);
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public void setHP(int hp) {
        this.hp = hp;
    }

    @Override
    public void heal(int hp) {
        this.hp += hp;
    }

    @Override
    public void hurt(int hp) throws LostObjectException, PositionCannotExistInAreaException {
        this.hp -= hp;

        if (!isLiving()) {
            kill();
        }
    }

    @Override
    public boolean isLiving() {
        return hp > 0;
    }

    abstract public void moveToStep()
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException;

    @Override
    protected void moveToPosition(Position newPos)
            throws LostObjectException, PositionCannotExistInAreaException,
            CannotMoveObjectException {
        if (isLiving()) {
            super.moveToPosition(newPos);
        }
    }
}
