package TheBadParodyToGame.ObjectsInArea.buildingMaterials;

import TheBadParodyToGame.area.position.IntegerPosition2D;

public class GamePortal implements Portal {
    private IntegerPosition2D teleportPos;

    public GamePortal(IntegerPosition2D pos) {
        teleportPos = pos;
    }

    @Override
    public IntegerPosition2D getTeleportPosition() {
        return teleportPos;
    }

}
