package TheBadParodyToGame.ObjectsInArea.buildingMaterials;

import TheBadParodyToGame.ObjectsInArea.PassableObject;
import TheBadParodyToGame.area.position.IntegerPosition2D;

public interface Portal extends PassableObject {
    IntegerPosition2D getTeleportPosition();
}
