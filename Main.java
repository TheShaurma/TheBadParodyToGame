import game_logic.abstractions.interfaces.CheckeredZone;
import game_logic.abstractions.interfaces.ZoneVisualization;
import game_logic.game_zone.GameZone;
import game_logic.objects_on_zone.billiard_ball.BilliardBall;
import game_logic.visualizatons.ConsoleGameLocationVisualization;

public class Main {
    public static void main(String[] args) throws Exception {
        CheckeredZone location = new GameZone(70, 89 + 70);
        ZoneVisualization visual = new ConsoleGameLocationVisualization(location);
        BilliardBall ball = new BilliardBall(location);

        ball.moveByEnd();
        visual.showField();

        visual.close();
    }
}
