package TheBadParodyToGame.ObjectsInArea.player;

import TheBadParodyToGame.ObjectsInArea.CannotMoveObjectException;
import TheBadParodyToGame.ObjectsInArea.MovingObject;
import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.ObjectsInArea.fire.DangerObject;
import TheBadParodyToGame.area.CheckeredArea;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionException;

// TODO: create HP barr
/**
 * Player should be moved by user.
 *
 * <div>"Player died" = "{@code PlayerDiedException} thrown".
 */
public class Player extends MovingObject {
    private int heatPoints = 100;
    private String name;
    private static final long serialVersionUID = 5L;

    public Player(CheckeredArea area, IntegerPosition2D startPos) throws PositionException {
        super(area, startPos);

        name = "NoName";
    }

    @Override
    public String toString() {
        String result = "Player(\"" + name + "\", [";

        for (int i = getHP(); i > 0; i -= 10) {
            result += '@';
        }
        for (int i = 100 - getHP(); i > 0; i -= 10) {
            result += ' ';
        }

        return result + "])";
    }

    public Player(String name, CheckeredArea area, IntegerPosition2D startPos) throws PositionException {
        super(area, startPos);

        this.name = name;
    }

    /**
     * @return HP value of the Player.
     */
    public int getHP() {
        return heatPoints;
    }

    /**
     * Sets HP value of the Player to {@code n}
     * 
     * @param n
     * @throws PlayerDiedException if {@code n <= 0}.
     */
    public void setHP(int n) throws PlayerDiedException {
        heatPoints = n;
        checkAlive();
    }

    /**
     * Heals the player to n.
     * Player can die by healing if {@code n < 0 and |n| >= HP} (|...| — absolute).
     * 
     * @param n
     * @throws PlayerDiedException if {@code n < 0 and |n| >= HP}.
     */
    public void heal(int n) throws PlayerDiedException {
        heatPoints += n;
        checkAlive();
    }

    /**
     * Harm the player to n.
     * Player can die if {@code n >= HP}.
     * 
     * @param n
     * @throws PlayerDiedException if {@code n >= HP}.
     */
    public void harm(int n) throws PlayerDiedException {
        heatPoints -= n;
        checkAlive();
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

        try {
            super.moveToPosition(newPos);
        } catch (CannotMoveObjectException e) {
            ObjectInArea obj = getArea().get(e.getPosition());
            if (obj instanceof DangerObject) {
                harm(obj.getDamage());
                checkAlive(); // if player died, code execution will stop here

                area.remove(newPos);
                moveToPosition(newPos);
            }
        }
    }

    /**
     * Checks if player alive.
     * 
     * @throws PlayerDiedException if {@code n <= 0}.
     */
    public void checkAlive() throws PlayerDiedException {
        if (getHP() <= 0) {
            throw new PlayerDiedException(getCurrentPosition(), this);
        }
    }
}
