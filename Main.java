import game_logic.GameLocation;
import game_logic.GameLocationVisualization;
import game_logic.intarfaces.Location;
import game_logic.intarfaces.LocationVisualization;
import game_logic.objects_on_field.billiard_ball.BilliardBall;

public class Main {
    public static void main(String[] args) throws Exception {
        Location location = new GameLocation(20, 13);
        LocationVisualization visual = new GameLocationVisualization(location);
        BilliardBall ball = new BilliardBall(location);

        while (ball.canRiding()) {
            ball.step();
            visual.showField();
        }
    }
}
