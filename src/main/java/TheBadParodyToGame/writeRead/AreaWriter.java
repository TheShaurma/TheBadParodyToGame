package TheBadParodyToGame.writeRead;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;

import TheBadParodyToGame.area.ConstantArea;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.ObjectInArea;

public class AreaWriter<A extends ConstantArea<?>>
        implements Closeable {

    private OutputStreamWriter out;
    private final Gson gson;
    private A area;

    // TODO: file should written in default package
    private static final String[] PATH = {
            "data",
            "rooms"
    };

    public AreaWriter() {
        gson = new Gson();
    }

    @Override
    public void close() throws IOException {
        out.close();
    }

    public void writeArea()
            throws IOException,
            EmptyPositionException,
            PositionCannotExistInAreaException {

        out.write("{\n");
        out.write(String.format(
                "\t\"hash\": %d",
                area.hashCode()));

        var classes = getAllclassesInArea();

        for (Class<?> objectClass : classes) {
            writeAllObjectsOfClass(objectClass);
        }

        out.write("\n}");
    }

    public void setFileName(String fileName)
            throws IOException {

        Path dir = Files.createDirectories(
                Paths.get(PATH[0], PATH[1]));

        Path path = dir.resolve(fileName + ".json");
        out = new OutputStreamWriter(
                Files.newOutputStream(path),
                StandardCharsets.UTF_8);
    }

    public void setArea(A area) {
        this.area = area;
    }

    protected A getArea() {
        return area;
    }

    protected Iterable<Class<?>> getAllclassesInArea() {
        Set<Class<?>> result = new HashSet<>();

        for (ObjectInArea obj : getArea().getAllObjects()) {
            result.add(obj.getClass());
        }

        return result;
    }

    protected void writeAllObjectsOfClass(Class<?> objectClass)
            throws IOException,
            EmptyPositionException,
            PositionCannotExistInAreaException {

        out.write(String.format(",\n\t\"%s\": [", ClassesMap.getStringByClass(objectClass)));

        List<String> positionsInJSON = new ArrayList<>();
        for (Position pos : area.getAllBusyPositions()) {
            ObjectInArea obj = area.get(pos);

            if (obj.getClass() == objectClass) {
                positionsInJSON.add(gson.toJson(pos));
            }
        }

        int size = positionsInJSON.size();
        for (int i = 0; i < size; i++) {
            out.write(String.format("\n\t%s", positionsInJSON.get(i)));
            if (i != size - 1) {
                out.write(",");
            }
        }

        out.write("\n\t]");
    }
}
