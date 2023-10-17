package TheBadParodyToGame.ObjectsInArea.buildingMaterials.portals;

import TheBadParodyToGame.ObjectsInArea.PassableObject;
import TheBadParodyToGame.area.position.Position;

public interface Portal extends PassableObject {
    Position getTeleportPosition();
}
