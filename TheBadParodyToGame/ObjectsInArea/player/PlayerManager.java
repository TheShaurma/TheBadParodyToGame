package TheBadParodyToGame.ObjectsInArea.player;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.ObjectsInArea.ObjectManager;
import TheBadParodyToGame.ObjectsInArea.fire.Fire;
import TheBadParodyToGame.area.CheckeredArea;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

public class PlayerManager extends ObjectManager {

    public PlayerManager(IntegerPosition2D pos, CheckeredArea area, ObjectInArea obj) throws PositionException {
        super(pos, area, obj);
    }

    /**
     * Takes string and iterate it.
     * u or U — move player up;
     * d ot D — move player down;
     * l or L — move player left;
     * r or R — move player right;
     * 
     * @param directions
     * @throws PositionException if moving has problems.
     */
    public void moveByDirections(String directions) throws PositionException {
        for (int i = 0; i < directions.length(); i++) {
            char d = directions.charAt(i);

            if (d == 'u' || d == 'U') {
                moveObjectUp();
            } else if (d == 'd' || d == 'D') {
                moveObjectDown();
            } else if (d == 'l' || d == 'L') {
                moveObjectLeft();
            } else if (d == 'r' || d == 'R') {
                moveObjectRight();
            }
        }
    }

    /**
     * 
     */
    @Override
    protected void moveObjectToPosition(IntegerPosition2D newPos) throws PositionException {
        CheckeredArea area = getArea();

        if (area.positionIsBusy(newPos) &&
                area.get(newPos).getClass() == Fire.class) {
            throw new PlayerDiedException(newPos);
        }

        super.moveObjectToPosition(newPos);
    }
}