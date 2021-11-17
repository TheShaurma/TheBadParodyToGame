import game_logic.GameLocation;
import game_logic.GameLocationVisualization;
import game_logic.Ball;
import game_logic.intarfaces.IntegerPos;

import game_logic.IntegerPosition;

public class Main {
    public static void main(String[] args) {
        GameLocation field = new GameLocation();
        IntegerPos pos = new IntegerPosition(0, 0);
        Ball obj = new Ball(field, pos);
        field.putObject(pos, obj);
        GameLocationVisualization visual = new GameLocationVisualization(field);

        visual.showField();
        System.out.println("The end!!!");
    }
}
