package TheBadParodyToGame.visualization;

import java.awt.Color;
import javax.swing.JPanel;

import TheBadParodyToGame.ObjectsInArea.ObjectInArea;
import TheBadParodyToGame.area.position.IntegerPosition2D;

public class GamePanel extends JPanel implements ObjectInArea {
    public static final int WIDTH___ = 35; // ширина
    public static final int HEIGHT___ = 35; // высота

    public GamePanel(Color color, IntegerPosition2D pos) {
        setColor(color);

        int x = pos.getX();
        int y = pos.getY();
        setBounds(x * WIDTH___, y * HEIGHT___, WIDTH___, HEIGHT___);
    }

    public void setColor(Color color) {
        setBackground(color);
    }
}
