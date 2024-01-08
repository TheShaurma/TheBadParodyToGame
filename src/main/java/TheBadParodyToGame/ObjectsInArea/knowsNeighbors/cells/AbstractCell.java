package TheBadParodyToGame.objectsInArea.knowsNeighbors.cells;

import TheBadParodyToGame.area.ConstantArea;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.knowsNeighbors.ObjectKnowsEightNeighborsPoses;

public abstract class AbstractCell extends ObjectKnowsEightNeighborsPoses<ConstantArea<AbstractCell>> {
    private boolean alive;

    public AbstractCell(ConstantArea<AbstractCell> area, Position pos) {
        super(area, pos);
        alive = false;
    }

    public AbstractCell(ConstantArea<AbstractCell> area, Position pos, boolean alive) {
        super(area, pos);
        this.alive = alive;
    }

    abstract public boolean getNextStep() throws EmptyPositionException, PositionCannotExistInAreaException;

    abstract public boolean willSurvive() throws EmptyPositionException, PositionCannotExistInAreaException;

    abstract public boolean willDead() throws EmptyPositionException, PositionCannotExistInAreaException;

    abstract public boolean willBorn() throws EmptyPositionException, PositionCannotExistInAreaException;

    abstract public int getNumOfAliveNeighbors() throws EmptyPositionException, PositionCannotExistInAreaException;

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
