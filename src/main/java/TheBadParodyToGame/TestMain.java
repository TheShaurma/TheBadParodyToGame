package TheBadParodyToGame;

import java.io.IOException;

import TheBadParodyToGame.area.position.exceptions.PositionException;
import TheBadParodyToGame.gameManagers.GameManager;
import TheBadParodyToGame.objectsInArea.CannotMoveObjectException;
import TheBadParodyToGame.objectsInArea.LostObjectException;
import TheBadParodyToGame.writeRead.CannotFindFileException;
import TheBadParodyToGame.writeRead.InvalidFileException;
import TheBadParodyToGame.writeRead.UnknownSymbolException;

public class TestMain {
    public static void main(String[] args)
            throws PositionException,
            IOException,
            UnknownSymbolException,
            LostObjectException,
            CannotMoveObjectException,
            CannotFindFileException,
            InvalidFileException {

        var manager = new GameManager();
        manager.init();
        manager.start();
    }
}
