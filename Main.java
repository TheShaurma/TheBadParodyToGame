import game_logic.BallManager;
import game_logic.GameLocation;
import game_logic.GameLocationVisualization;

public class Main {
    public static void main(String[] args) {
        GameLocation field = new GameLocation();
        BallManager ball = new BallManager(field);
        GameLocationVisualization visual = new GameLocationVisualization(field);

        visual.showField();
        System.out.println("The end!!!");
    }
}
