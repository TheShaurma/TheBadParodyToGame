package TheBadParodyToGame.objectsInArea.buildingMaterials;

import TheBadParodyToGame.objectsInArea.AbstractObject;
import TheBadParodyToGame.objectsInArea.StaticObject;

/**
 * Stone is object for Area.
 */
public class Stone extends AbstractObject implements StaticObject {
    @Override
    public char getChar() {
        return 's';
    }
}
