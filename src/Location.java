import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by YSK on 2016/9/6.
 */
public class Location implements Comparable<Location>{
    private int x, y;
    private Color color;

    public Location(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void setLocation(int offsetx, int offsety){
        x += offsetx;
        y += offsety;
    }



    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Color getColor(){
        return color;
    }

    @Override
    public int compareTo(Location o) {
        if (x == o.getX() && y == o.getY()){
            return 0;
        }else if(y <= o.getY()){
            return 1;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        LinkedList<Location> locations = new LinkedList<Location>();
        locations.add(0, new Location(1, 2, Color.gray));
        locations.add(0, new Location(1, 1, Color.gray));
        locations.add(0, new Location(1, 3, Color.gray));
        locations.add(0, new Location(1, 0, Color.gray));
        Collections.sort(locations);
        for(Location location:locations){
            System.out.println(location.getX() + "," + location.getY());
        }
    }
}
