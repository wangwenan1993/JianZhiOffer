/**
 * Created by Administrator on 2018/8/11.
 */
public class JumpFloor_7 {
    public int JumpFloor(int target) {
        if (target <= 0) return 0;
        int[] result = new int[target+1];
        result[0] = 1;
        result[1] = 1;
        for(int i = 2; i <= target; i++) {
            result[i] = result[i-2] + result[i-1];
        }
        return result[target];
    }

    public static void main(String[] args) {
        JumpFloor_7 jump = new JumpFloor_7();
        System.out.println(jump.JumpFloor(5));
    }
}
