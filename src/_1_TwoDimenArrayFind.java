/**
 * Created by Administrator on 2018/8/7.
 */
public class _1_TwoDimenArrayFind {
    public boolean Find(int target, int [][] array) {
        int row = 0, cols = array[0].length - 1;
        while(row < array.length && cols >= 0) {
            if(array[row][cols] > target) {
                cols--;
            } else if (array[row][cols] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
