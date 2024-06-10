package TheBadParodyToGame.objectsInArea.movingObjects.entities;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.player.Player;

// TODO: objects should's be placed here
@Deprecated
public class MobsKnowsPlayerPositionPlacer {

    private Player player;
    private AreaContainsAll area;

    public EnemyFollowsPlayer placeEnemyFollowingPlayer(Position pos)
            throws BusyPositionException, PositionCannotExistInAreaException {
        return new EnemyFollowsPlayer(area, pos, 50, player);
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public AreaContainsAll getArea() {
        return this.area;
    }

    public void setArea(AreaContainsAll area) {
        this.area = area;
    }

}
