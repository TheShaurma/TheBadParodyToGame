package game_logic.objects_on_field.billiard_ball;

import game_logic.basis_exceptions.GameLogicException;

public class TryToReboundWithoutWallNearException extends GameLogicException {
    public String toString() {
        return "Tried to rebound without any wall near.";
    }
}
