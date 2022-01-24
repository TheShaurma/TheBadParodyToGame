package game_logic.objects_in_area.billiard_ball;

import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.CheckeredArea;
import game_logic.abstractions.interfaces.IntegerPos;
import game_logic.objects_in_area.abstractions.ObjectCanMovingByDirection;

public class BilliardBall extends ObjectCanMovingByDirection {

    public BilliardBall(CheckeredArea ar, IntegerPos pos) throws PositionException {
        super(ar, pos);
    }

}
