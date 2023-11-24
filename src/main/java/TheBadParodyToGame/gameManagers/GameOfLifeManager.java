package TheBadParodyToGame.gameManagers;

import java.util.Random;

import TheBadParodyToGame.area.AbstractArea;
import TheBadParodyToGame.area.GameOfLifeArea;
import TheBadParodyToGame.area.LoopedAreaAdaptor;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;
import TheBadParodyToGame.area.position.PositionException;
import TheBadParodyToGame.objectsInArea.knowsNeighbors.cells.AbstractCell;
import TheBadParodyToGame.objectsInArea.knowsNeighbors.cells.GameOfLifeCell;
import TheBadParodyToGame.visualization.SimpleVisualizer;

public class GameOfLifeManager {
    private int step = 0;
    private GameOfLifeArea evenStep;
    private GameOfLifeArea oddStep;

    private int xMin = 0;
    private int xMax = 100;
    private int yMin = 0;
    private int yMax = 20;

    private final Random random = new Random();
    private SimpleVisualizer evenVisualizer;
    private SimpleVisualizer oddVisualizer;

    public void startGame() throws PositionCannotExistInAreaException {
        evenStep = getFilledArea();
        oddStep = getFilledArea();

        Position minPos = new GamePosition(xMin, yMin);
        Position maxPos = new GamePosition(xMax, yMax);
        evenVisualizer = new SimpleVisualizer(minPos, maxPos, evenStep);
        oddVisualizer = new SimpleVisualizer(minPos, maxPos, oddStep);
    }

    public void nextStep() throws EmptyPositionException, PositionCannotExistInAreaException {
        GameOfLifeArea currentArea, futureArea;
        if (step % 2 == 0) {
            currentArea = evenStep;
            futureArea = oddStep;
        } else {
            currentArea = oddStep;
            futureArea = evenStep;
        }

        for (Position pos : currentArea) {
            AbstractCell currentCell = currentArea.get(pos);
            AbstractCell futureCell = futureArea.get(pos);
            futureCell.setAlive(currentCell.getNextStep());
        }

        step++;
    }

    public void nextStep(int n) throws EmptyPositionException, PositionCannotExistInAreaException {
        for (; n > 0; n--) {
            nextStep();
        }
    }

    public void showConsole() throws PositionException {
        System.out.println("Step: " + step);

        if (step % 2 == 0) {
            evenVisualizer.showConsole();
        } else {
            oddVisualizer.showConsole();
        }
        System.out.println("\n\n\n");
    }

    public int getStep() {
        return step;
    }

    private GameOfLifeArea getFilledArea() throws PositionCannotExistInAreaException {
        CellsArea area = new CellsArea(xMax, yMax);
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
class CellsArea extends LoopedAreaAdaptor<AbstractCell> implements GameOfLifeArea {
    public CellsArea(int xMax, int yMax) {
        super(new CelArea(), xMax, yMax);
    }

}

class CelArea extends AbstractArea<AbstractCell> {
}
