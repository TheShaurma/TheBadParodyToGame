package TheBadParodyToGame.objectsInArea.buildingMaterials.portals;

import TheBadParodyToGame.area.position.Position;

public class GamePortal implements Portal {
    private Position teleportPos;

    public GamePortal(Position pos) {
        teleportPos = pos;
    }

    @Override
    public Position getTeleportPosition() {
        return teleportPos;
    }

}
