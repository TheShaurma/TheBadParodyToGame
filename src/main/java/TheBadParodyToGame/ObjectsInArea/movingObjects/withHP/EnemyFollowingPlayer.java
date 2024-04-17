package TheBadParodyToGame.objectsInArea.movingObjects.withHP;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.CannotMoveObjectException;
import TheBadParodyToGame.objectsInArea.LostObjectException;
import TheBadParodyToGame.objectsInArea.ObjectInArea;
import TheBadParodyToGame.objectsInArea.movingObjects.withHP.player.Player;

public class EnemyFollowingPlayer extends EnemyKnowsPlayerPosition {

    public EnemyFollowingPlayer(AreaContainsAll area, Position pos, int hp, Player player)
            throws BusyPositionException, PositionCannotExistInAreaException {
        super(area, pos, hp, player);
    }

    @Override
    public void moveToStep() throws LostObjectException, CannotMoveObjectException, PositionCannotExistInAreaException {
        Position playerPosition = getPlayerPosition();
        Position currentPosition = getCurrentPosition();
        int playerX = playerPosition.getX();
        int playerY = playerPosition.getY();
        int currentX = currentPosition.getX();
        int currentY = currentPosition.getY();

        int xDistance = currentX - playerX;
        int yDistance = currentY - playerY;
        int newX = currentX;
        int newY = currentY;

        if (Math.abs(xDistance) > Math.abs(yDistance)) {
            if (xDistance > 0) {
                newX = currentX - 1;
            } else {
                newX = currentX + 1;
            }
        } else if (Math.abs(xDistance) < Math.abs(yDistance)) {
            if (yDistance > 0) {
                newY = currentY - 1;
            } else {
                newY = currentY + 1;
            }
        }

        Position newPos = new GamePosition(newX, newY);
        try {
            ObjectInArea obj = getArea().get(newPos);
            if (obj instanceof Player) {
                Player player = (Player) obj;
                player.hurt(getAttack());
            }
        } catch (EmptyPositionException e) {
            moveToPosition(newPos);
        }
    }

    @Override
    public int getAttack() {
        return 50;
    }

    @Override
    public char getChar() {
        return '!';
    }

    @Override
    public String toString() {
        return String.format("EnemyFollowingPlayer(%s)", getCurrentPosition());
    }
}
