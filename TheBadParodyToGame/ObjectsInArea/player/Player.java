package TheBadParodyToGame.ObjectsInArea.player;

import TheBadParodyToGame.ObjectsInArea.CannotMoveObjectException;
import TheBadParodyToGame.ObjectsInArea.LostObjectException;
import TheBadParodyToGame.ObjectsInArea.MovingObject;
import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.ObjectsInArea.PassableObject;
import TheBadParodyToGame.area.CheckeredAreaContainsAll;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;
import TheBadParodyToGame.area.position.PositionException;

/**
 * Player should be moved by user.
 *
 * <div>"Player died" = "{@code PlayerDiedException} thrown".
 */
public class Player extends MovingObject {
    private int heatPoints = 100;
    private String name;
    private static final long serialVersionUID = 5L;

    public Player(CheckeredAreaContainsAll area, IntegerPosition2D startPos) throws PositionException {
        super(area, startPos);

        name = "NoName";
    }

    @Override
    public String toString() {
        return "Player(\"" + getName() + "\", \"" + getHPString() + "\")";
    }

    public String getName() {
        return name;
    }

    public String getHPString() {
        int HP = getHP();
        if (HP < 5) {
            return "!!!!!!!!!! - " + getHP();
        }

        String result = "";
        int[] line = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        while (HP >= 5) {
            for (int i = 0; (i < line.length) && HP >= 5; i++) {
                line[i] += 1;
                HP -= 5;
            }
        }

        for (int i : line) {
            if (i == 0) {
                result += '-';
            } else if (i < 10) {
                result += i;
            } else {
                switch (i) {
                    case 10:
                        result += '^';
                        break;
                    case 11:
                        result += '*';
                        break;
                    case 12:
                        result += '#';
                        break;
                    default:
                        result += '@';
                }
            }
        }

        return result + " - " + getHP();
    }

    public Player(String name, CheckeredAreaContainsAll area, IntegerPosition2D startPos) throws PositionException {
        super(area, startPos);

        this.name = name;
    }

    /**
     * This method exist for AreaWithPlayerInCenter.
     * It uses this method to convert positions.
     * 
     * @return current {@code pos}
     */
    public IntegerPosition2D getPos() {
        return getCurrentPosition();
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
    public void heal(int n) {
        heatPoints += n;
    }

    /**
     * Harm the player to n.
     * Player can die if {@code n >= HP}.
     * 
     * @param n
     * @throws PlayerDiedException if {@code n >= HP}.
     */
    public void harm(int n) {
        heatPoints -= n;
    }

    /**
     * Takes string and iterate it.
     * w or W — move player up;
     * s ot S — move player down;
     * a or A — move player left;
     * d or D — move player right;
     * 
     * @param directions
     * @throws PositionCannotExistInAreaException
     * @throws CannotMoveObjectException
     * @throws LostObjectException
     * @throws PlayerDiedException
     * @throws PositionException                  if moving has problems.
     */
    public void moveByDirections(String directions) throws LostObjectException, CannotMoveObjectException,
            PositionCannotExistInAreaException, PlayerDiedException {
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
            checkAlive();
        }
    }

    @Override
    protected void moveToPosition(IntegerPosition2D newPos)
            throws LostObjectException, PositionCannotExistInAreaException {
        CheckeredAreaContainsAll area = getArea();

        try {
            super.moveToPosition(newPos);
        } catch (CannotMoveObjectException e) {
            ObjectInArea obj;
            try {
                obj = getArea().get(e.getPosition());

                if (obj instanceof PassableObject) {
                    heal(obj.getHealing());
                    harm(obj.getDamage());

                    area.remove(newPos);
                    moveToPosition(newPos);
                }
            } catch (EmptyPositionException e1) {
                throw new LostObjectException(newPos, this);
            }
        }
    }

    /**
     * Checks if player alive.
     * 
     * @throws PlayerDiedException if {@code n <= 0}.
     */
    private void checkAlive() throws PlayerDiedException {
        if (getHP() <= 0) {
            throw new PlayerDiedException(getCurrentPosition(), this);
        }
    }
}
