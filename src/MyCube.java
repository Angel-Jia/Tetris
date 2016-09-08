import java.awt.*;

/**
 * Created by YSK on 2016/9/6.
 */
public class MyCube {
    private Color color;

    public MyCube(Color color){
        this.color = color;
    }

    public void draw(Graphics g, int x, int y, int size){
        g.setColor(color);
        g.fillRect(x * size, y * size, size, size);
    }
}
