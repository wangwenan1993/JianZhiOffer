/**
 * @Author wangwenan
 * @data 2018/8/17 0:01
 */
public class _31_NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        int i=1;
        for(i=1;i<=n;i*=10)
        {
            //i表示当前分析的是哪一个数位
            int a = n/i,b = n%i;
            count=count+(a+8)/10*i + a%10==1 ? (b+1) : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        _31_NumberOf1Between1AndN f = new _31_NumberOf1Between1AndN();
        System.out.println(f.NumberOf1Between1AndN_Solution(13));
    }

}
