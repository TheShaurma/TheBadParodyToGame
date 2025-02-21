package TheBadParodyToGame.objectsInArea;

public abstract class AbstractObject implements ObjectInArea {
    protected static final int HASH = 0;

    @Override
    public boolean equals(Object o) {
        return o.getClass() == this.getClass();
    }

    @Override
    public int hashCode() {
        return HASH;
    }
}
