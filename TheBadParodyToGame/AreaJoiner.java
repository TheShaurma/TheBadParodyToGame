package TheBadParodyToGame;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.abstractions.CheckeredAreaContainsAll;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.GameIntegerPosition2D;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

// TODO: create docs
public class AreaJoiner {
    private CheckeredAreaContainsAll area;

    public AreaJoiner(CheckeredAreaContainsAll jointArea) {
        area = jointArea;
    }

    public void joinArea(IntegerPosition2D downLeftAnglePos, CheckeredAreaContainsAll joinedArea)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        ObjectInArea obj;
        int x, y;
        for (IntegerPosition2D pos : joinedArea) {
            obj = joinedArea.get(pos);
            x = downLeftAnglePos.getX() + pos.getX();
            y = downLeftAnglePos.getY() + pos.getY();
            area.set(new GameIntegerPosition2D(x, y), obj);
        }
    }
}
