package TheBadParodyToGame.objectsInArea.knowsNeighbors.cells;

import TheBadParodyToGame.area.ConstantArea;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

public class GameOfLifeCell extends AbstractCell {
    public GameOfLifeCell(ConstantArea<AbstractCell> area, Position pos) {
        super(area, pos);
    }

    public GameOfLifeCell(ConstantArea<AbstractCell> area, Position pos, boolean alive) {
        super(area, pos, alive);
    }

    @Override
    boolean getAliveNextStep() throws EmptyPositionException, PositionCannotExistInAreaException {
        if (isAlive()) {
            if (willSurvive()) {
                return true;
            } else {
                return false;
            }
        } else {
            if (willBorn()) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    boolean willSurvive() throws EmptyPositionException, PositionCannotExistInAreaException {
        int num = getNumOfAliveNeighbors();
        return num == 2 || num == 3;
    }

    @Override
    boolean willDead() throws EmptyPositionException, PositionCannotExistInAreaException {
        return !willSurvive();
    }

    @Override
    boolean willBorn() throws EmptyPositionException, PositionCannotExistInAreaException {
        return getNumOfAliveNeighbors() == 3;
    }

    @Override
    int getNumOfAliveNeighbors() throws EmptyPositionException, PositionCannotExistInAreaException {
        int result = 0;
        var area = getArea();
        for (Position pos : getAllNeighborsPositions()) {
            AbstractCell cell = area.get(pos);
            if (cell.isAlive()) {
                result++;
            }
        }
        return result;
    }

    @Override
    public char getChar() {
        if (isAlive()) {
            return '@';
        } else {
            return ' ';
        }
    }
}
