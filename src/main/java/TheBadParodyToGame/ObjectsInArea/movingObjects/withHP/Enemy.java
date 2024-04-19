package TheBadParodyToGame.objectsInArea.movingObjects.withHP;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;

public abstract class Enemy extends ObjectWithAI {
    public Enemy(AreaContainsAll area, Position pos, int hp)
            throws BusyPositionException, PositionCannotExistInAreaException {
        super(area, pos, hp);
    }

    public int getHealing() {
        return 0;
    }

    abstract public int getAttack();
}
