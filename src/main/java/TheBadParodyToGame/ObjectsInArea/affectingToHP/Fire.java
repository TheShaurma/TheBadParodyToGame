package TheBadParodyToGame.objectsInArea.affectingToHP;

/**
 */
public class Fire implements DangerObject {

    @Override
    public int getDamage() {
        return 5;
    }

    @Override
    public char getChar() {
        return 'f';
    }
}
