package game.rooms;

import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

import game.ObjectsInArea.ObjectInArea;
import game.ObjectsInArea.Stone;
import game.ObjectsInArea.fire.GameFire;
import game.area.CheckeredArea;
import game.area.GameArea;
import game.area.position.GameIntegerPosition2D;
import game.area.position.PositionException;

/**
 * GameAreaReader
 */
@Deprecated
public class CheckeredAreaReader {
    public static CheckeredArea readArea(String areaName)
            throws IOException, UnknownSymbolException, PositionException {
        CheckeredArea area = new GameArea();

        FileReader reader = new FileReader(areaName);
        try (Scanner scanner = new Scanner(reader)) {
            String line;
            int x;
            int y = 0;
            char ch;
            ObjectInArea obj;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();

                x = 0;
                for (int i = 0; i < line.length(); i++) {
                    ch = line.charAt(i);
                    if (ch != ' ') {
                        obj = getObjectByCharacter(ch);
                        area.place(new GameIntegerPosition2D(x, y), obj);
                    }
                    x++;
                }
                y++;
            }
        }

        reader.close();
        return area;
    }

    private static ObjectInArea getObjectByCharacter(char ch) throws UnknownSymbolException {
        if (ch == 's') {
            return new Stone();
        } else if (ch == 'f') {
            return new GameFire();
        }
        throw new UnknownSymbolException(ch);
    }
}
