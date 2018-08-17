/**
 * Created by Administrator on 2018/8/11.
 */
public class JumpFloorII_9 {
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
        JumpFloorII_9 jump = new JumpFloorII_9();
        System.out.println(jump.JumpFloorII(4));
    }
}
