import java.util.ArrayList;

/**
 * Created by Administrator on 2018/8/12.
 */
public class _13_ReOrderArray {
    public void reOrderArray(int [] array) {
        ArrayList<Integer> left = new ArrayList();
        ArrayList<Integer> right = new ArrayList();
        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 1) {
                left.add(array[i]);
            } else {
                right.add(array[i]);
            }
        }
        for(int i = 0; i < left.size(); i++) {
            array[i] = left.get(i);
        }
        for(int i = 0; i < right.size(); i++) {
            array[left.size()+i] = right.get(i);
        }
    }
}
