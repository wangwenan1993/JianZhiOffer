/**
 * Created by Administrator on 2018/8/19.
 */
public class _50_Duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /**
     * ʹ��boolean���������¼�Ƿ����
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length == 0) return false;
        boolean[] exist = new boolean[length];
        for(int i = 0; i < numbers.length; i++) {
            if(exist[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            }
            exist[numbers[i]] = true;
        }
        return false;
    }

    /**
     * ����Ҫ������������hash table�����棬��Ŀ��д�����������ֵķ�Χ��֤��0 ~ n-1 ֮�䣬���Կ������������������ñ�־��
     * ��һ�����ֱ����ʹ��󣬿������ö�Ӧλ�ϵ��� + n��֮����������ͬ����ʱ��
     * �ᷢ�ֶ�Ӧλ�ϵ����Ѿ����ڵ���n�ˣ���ôֱ�ӷ�����������ɡ�
     */
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length == 0) return false;
        for(int i = 0; i < numbers.length; i++) {
            int index = numbers[i];
            if(index >= length) {
                index -= length;
            }
            if(numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            numbers[index] += length;
        }
        return false;
    }
}
