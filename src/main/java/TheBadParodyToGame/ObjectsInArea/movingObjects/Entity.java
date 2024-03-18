package TheBadParodyToGame.objectsInArea.movingObjects;

import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.LostObjectException;
import TheBadParodyToGame.objectsInArea.ObjectInArea;

public interface Entity extends ObjectInArea {

    void kill() throws LostObjectException, PositionCannotExistInAreaException;

    int getHP();

    void setHP(int hp);

    void heal(int hp);

    void hurt(int hp) throws LostObjectException, PositionCannotExistInAreaException;

    boolean isLiving();
}
