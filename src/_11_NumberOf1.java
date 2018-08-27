/**
 * Created by Administrator on 2018/8/11.
 */
public class _11_NumberOf1 {
    public int NumberOf1(int n) {
        int count = 0, flag = 1;
        while(flag != 0) {
            if((flag & n) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public int NumberOf1_bak(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        _11_NumberOf1 num = new _11_NumberOf1();
        int n = 10;
        System.out.println(num.NumberOf1_bak(n));

    }
}
