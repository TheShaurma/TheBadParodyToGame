package TheBadParodyToGame.writeRead;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import TheBadParodyToGame.area.AreaContainsAll;
import TheBadParodyToGame.area.GameArea;
import TheBadParodyToGame.area.position.GamePosition;
import TheBadParodyToGame.area.position.exceptions.PositionException;
import TheBadParodyToGame.objectsInArea.ObjectInArea;
import TheBadParodyToGame.objectsInArea.affectingToHP.Apple;
import TheBadParodyToGame.objectsInArea.affectingToHP.Fire;
import TheBadParodyToGame.objectsInArea.buildingMaterials.Stone;

@Deprecated
public class LegacyAreaReader {
    public static AreaContainsAll readArea(String areaName)
            throws IOException, UnknownSymbolException, PositionException {
        AreaContainsAll area = new GameArea();

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
                        area.place(new GamePosition(x, y), obj);
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
        } else if (ch == 'a') {
            return new Apple((int) (1 + Math.random() * 9));
        }
        throw new UnknownSymbolException(ch);
    }
}
