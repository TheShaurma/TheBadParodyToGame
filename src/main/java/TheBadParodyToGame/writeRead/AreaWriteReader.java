package TheBadParodyToGame.writeRead;

import com.google.gson.Gson;

import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;

// TODO: docs
@Deprecated
public class AreaWriteReader {
    private static final Gson gson = new Gson();

    public String convertPositionToString(Position pos) {
        return gson.toJson(pos);
    }

    public GamePosition getPositionByString(String str) {
        return gson.fromJson(str, GamePosition.class);
    }
}
