/**
 * Created by Administrator on 2018/8/12.
 */
public class _12_Power {

    public static void main(String[] args) {
        System.out.println(power(3, 3));
        System.out.println(powerAnother(3, 3));
    }
    // ʹ�õݹ�
    public static double power(double base, int exponent) {
        int n = Math.abs(exponent);
        double result = 0.0;
        if (n == 0)
            return 1.0;
        if (n == 1)
            return base;

        result = power(base, n >> 1);
        result *= result;
        if ((n & 1) == 1) // ���ָ��nΪ��������Ҫ�ٳ�һ�ε���base
            result *= base;
        if (exponent < 0) // ���ָ��Ϊ��������Ӧ����result�ĵ���
            result = 1 / result;

        return result;
    }
    // ʹ���۳�
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
