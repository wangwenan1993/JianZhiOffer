/**
 * Created by Administrator on 2018/8/11.
 */
public class _9_JumpFloorII {
    public int JumpFloorII(int target) {
        if (target <= 0) return 0;
        int[] result = new int[target+1];
        result[0] = 1;
        result[1] = 1;
        for(int i = 2; i <= target; i++) {
            result[i] = result[i-1] + result[i-1];
        }
        return result[target];
    }

    public static void main(String[] args) {
        _9_JumpFloorII jump = new _9_JumpFloorII();
        System.out.println(jump.JumpFloorII(4));
    }
}
