package TheBadParodyToGame.objectsInArea.movingObjects.withAI;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.CannotMoveObjectException;
import TheBadParodyToGame.objectsInArea.LostObjectException;
import TheBadParodyToGame.objectsInArea.affectingToHP.DangerObject;
import TheBadParodyToGame.objectsInArea.movingObjects.player.Player;

public class Enemy extends ObjectMovingItself implements DangerObject {
    private boolean live = true;

    private static final Random random = new Random();
    private final Map<Integer, Mover> movers = new HashMap<>();

    private static final int MAX_MOVER_NUMBER = 7;

    public Enemy(AreaContainsAll area, Position pos) throws BusyPositionException, PositionCannotExistInAreaException {
        super(area, pos);

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
        int moverNumber = random.nextInt(MAX_MOVER_NUMBER + 1);
        Mover mover = movers.get(moverNumber);

        try {
            mover.move();
        } catch (CannotMoveObjectException e) {
        }
    }

    @Override
    public char getChar() {
        return '%';
    }

    @Override
    public int getDamage() {
        return 30;
    }

    @Override
    protected void checkForBeingInCurrentPosition() throws LostObjectException, PositionCannotExistInAreaException {
        if (live) {
            try {
                super.checkForBeingInCurrentPosition();
            } catch (LostObjectException e) {
                var area = getArea();
                var pos = getCurrentPosition();

                try {
                    if (area.get(pos).getClass() == Player.class) {
                        kill();
                    } else {
                        throw e;
                    }
                } catch (EmptyPositionException e1) {
                    throw e;
                }
            }
        }
    }

    private void kill() {
        live = false;
    }
}

interface Mover {
    void move()
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException;
}