package game.rooms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import game.ObjectsInArea.ObjectInArea;
import game.ObjectsInArea.Stone;
import game.ObjectsInArea.fire.Fire;
import game.area.GameArea;
import game.area.IntegerPosition2D;
import game.area.PositionException;

public class GameAreaReader {
    public static GameArea readArea(String areaName) throws IOException, UnknownSymbolException, PositionException {
        GameArea area = new GameArea();

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
                        area.place(new IntegerPosition2D(x, y), obj);
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
            return new Fire();
        }
        throw new UnknownSymbolException(ch);
    }
}
