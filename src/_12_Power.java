/**
 * Created by Administrator on 2018/8/12.
 */
public class _12_Power {

    public static void main(String[] args) {
        System.out.println(power(3, 3));
        System.out.println(powerAnother(3, 3));
    }
    // 使用递归
    public static double power(double base, int exponent) {
        int n = Math.abs(exponent);
        double result = 0.0;
        if (n == 0)
            return 1.0;
        if (n == 1)
            return base;

        result = power(base, n >> 1);
        result *= result;
        if ((n & 1) == 1) // 如果指数n为奇数，则要再乘一次底数base
            result *= base;
        if (exponent < 0) // 如果指数为负数，则应该求result的倒数
            result = 1 / result;

        return result;
    }
    // 使用累乘
    public static double powerAnother(double base, int exponent) {
        double result = 1.0;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }
        if (exponent >= 0)
            return result;
        else
            return 1 / result;
    }
}
