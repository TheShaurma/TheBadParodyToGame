package TheBadParodyToGame.objectsInArea.movingObjects.withAI;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.CannotMoveObjectException;
import TheBadParodyToGame.objectsInArea.LostObjectException;
import TheBadParodyToGame.objectsInArea.movingObjects.MovingObject;

public abstract class ObjectMovingItself extends MovingObject {
    public ObjectMovingItself(AreaContainsAll area, Position pos)
            throws BusyPositionException, PositionCannotExistInAreaException {
        super(area, pos);
    }

    abstract public void moveToStep()
            throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException;
}
