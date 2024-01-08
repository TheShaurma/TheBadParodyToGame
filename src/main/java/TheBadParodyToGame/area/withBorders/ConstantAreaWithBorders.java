package TheBadParodyToGame.area.withBorders;

import TheBadParodyToGame.area.ConstantArea;
import TheBadParodyToGame.area.withBorders.borders.Borders;
import TheBadParodyToGame.objectsInArea.ObjectInArea;

public interface ConstantAreaWithBorders<OBJ extends ObjectInArea> extends ConstantArea<OBJ> {
    /**
     * @return borders of area.
     */
    Borders getBorders();
}
