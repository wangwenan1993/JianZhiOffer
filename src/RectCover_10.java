/**
 * Created by Administrator on 2018/8/11.
 */
public class RectCover_10 {
    /**
     * ˼·������
     ʹ��˼ʹ�����ǲ��ܹ�̰С���ˡ��ù��ɷ��������£�
     ��1���� n < 1ʱ����Ȼ����Ҫ��2*1�鸲�ǣ�������Ŀ��ʾӦ�÷��� 0��
     ��2���� n = 1ʱ��ֻ����һ�������

     ��3���� n = 2ʱ���������������

     ��4���� n = 3ʱ�����Ըо������û���·���˼ά�Ѷȱ�֮ǰ����ͦ��ġ�

     ... ���Թ��ɣ������� n ���Ƿ������඼�Ƕ� n - 1 ʱ����չ��
     ������ȷ��n ʱ�ض��� n-1ʱԭ����ʽ��2*1�ķ����ϡ�Ҳ����˵, f(n) = f(n-1) + ?(��ʱ�޷��ж�)��
     ��4������������ڹ��� n = 4��Ӧ����ʲô��ʽ��
     4.1������ԭ��n = 3ʱ���ݣ�����չһ�� 2*1 ���飬��ʽ�ֱ�Ϊ ��| | | |������= | |������| = |��
     4.2�������ӵ�2*1 �������ٽ���2*1������� 2*2�ṹ��Ȼ����Ա��γ� ��=�������� n = 4��ԭ��n = 3������������"| | ="����= =����
     ���Լ�������������������ʽ���ǲ���ֻ��n = 2���ˡ�=������ʵ����ǹؼ�������...��Ϊ��ֻҪ2*1��1*2����ͬ������ʱ���ͻ����2*2��ʽ�����Ǿ��ֿ��Ա����ˡ�
     ���ԣ���Ȼ��Ȼ���Եó����ɣ� f(n) = f(n-1) + f(n-2)�� (n > 2)��

     ���������һ�����ۻ������ɻ󡣿��Գ��Խ���Ŀ�ĳ�1*3���鸲��3*n��1*4���鸲��4*n��
     ��Ӧ�Ľ���Ӧ���ǣ�
     ��1��1 * 3���� �� ��3*n����f(n) = f(n-1) + f(n - 3)�� (n > 3)
     ��2�� 1 *4 ���� �� ��4*n����f(n) = f(n-1) + f(n - 4)��(n > 4)
     ��һ��Ľ��ۣ������1*m�ķ��鸲��m*n���򣬵��ƹ�ϵʽΪf(n) = f(n-1) + f(n-m)��(n > m)��
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target < 1) {
            return 0;
        } else if (target == 1 || target == 2) {
            return target;
        } else {
            return RectCover(target-1) + RectCover(target-2);
        }
    }

//    public int total = 0;
//    public int RectCover(int target) {
////        int total = 0;
//        count(target, true, 1);
//        count(target, false, 1);
//        return total;
//    }
//
//    public void count(int target, boolean is_vertical, int round) {
//        if (round == target) {
//            total += 1;
//            return;
//        }
//        if (is_vertical) {
//            count(target, true, round+1);
//            count(target, false, round+1);
//        } else {
//            count(target, false, round+1);
//        }
//    }

    public static void main(String[] args) {
        RectCover_10 rect = new RectCover_10();
        System.out.println(rect.RectCover(4));
    }
}
