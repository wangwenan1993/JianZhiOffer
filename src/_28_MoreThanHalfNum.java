/**
 * @Author wangwenan
 * @data 2018/8/16 17:12
 */
public class _28_MoreThanHalfNum {
    /**
     * 思路二：如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
     在遍历数组时保存两个值：一是数组中一个数字，一是次数。遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；
     若次数为0，则保存下一个数字，并将次数置为1。遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution(int[] array) {
        if(array.length == 0) return 0;
        int num  = array[0], count = 1;
        for(int i = 1; i < array.length; i++) {
            if(array[i] == num) count++;
            else count--;
            if(count == 0) {
                num = array[i];
                count = 1;
            }
        }
        count = 0;
        for(int i = 0; i < array.length; i++) {
            if(num == array[i]) count++;
        }
        if(2*count > array.length) return num;
        return 0;
    }
}
