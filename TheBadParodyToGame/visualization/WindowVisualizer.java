package TheBadParodyToGame.visualization;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

import TheBadParodyToGame.ObjectsInArea.affectingToHP.Apple;
import TheBadParodyToGame.ObjectsInArea.affectingToHP.Fire;
import TheBadParodyToGame.ObjectsInArea.buildingMaterials.Stone;
import TheBadParodyToGame.ObjectsInArea.player.Player;
import TheBadParodyToGame.area.abstractions.AbstractCheckeredArea;
import TheBadParodyToGame.area.abstractions.ConstantCheckeredAreaContainsAll;
import TheBadParodyToGame.area.position.BusyPositionException;
import TheBadParodyToGame.area.position.EmptyPositionException;
import TheBadParodyToGame.area.position.GameIntegerPosition2D;
import TheBadParodyToGame.area.position.IntegerPosition2D;
import TheBadParodyToGame.area.position.PositionCannotExistInAreaException;

public class WindowVisualizer {
    private static final Color EMPTY_POSITION_COLOR = new Color(190, 189, 191);
    private static Map<Class<?>, Color> colorMap;
    private final int width;
    private final int height;
    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;
    private final ConstantCheckeredAreaContainsAll area;
    private final PanelsArea panelsArea = new PanelsArea();
    private final JFrame frame;
    private final Player player;
    private final JLabel bottomLabel = new JLabel();

    static {
        colorMap = new ColorMap();
        colorMap.put(Player.class, new Color(4, 191, 191));
        colorMap.put(Stone.class, new Color(84, 110, 122));
        colorMap.put(Apple.class, new Color(69, 191, 85));
        colorMap.put(Fire.class, new Color(195, 15, 14));
    }

    public WindowVisualizer(ConstantCheckeredAreaContainsAll area, IntegerPosition2D minPos, IntegerPosition2D maxPos,
            Player player) throws BusyPositionException, PositionCannotExistInAreaException, EmptyPositionException {
        width = max(minPos.getX(), maxPos.getX()) -
                min(minPos.getX(), maxPos.getX()) * GamePanel.WIDTH___;
        height = max(minPos.getY(), maxPos.getY()) -
                min(minPos.getY(), maxPos.getY()) * GamePanel.HEIGHT___ + 40;

        minX = min(minPos.getX(), maxPos.getX());
        maxX = max(minPos.getX(), maxPos.getX());
        minY = min(minPos.getY(), maxPos.getY());
        maxY = max(minPos.getY(), maxPos.getY());

        this.area = area;
        this.player = player;

        frame = new GameFrame();
        initFrame();
        frame.setVisible(true);
    }

    public void showArea() throws PositionCannotExistInAreaException, EmptyPositionException {
        GamePanel panel;
        Color color;
        for (IntegerPosition2D pos : panelsArea) {
            panel = panelsArea.get(pos);
            try {
                color = colorMap.get(area.get(pos).getClass());
            } catch (EmptyPositionException e) {
                color = ColorMap.DEFAULT_COLOR;
            }
            panel.setColor(color);
        }

        setBottomText(player.getHPString());
    }

    private void initFrame() throws BusyPositionException, PositionCannotExistInAreaException, EmptyPositionException {
        frame.setSize(width, height);

        for (int x = minX; x < maxX + 1; x++) {
            for (int y = minY; y < maxY + 1; y++) {
                GameIntegerPosition2D pos = new GameIntegerPosition2D(x, y);
                GamePanel panel = new GamePanel(EMPTY_POSITION_COLOR, convertPos(pos));
                panelsArea.place(pos, panel);
                frame.add(panel);
            }
        }

        bottomLabel.setFont(new FontUIResource("Hack", Font.BOLD, 20));
        bottomLabel.setHorizontalTextPosition(JLabel.CENTER);
        bottomLabel.setVerticalTextPosition(JLabel.CENTER);

        JPanel panel = new JPanel();
        panel.add(bottomLabel);
        panel.setBounds(width, height - 40, width, 40);
        panel.setBackground(new Color(28, 29, 33));
        frame.add(panel);

        showArea();
    }

    private void setBottomText(String text) {
        bottomLabel.setText(text);
    }

    private IntegerPosition2D convertPos(IntegerPosition2D pos) {
        return new GameIntegerPosition2D(
                pos.getX() - minX,
                maxY - pos.getY());
    }

}

class ColorMap extends HashMap<Class<?>, Color> {
    public static final Color DEFAULT_COLOR = new Color(156, 39, 176);

    @Override
    public Color get(Object key) {
        if (!containsKey(key)) {
            return DEFAULT_COLOR;
        } else {
            return super.get(key);
        }
    }
}

class PanelsArea extends AbstractCheckeredArea<GamePanel> {
}