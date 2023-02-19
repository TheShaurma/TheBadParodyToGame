package TheBadParodyToGame.area;

import java.io.Serializable;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.abstractions.AbstractJointArea;
import TheBadParodyToGame.area.abstractions.CheckeredAreaContainsAll;

public class GameArea extends AbstractJointArea<ObjectInArea> implements CheckeredAreaContainsAll, Serializable {
    private static final long serialVersionUID = 1L;
}
