package TheBadParodyToGame.objectsInArea;

/**
 * Fire is interface for Area.
 * FireManager uses it.
 */
public interface PassableObject extends StaticObject {
    default public int getDamage() {
        return 0;
    }

    default public int getHealing() {
        return 0;
    }
}
