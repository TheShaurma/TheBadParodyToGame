package TheBadParodyToGame.ObjectsInArea.player;

import TheBadParodyToGame.ObjectsInArea.MovingObject;
import TheBadParodyToGame.ObjectsInArea.fire.Fire;
import TheBadParodyToGame.area.CheckeredArea;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

// TODO: create HP barr
public class Player extends MovingObject {
    private String name;
    private static final long serialVersionUID = 5L;

    public Player(CheckeredArea area, IntegerPosition2D startPos) throws PositionException {
        super(area, startPos);

        name = "NoName";
    }

    public Player(String name, CheckeredArea area, IntegerPosition2D startPos) throws PositionException {
        super(area, startPos);

        this.name = name;
    }

    /**
     * Takes string and iterate it.
     * w or W — move player up;
     * s ot S — move player down;
     * a or A — move player left;
     * d or D — move player right;
     * 
     * @param directions
     * @throws PositionException if moving has problems.
     */
    public void moveByDirections(String directions) throws PositionException {
        for (int i = 0; i < directions.length(); i++) {
            char d = directions.charAt(i);

            if (d == 'w' || d == 'W') {
                moveUp();
            } else if (d == 's' || d == 'S') {
                moveDown();
            } else if (d == 'a' || d == 'A') {
                moveLeft();
            } else if (d == 'd' || d == 'D') {
                moveRight();
            }
        }
    }

    @Override
    protected void moveToPosition(IntegerPosition2D newPos) throws PositionException {
        CheckeredArea area = getArea();
        if (area.positionIsBusy(newPos) && area.get(newPos) instanceof Fire) {
            throw new PlayerDiedException(newPos);
        }

        super.moveToPosition(newPos);
    }

    @Override
    public String toString() {
        return "Player \"" + name + "\"";
    }
}
