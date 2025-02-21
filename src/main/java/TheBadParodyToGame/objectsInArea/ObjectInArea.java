package TheBadParodyToGame.objectsInArea;

/**
 * Object in area is Interface used in Area.
 * Areas can contain only Object of class implements this interface.
 */
public interface ObjectInArea {
    default char getChar() {
        return ' ';
    }
}
