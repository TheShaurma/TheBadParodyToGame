package TheBadParodyToGame.objectsInArea;

public class MobDiedException extends ObjectException {
    public MobDiedException(ObjectInArea object) {
        super(object);
    }

    @Override
    public String toString() {
        return String.format("%s is died.", getObject());
    }
}
