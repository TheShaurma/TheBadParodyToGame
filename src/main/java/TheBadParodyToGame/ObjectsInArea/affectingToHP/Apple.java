package TheBadParodyToGame.objectsInArea.affectingToHP;

import TheBadParodyToGame.objectsInArea.AbstractObject;

public class Apple extends AbstractObject implements HealingObject {

    protected static final int HASH = 2;

    private int heal;

    public Apple() {
        heal = 10;
    }

    public Apple(int n) {
        heal = n;
    }

    @Override
    public int getHealing() {
        return heal;
    }

    @Override
    public char getChar() {
        return 'a';
    }
}
