package TheBadParodyToGame.objectsInArea.movingObjects.mobs;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.movingObjects.player.Player;

public abstract class MobKnowsPlayerPosition extends Mob {

    private Player player;

    public MobKnowsPlayerPosition(AreaContainsAll area, Position pos, int hp, Player player)
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
