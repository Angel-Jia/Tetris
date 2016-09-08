/**
 * Created by YSK on 2016/9/6.
 */
public class Factory {
    public static Block createBlock(Field field){
        /*int randomBlock = (int) (Math.random() * 5);*/
        int randomBlock = 0;
        switch (randomBlock){
            case 0:
                return new BlockCube(field);
            case 1:
                return new BlockI(field);
            case 2:
                return new BlockL(field);
            case 3:
                return new BlockT(field);
            case 4:
                return new BlockZ(field);
            default:
                return null;
        }
    }
}
