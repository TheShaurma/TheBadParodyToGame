package TheBadParodyToGame.objectsInArea;

public abstract class ObjectException extends Exception {
    private final ObjectInArea object;

    public ObjectException(ObjectInArea object) {
        this.object = object;
    }

    public final ObjectInArea getObject() {
        return object;
    }

    @Override
    public String toString() {
        return String.format("Exception with %s.", getObject().toString());
    }
}
