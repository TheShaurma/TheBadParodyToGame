import game_logic.abstractions.interfaces.Location;
import game_logic.abstractions.interfaces.LocationVisualization;
import game_logic.game_location.GameLocation;
import game_logic.objects_on_location.billiard_ball.BilliardBall;
import game_logic.visualizatons.ConsoleGameLocationVisualization;

public class Main {
    public static void main(String[] args) throws Exception {
        Location location = new GameLocation(80, 89);
        LocationVisualization visual = new ConsoleGameLocationVisualization(location);
        BilliardBall ball = new BilliardBall(location);

        while (ball.canMoving()) {
            // visual.showField();
            ball.step();
        }
        visual.showField();

        visual.close();
    }
}
