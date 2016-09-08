import java.awt.*;
import java.util.LinkedList;

/**
 * Created by YSK on 2016/9/6.
 */
public abstract class Block {

    public abstract LinkedList<Location> getLocations();

    public abstract boolean rotate(MyCube[][] allCubes);

    public abstract boolean moveLeft(MyCube[][] allCubes);

    public abstract boolean moveRight(MyCube[][] allCubes);

    public abstract boolean moveDown(MyCube[][] allCubes);

    public abstract boolean isBlockFinished(MyCube[][] allCubes);

    public abstract boolean isCreateSucess(MyCube[][] allCubes);

    public abstract void draw(Graphics g, int size);
}
