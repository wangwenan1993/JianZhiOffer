/**
 * Created by Administrator on 2018/8/19.
 * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
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
     * �ݹ����, ͬʱʹ�ö�·����ʵ��ֹͣ����
     * @param n
     * @return
     */
    public int Sum_Solution1(int n) {
        int ans = n;
        boolean i = ans > 0 && (ans += Sum_Solution1(n-1)) > 0;
        return ans;
    }
}
