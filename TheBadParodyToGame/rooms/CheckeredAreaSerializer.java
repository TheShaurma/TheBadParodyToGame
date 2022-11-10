package TheBadParodyToGame.rooms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import TheBadParodyToGame.area.CheckeredArea;

public class CheckeredAreaSerializer {
    public static CheckeredArea readArea(String fileName) throws IOException, ClassNotFoundException {
        File file = new File("data\\" + fileName);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            return (CheckeredArea) ois.readObject();
        } finally {
            ois.close();
        }
    }

    public static void writeArea(CheckeredArea area, String fileName) throws IOException {
        File file = new File("data\\" + fileName + ".data");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        try {
            oos.writeObject(area);
        } finally {
            oos.close();
        }
    }
}