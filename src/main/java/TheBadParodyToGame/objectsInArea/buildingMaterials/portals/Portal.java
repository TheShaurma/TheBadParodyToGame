package TheBadParodyToGame.objectsInArea.buildingMaterials.portals;

import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.objectsInArea.PassableObject;

public interface Portal extends PassableObject {
    Position getTeleportPosition();
}
