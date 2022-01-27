import game_logic.abstractions.basis_exceptions.PositionException;
import game_logic.abstractions.interfaces.AreaVisualization;
import game_logic.abstractions.interfaces.CheckeredArea;
import game_logic.game_area.GameArea;
import game_logic.objects_in_area.abstractions.exceptions.BusyPositionException;
import game_logic.objects_in_area.billiard_ball.BilliardBall;
import game_logic.objects_in_area.billiard_ball.InAngleException;
import game_logic.visualizatons.ConsoleGameAreaVisualization;

public class Main {
    public static void main(String[] args) throws PositionException, BusyPositionException, InAngleException {
        CheckeredArea area = new GameArea(51, 82);
        AreaVisualization visual = new ConsoleGameAreaVisualization(area);
        BilliardBall ball = new BilliardBall(area);

        ball.runToEnd();
        visual.showField();
    }
}
