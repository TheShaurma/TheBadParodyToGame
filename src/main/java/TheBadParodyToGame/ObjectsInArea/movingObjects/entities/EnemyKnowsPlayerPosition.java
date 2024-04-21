package TheBadParodyToGame.objectsInArea.movingObjects.entities;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.player.Player;

public abstract class EnemyKnowsPlayerPosition extends Enemy {

    private Player player;

    public EnemyKnowsPlayerPosition(AreaContainsAll area, Position pos, int hp, Player player)
            throws BusyPositionException, PositionCannotExistInAreaException {
        super(area, pos, hp);
        this.player = player;
    }

    protected Player getPlayer() {
        return player;
    }

    protected Position getPlayerPosition() {
        return getPlayer().getPos();
    }
}
