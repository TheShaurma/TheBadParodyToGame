package TheBadParodyToGame.ObjectsInArea.buildingMaterials.portals;

import TheBadParodyToGame.ObjectsInArea.PassableObject;
import TheBadParodyToGame.area.position.IntegerPosition2D;

public interface Portal extends PassableObject {
    IntegerPosition2D getTeleportPosition();
}
