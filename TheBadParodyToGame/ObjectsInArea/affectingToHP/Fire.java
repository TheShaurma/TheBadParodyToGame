package TheBadParodyToGame.ObjectsInArea.affectingToHP;

/**
 * serialVersionUID = 4L.
 */
public class Fire implements DangerObject {
    private static final long serialVersionUID = 4L;

    @Override
    public int getDamage() {
        return 5;
    }
}
