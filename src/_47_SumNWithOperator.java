/**
 * Created by Administrator on 2018/8/19.
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class _47_SumNWithOperator {

    /**
     * sum = (1+n)n/2
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum = (int) (Math.pow(n,2) + n);
        return sum>>1;
    }

    /**
     * 递归相加, 同时使用短路计算实现停止条件
     * @param n
     * @return
     */
    public int Sum_Solution1(int n) {
        int ans = n;
        boolean i = ans > 0 && (ans += Sum_Solution1(n-1)) > 0;
        return ans;
    }
}
