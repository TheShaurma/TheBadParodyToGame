package TheBadParodyToGame;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.ObjectInArea;

// TODO: create docs
public class AreaJoiner {
    private AreaContainsAll area;

    public AreaJoiner(AreaContainsAll jointArea) {
        area = jointArea;
    }

    public void joinArea(Position downLeftAnglePos, AreaContainsAll joinedArea)
            throws EmptyPositionException, PositionCannotExistInAreaException {
        ObjectInArea obj;
        int x, y;
        for (Position pos : joinedArea) {
            obj = joinedArea.get(pos);
            x = downLeftAnglePos.getX() + pos.getX();
            y = downLeftAnglePos.getY() + pos.getY();
            area.set(new GamePosition(x, y), obj);
        }
    }
}
