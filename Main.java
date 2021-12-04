import game_logic.GameLocationVisualization;
import game_logic.game_location.GameLocation;
import game_logic.intarfaces.Location;
import game_logic.intarfaces.LocationVisualization;
import game_logic.objects_on_field.billiard_ball.BilliardBall;

public class Main {
    public static void main(String[] args) throws Exception {
        Location location = new GameLocation(80, 89);
        LocationVisualization visual = new GameLocationVisualization(location);
        BilliardBall ball = new BilliardBall(location);

        while (ball.canMoving()) {
            // visual.showField();
            ball.step();
        }
        visual.showField();
    }
}
