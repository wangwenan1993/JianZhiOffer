/**
 * @Author wangwenan
 * @data 2018/8/16 23:42
 */
public class _30_FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int pre = array[0], max = array[0];
        for(int i = 1; i < array.length; i++) {
            if(pre >= 0) {
                pre += array[i];
            } else {
                pre = array[i];
            }
            if(pre > max) max = pre;
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] arr = {6,-3,-2,7,-15,1,2,2};
        int[] arr = {-3,-2,-7,-15};
        _30_FindGreatestSumOfSubArray f = new _30_FindGreatestSumOfSubArray();
        System.out.println(f.FindGreatestSumOfSubArray(arr));
    }
}
