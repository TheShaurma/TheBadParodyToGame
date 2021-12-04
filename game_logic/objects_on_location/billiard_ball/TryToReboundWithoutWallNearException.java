package game_logic.objects_on_location.billiard_ball;

import game_logic.abstractions.basis_exceptions.GameLogicException;

public class TryToReboundWithoutWallNearException extends GameLogicException {
    public String toString() {
        return "Tried to rebound without any wall near.";
    }
}
