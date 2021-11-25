import game_logic.BallManager;
import game_logic.GameLocation;
import game_logic.GameLocationVisualization;

public class Main {
    public static void main(String[] args) {
        GameLocation field = new GameLocation();
        BallManager ballManager = new BallManager(field);
        GameLocationVisualization visual = new GameLocationVisualization(field);

        ballManager.rideBallToEnd();
        visual.showField();
        System.out.println("The end!!!");
    }
}
