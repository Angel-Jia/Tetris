import javax.swing.*;
import java.awt.*;

/**
 * Created by YSK on 2016/9/6.
 */
public class View extends JPanel {
    private Field field;
    private static int GRID_SIZE = 20;

    public View(Field field){
        this.field = field;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        field.draw(g, GRID_SIZE);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(field.getWidth() * GRID_SIZE + 1, field.getHeight() * GRID_SIZE + 1);
    }
}
