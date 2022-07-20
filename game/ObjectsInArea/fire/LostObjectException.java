package game.ObjectsInArea.fire;

public class LostObjectException extends Exception {
    @Override
    public String toString() {
        return "Manager lost its object.";
    }
}
