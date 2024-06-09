package TheBadParodyToGame.writeRead;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;

import TheBadParodyToGame.area.ConstantArea;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.ObjectInArea;

public class AreaWriter {
        private final OutputStreamWriter out;
        private final Gson gson;

        private static final String[] PATH = { "data", "rooms" };

        public AreaWriter(String fileName) throws IOException {
                Path dir = Files.createDirectories(
                                Paths.get(PATH[0], PATH[1]));

                Path path = dir.resolve(fileName + ".json");
                out = new OutputStreamWriter(
                                Files.newOutputStream(path),
                                StandardCharsets.UTF_8);

                gson = new Gson();
        }

        public <T extends ObjectInArea> void writeArea(ConstantArea<T> area)
                        throws IOException,
                        EmptyPositionException,
                        PositionCannotExistInAreaException {
                out.write("{\n");
                out.write(String.format(
                                "\"hash\": %d,\n",
                                area.hashCode()));

                for (Position pos : area.getAllBusyPositions()) {
                        ObjectInArea obj = area.get(pos);
                        String className = ClassesMap.getStringByClass(obj.getClass());
                        String json = gson.toJson(pos);
                        String line = String.format("\t\"%s\": %s,\n", className, json);

                        out.write(line);
                }
                out.write("\n}");
        }
}
