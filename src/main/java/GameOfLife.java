import java.util.Scanner;

import TheBadParodyToGame.area.position.PositionException;
import TheBadParodyToGame.gameManagers.GameOfLifeManager;

public class GameOfLife {
    public static void main(String[] args) throws PositionException {
        var in = new Scanner(System.in);
        var manager = new GameOfLifeManager();

        manager.startGame();
        manager.showConsole();
        int input = in.nextInt();

        while (input != 0) {
            for (; input > 0; input--) {
                System.out.println(String.format("---%d---", manager.getStep()));
                manager.nextStep();
            }
            manager.showConsole();

            input = in.nextInt();
        }

        in.close();
    }
}
