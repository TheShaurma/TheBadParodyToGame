package TheBadParodyToGame.ObjectsInArea;

import java.io.Serializable;

/**
 * Object in area is Interface used in Area.
 * Areas can contain only Object of class implements this interface.
 */
public interface ObjectInArea extends Serializable {
    default public int getDamage() {
        return 0;
    }

    default public int getHealing() {
        return 0;
    }
}
