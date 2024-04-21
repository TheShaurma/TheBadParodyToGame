package TheBadParodyToGame.area.withBorders;

import TheBadParodyToGame.area.Area;
import TheBadParodyToGame.objectsInArea.ObjectInArea;

public interface AreaWithBorders<OBJ extends ObjectInArea>
        extends ConstantAreaWithBorders<OBJ>,
        Area<OBJ> {
}
