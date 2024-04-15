package TheBadParodyToGame.objectsInArea.movingObjects.mobs;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.CannotMoveObjectException;
import TheBadParodyToGame.objectsInArea.LostObjectException;
import TheBadParodyToGame.objectsInArea.affectingToHP.DangerObject;

public class EnemyMovesRandomly extends Mob implements DangerObject {

    private static final Random random = new Random();
    private final Map<Integer, Mover> movers = new HashMap<>();

    private static final int MAX_MOVER_NUMBER = 7;

    public EnemyMovesRandomly(AreaContainsAll area, Position pos, int hp)
            throws BusyPositionException, PositionCannotExistInAreaException {
        super(area, pos, hp);

        movers.put(0, this::moveUp);
        movers.put(1, this::moveDown);
        movers.put(2, this::moveLeft);
        movers.put(3, this::moveRight);
        movers.put(4, this::moveUpLeft);
        movers.put(5, this::moveUpRight);
        movers.put(6, this::moveDownLeft);
        movers.put(7, this::moveDownRight);
    }

    @Override
    public void moveToStep()
            throws LostObjectException, PositionCannotExistInAreaException {
        if (isLiving()) {
            int moverNumber = random.nextInt(MAX_MOVER_NUMBER + 1);
            Mover mover = movers.get(moverNumber);

            try {
                mover.move();
            } catch (CannotMoveObjectException e) {
            }
        }
    }

    @Override
    public char getChar() {
        return '%';
    }

    @Override
    public int getAttack() {
        return getHP() * 10;
    }

    @Override
    public String toString() {
        return String.format("Enemy(%s)", getCurrentPosition().toString());
    }
}

interface Mover {
    void move()
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException;
}