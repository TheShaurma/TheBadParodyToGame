package TheBadParodyToGame.objectsInArea;

/**
 * Object in area is Interface used in Area.
 * Areas can contain only Object of class implements this interface.
 */
public interface ObjectInArea {
    default public int getDamage() {
        return 0;
    }

    default public int getHealing() {
        return 0;
    }
}
