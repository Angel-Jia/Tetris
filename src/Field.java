import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by YSK on 2016/9/6.
 */
public class Field{
    private int height;
    private int width;
    private MyCube[][] allCubes;
    private Block block;
    private LinkedList<Integer> blankLines = new LinkedList<Integer>();

    public Field(int height, int width){
        this.height = height;
        this.width = width;
        allCubes = new MyCube[height][width];
    }

    public boolean createBlock(){
        block = Factory.createBlock(this);
        return block.isCreateSucess(allCubes);
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public Color getColor(){
        int colorCode = (int) (Math.random() * 6);
        switch (colorCode){
            case 0:
                return new Color(0, 89, 131);
            case 1:
                return new Color(113, 73, 119);
            case 2:
                return new Color(243, 197, 42);
            case 3:
                return new Color(110, 189, 89);
            case 4:
                return new Color(156, 159, 186);
            case 5:
                return new Color(217, 61, 55);
            default:
                return null;
        }
    }

    public boolean isBlockFinished(){
        return block.isBlockFinished(allCubes);
    }

    public void blockFinished(){
        blankLines.clear();
        Collections.sort(block.getLocations());
        for (int i = 0; i < 4; i++) {
            allCubes[block.getLocations().get(i).getY()][block.getLocations().get(i).getX()] =
                    new MyCube(block.getLocations().get(i).getColor());
        }
        block = null;

        for (int i = 0; i < height; i++) {
            int cnt = 0;
            for (int j = 0; j < width; j++) {
                cnt = (allCubes[i][j] != null)? cnt + 1: cnt;
            }
            if (cnt == width){
                for (int j = 0; j < width; j++) {
                    allCubes[i][j] = null;
                }
                blankLines.add(0, new Integer(i));
            }
        }
    }

    public void removeLowestBlankLine(){
        for (int i = blankLines.get(0); i > 0 ; i--) {
            for (int j = 0; j < width; j++) {
                allCubes[i][j] = (allCubes[i - 1][j] == null)? null: allCubes[i - 1][j];
                allCubes[i - 1][j] = null;
            }
        }
        blankLines.remove(0);
        for (Integer line: blankLines) {
            ++line;
        }
        for (Integer line: blankLines) {
            System.out.println(line);
        }
    }

    public boolean hasNextBlankLine(){
        return blankLines.size() != 0;
    }

    public boolean keyUp(){
        return block != null && block.rotate(allCubes);
    }

    public boolean keyDown(){
        return block != null && block.moveDown(allCubes);
    }

    public boolean keyLeft(){
        return block != null && block.moveLeft(allCubes);
    }

    public boolean keyRight(){
        return block != null && block.moveRight(allCubes);
    }

    public void draw(Graphics g, int size){
        if (block != null){
            block.draw(g, size);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(allCubes[i][j] != null){
                    allCubes[i][j].draw(g, j, i, size);
                }
            }
        }
    }

}
