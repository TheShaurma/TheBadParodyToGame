package TheBadParodyToGame.objectsInArea.buildingMaterials.portals;

import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.objectsInArea.AbstractObject;

public class GamePortal extends AbstractObject implements Portal {
    private Position teleportPos;

    public GamePortal(Position pos) {
        teleportPos = pos;
    }

    @Override
    public Position getTeleportPosition() {
        return teleportPos;
    }

    @Override
    public char getChar() {
        return '@';
    }
}
