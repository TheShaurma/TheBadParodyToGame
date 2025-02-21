package TheBadParodyToGame.objectsInArea.affectingToHP;

import TheBadParodyToGame.objectsInArea.AbstractObject;

/**
 */
public class Fire extends AbstractObject implements DangerObject {

    protected static final int HASH = 1;

    @Override
    public int getDamage() {
        return 5;
    }

    @Override
    public char getChar() {
        return 'f';
    }
}
