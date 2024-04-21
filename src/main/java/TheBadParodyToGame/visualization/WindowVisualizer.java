package TheBadParodyToGame.visualization;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import TheBadParodyToGame.area.ConstantAreaContainsAll;
import TheBadParodyToGame.area.position.Position;
import TheBadParodyToGame.area.position.exceptions.BusyPositionException;
import TheBadParodyToGame.area.position.exceptions.EmptyPositionException;
import TheBadParodyToGame.area.position.exceptions.PositionCannotExistInAreaException;
import TheBadParodyToGame.objectsInArea.movingObjects.entities.player.Player;

public class WindowVisualizer {
    private final ConsoleVisualizer consoleVisualizer;
    private final JFrame frame;
    private final JTextArea textArea;
    private final Player player;

    public WindowVisualizer(ConstantAreaContainsAll area, Position minPos,
            Position maxPos,
            Player player) throws BusyPositionException,
            PositionCannotExistInAreaException, EmptyPositionException {
        consoleVisualizer = new ConsoleVisualizer(area, minPos, maxPos, player);

        this.player = player;

        frame = new GameFrame();
        textArea = new JTextArea();
        initFrame();
        frame.setVisible(true);
    }

    public void showArea() throws PositionCannotExistInAreaException,
            EmptyPositionException {
        textArea.setText(String.format(
                "%s - %s\n%s",
                player.getHPString(),
                player.getName(),
                consoleVisualizer.getAreaString()));
    }

    public void closeWindow() {
        frame.dispose();
    }

    private void initFrame() throws PositionCannotExistInAreaException, EmptyPositionException {
        textArea.setText(consoleVisualizer.getAreaString());
        textArea.setFont(new Font("Monocraft", Font.PLAIN, 20));
        frame.add(textArea);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("TheBadParodyToGame");
        frame.setResizable(true);
        frame.pack();
    }
}