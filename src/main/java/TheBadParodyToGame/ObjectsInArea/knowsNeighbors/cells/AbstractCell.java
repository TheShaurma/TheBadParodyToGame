package TheBadParodyToGame.objectsInArea.knowsNeighbors.cells;

import TheBadParodyToGame.area.ConstantArea;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;
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

    abstract boolean getAliveNextStep() throws EmptyPositionException, PositionCannotExistInAreaException;

    abstract boolean willSurvive() throws EmptyPositionException, PositionCannotExistInAreaException;

    abstract boolean willDead() throws EmptyPositionException, PositionCannotExistInAreaException;

    abstract boolean willBorn() throws EmptyPositionException, PositionCannotExistInAreaException;

    abstract int getNumOfAliveNeighbors() throws EmptyPositionException, PositionCannotExistInAreaException;

    public boolean isAlive() {
        return alive;
    }
}
