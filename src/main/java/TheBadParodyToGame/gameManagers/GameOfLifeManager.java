package TheBadParodyToGame.gameManagers;

import java.util.Random;

import TheBadParodyToGame.area.AbstractArea;
import TheBadParodyToGame.area.GameOfLifeArea;
import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.knowsNeighbors.cells.AbstractCell;
import TheBadParodyToGame.objectsInArea.knowsNeighbors.cells.GameOfLifeCell;

public class GameOfLifeManager {
    private final Random random = new Random();

    private GameOfLifeArea evenStep;
    private GameOfLifeArea oddStep;

    private int xMin = 0;
    private int xMax = 100;
    private int yMin = 0;
    private int yMax = 100;

    public void startGame() throws PositionCannotExistInAreaException {
        evenStep = getFilledArea();
        oddStep = getFilledArea();

    }

    private GameOfLifeArea getFilledArea() throws PositionCannotExistInAreaException {
        CellsArea area = new CellsArea();
        for (int x = xMin; x <= xMax; x++) {
            for (int y = yMin; y <= yMax; y++) {
                Position pos = new GamePosition(x, y);
                GameOfLifeCell GameOfLifeCell = new GameOfLifeCell(area, pos,
                        random.nextBoolean());
                area.set(pos, GameOfLifeCell);
            }
        }
        return area;
    }
}

/**
 * CellsArea
 */
class CellsArea extends AbstractArea<AbstractCell> implements GameOfLifeArea {
}
