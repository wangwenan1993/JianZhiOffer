import java.math.BigInteger;

/**
 * Created by Administrator on 2018/8/19.
 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
 */
public class _48_AddWithOperator {
    /**
     * ���ȿ�ʮ������������ģ� 5+7=12��������
     ��һ������Ӹ�λ��ֵ�������λ���õ�2��
     �ڶ����������λֵ���õ�10. �����һ���Ľ�λֵΪ0����ô��һ���õ���ֵ�������ս����

     ���������ظ�����������ֻ����ӵ�ֵ������������ĵõ��Ľ��2��10���õ�12��

     ͬ�����ǿ����������ߵķ�ʽ���������ֵ��ӣ� 5-101��7-111 ��һ������Ӹ�λ��ֵ�������λ���õ�010��������ÿλ��Ӿ��൱�ڸ�λ����������101^111��

     �ڶ����������λֵ���õ�1010���൱�ڸ�λ��������õ�101����������һλ�õ�1010��(101&111)<<1��

     �������ظ����������� ��λ��� 010^1010=1000����λֵΪ100=(010&1010)<<1��
     �����ظ�����������1000^100 = 1100����λֵΪ0������ѭ����1100Ϊ���ս����
     * @param num1
     * @param num2
     * @return
     */
    public int Add(int num1,int num2) {
        while (num2!=0) {
            int temp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = temp;
        }
        return num1;
    }

    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    public int Add1(int num1,int num2) {
        BigInteger bi1=new BigInteger(String.valueOf(num1));
        BigInteger bi2=new BigInteger(String.valueOf(num2));
        return bi1.add(bi2).intValue();
    }

//    int add3(int a, int b)
//    {
//        _asm
//        {
//            MOV EAX, a
//            MOV ECX, b
//            ADD EAX, ECX
//        }
//    }
}