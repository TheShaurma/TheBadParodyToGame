package TheBadParodyToGame.ObjectsInArea.player;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;

public class Player implements ObjectInArea {
    private String name;

    public Player() {
        super();

        name = "NoName";
    }

    public Player(String name) {
        super();

        this.name = name;
    }

    private static final long serialVersionUID = 5L;

    @Override
    public String toString() {
        return "Player \"" + name + "\"";
    }
}
