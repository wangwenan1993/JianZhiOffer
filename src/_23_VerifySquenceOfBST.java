/**
 * @Author wangwenan
 * @data 2018/8/15 11:26
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class _23_VerifySquenceOfBST {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length == 0) return false;
        return isSubBST(sequence, 0, sequence.length-1);
    }
    public static boolean isSubBST(int[] sequence, int left, int right) {
        if(left >= right) return true;
        int mid = left;
        while(mid < right && sequence[mid] < sequence[right]) mid++;
        for(int i = mid + 1; i < right; i++) {
            if(sequence[i] < sequence[right]) return false;
        }
        return isSubBST(sequence, left, mid-1) && isSubBST(sequence, mid, right-1);
    }
}
