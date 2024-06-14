package TheBadParodyToGame.writeRead;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import TheBadParodyToGame.area.GameArea;
import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;

public class GameAreaReader
        extends AbstractAreaReader<GameArea> {

    private JsonObject jsonObject;
    private final Gson gson;

    public GameAreaReader() {
        gson = new Gson();
    }

    @Override
    public GameArea readArea()
            throws InvalidFileException {

        GameArea result = new GameArea();

        List<String> buildingMaterialsClasses = ClassesMap.getAllClassesWithoutEntitiesStrings();
        Map<String, JsonElement> map = jsonObject.asMap();
        for (Entry<String, JsonElement> entry : map.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();

            if (!key.equals("hash")) {
                for (JsonElement posJson : value.getAsJsonArray()) {
                    Position pos = gson.fromJson(posJson, GamePosition.class);

                    if (buildingMaterialsClasses.contains(key)) {
                        try {
                            result.place(
                                    pos,
                                    ClassesMap.createObjectOfClass(
                                            ClassesMap.getClassByString(key)));

                        } catch (BusyPositionException | PositionCannotExistInAreaException e) {
                            throw new InvalidFileException(this, getFileName());
                        }
                    }
                }
            }
        }

        return result;

    }

    @Override
    public void close()
            throws IOException {
    }

    @Override
    public void setFileName(String fileName)
            throws CannotFindFileException,
            InvalidFileException {

        super.setFileName(fileName);

        Reader reader = createReader(fileName);
        jsonObject = getAsJsonObject(reader);
    }

    protected Reader createReader(String fileName)
            throws CannotFindFileException {

        try {
            String sep = File.separator;

            return new FileReader(
                    PATH[0] + sep + PATH[1] + sep + getFileName() + ".json",
                    StandardCharsets.UTF_8);

        } catch (IOException e) {
            throw new CannotFindFileException(this, fileName);
        }
    }

    protected JsonObject getAsJsonObject(Reader reader)
            throws CannotFindFileException,
            InvalidFileException {

        JsonObject result;
        JsonElement jsonElement = JsonParser.parseReader(reader);
        result = jsonElement.getAsJsonObject();

        return result;
    }
}
