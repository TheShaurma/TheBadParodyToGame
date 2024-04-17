package TheBadParodyToGame.objectsInArea.movingObjects.withHP;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.CannotMoveObjectException;
import TheBadParodyToGame.objectsInArea.LostObjectException;

public abstract class ObjectWithAI extends ObjectWithHP {
    public ObjectWithAI(AreaContainsAll area, Position pos, int hp)
            throws BusyPositionException, PositionCannotExistInAreaException {
        super(area, pos, hp);
    }

    abstract public void moveToStep()
            throws LostObjectException,
            CannotMoveObjectException,
            PositionCannotExistInAreaException;
}
