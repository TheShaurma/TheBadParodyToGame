import game_logic.abstractions.interfaces.CheckeredArea;
import game_logic.abstractions.interfaces.AreaVisualization;
import game_logic.game_area.GameArea;
import game_logic.objects_in_area.billiard_ball.BilliardBall;
import game_logic.visualizatons.ConsoleGameAreaVisualization;

public class Main {
    public static void main(String[] args) throws Exception {
        CheckeredArea location = new GameArea(70, 89 + 70);
        AreaVisualization visual = new ConsoleGameAreaVisualization(location);
        BilliardBall ball = new BilliardBall(location);

        ball.moveByEnd();
        visual.showField();

        visual.close();
    }
}
