package TheBadParodyToGame;

import java.io.IOException;

import TheBadParodyToGame.area.position.exceptions.PositionException;
import TheBadParodyToGame.gameManagers.GameManager;
import TheBadParodyToGame.writeRead.UnknownSymbolException;

public class TestMain {
    public static void main(String[] args) throws PositionException, IOException, UnknownSymbolException {
        var manager = new GameManager();
        manager.init();
        manager.start();
    }
}
