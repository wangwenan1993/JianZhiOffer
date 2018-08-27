/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 n<=39
 */
public class _7_Fibonacci {
    public int Fibonacci(int n) {
        // method1 DP
//        int pre = 0, curr = 1;
//        while(n-- >= 0) {
//            curr += pre;
//            pre = curr - pre;
//        }
//        return pre;

        //method2 recursion
//        if(n <= 1) return n;
//        return Fibonacci(n-2) + Fibonacci(n-1);


        // DP + recursion
        if(n<=1){
            return n;
        }
        if(null == record){
            record = new int[n+1];
        }
        if(0 != record[n-2] && 0 != record[n-1]){  //是否已被计算
            record[n] = record[n-2] + record[n-1];
            return record[n];
        } else {
            return Fibonacci(n-2) + Fibonacci(n-1);
        }
    }

    public static int[] record = null;

    public static void main(String[] args) {
        _7_Fibonacci f = new _7_Fibonacci();
        System.out.println(f.Fibonacci(10));
    }
}
