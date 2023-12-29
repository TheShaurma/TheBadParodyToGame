package TheBadParodyToGame.writeRead;

import com.google.gson.Gson;

import TheBadParodyToGame.area.GameArea;

public class AreaWriteReader {
    private static final Gson gson = new Gson();

    public String convertToString(GameArea area) {
        return gson.toJson(area);
    }

    public GameArea getAreaByString(String str) {
        return gson.fromJson(str, GameArea.class);
    }
}
