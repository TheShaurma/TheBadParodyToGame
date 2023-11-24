package TheBadParodyToGame.objectsInArea.affectingToHP;

public class Apple implements DangerObject {
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
