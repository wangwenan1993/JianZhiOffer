import java.util.*;

/**
 * Created by Administrator on 2018/8/15.
 */
public class PermutationChar_27 {

    /**
     * 1���ݹ��㷨
     * <p>
     * ������http://www.cnblogs.com/cxjchen/p/3932949.html? (��л�������ߣ�)
     * <p>
     * �������ظ�ֵ�����
     * <p>
     * �̶���һ���ַ����ݹ�ȡ����λ����ĸ����ַ�����ϣ�
     * �ٰѵ�һ���ַ������ÿһ���ַ���������ͬ���ݹ�����λ������ַ�����ϣ� *�ݹ�ĳ��ڣ�����ֻʣһ���ַ���ʱ�򣬵ݹ��ѭ�����̣����Ǵ�ÿ���Ӵ��ĵڶ����ַ���ʼ�������һ���ַ�������Ȼ����������Ӵ���
     * <p>
     * �������ظ�ֵ�أ�
     * *����ȫ���о��Ǵӵ�һ��������ÿ�����ֱ�������������ֽ����������ȳ��ԼӸ��������жϡ������һ����������������ͬ��ô���������Ͳ������ˡ�
     * ����abb����һ���������������������bab��bba��Ȼ��abb�еڶ������͵���������ͬ���Ͳ��ý����ˡ�
     * ���Ƕ�bab���ڶ������͵��������� ͬ������Ҫ�������õ�bba��
     * ���������bba�Ϳ�ʼ��һ������������������Ľ����ͬ�ˣ��������������С�
     * <p>
     * ����˼ά����abb����һ����a��ڶ�����b�����õ�bab��Ȼ���ǵ�һ���������������������ʱ���ڵ����������ڵڶ�������
     * ���Ե�һ�����Ͳ�������������������ˡ��ٿ���bab�����ĵڶ���������������������Խ��bba����ʱȫ����������ϣ�
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {

        ArrayList<String> list = new ArrayList<String>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, list);
            Collections.sort(list);
        }
        return list;
    }

    private void PermutationHelper(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) {
            list.add(String.valueOf(chars));
        } else {
            Set<Character> charSet = new HashSet<Character>();
            for (int j = i; j < chars.length; ++j) {
                if (j == i || !charSet.contains(chars[j])) {
                    charSet.add(chars[j]);
                    swap(chars, i, j);
                    PermutationHelper(chars, i + 1, list);
                    swap(chars, j, i);
                }
            }
        }
    }

    private void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    /**
     * 2���ֵ��������㷨
     * <p>
     * �ɲο������� http://www.cnblogs.com/pmars/archive/2013/12/04/3458289.html? ����л���ߣ�
     * <p>
     * һ��ȫ���пɿ���һ���ַ������ַ�������ǰ׺����׺��
     * ���ɸ���ȫ���е���һ������.��νһ������һ��������һ������һ��֮��û�������ġ�
     * ���Ҫ����һ������һ���о����ܳ��Ĺ�ͬǰ׺��Ҳ���仯�����ھ����̵ܶĺ�׺�ϡ�
     * <p>
     * [��]839647521��1--9�����С�1��9��������ǰ�����123456789��������987654321��
     * ��������ɨ�����������ģ��͵���987654321��Ҳ��û����һ���ˡ������ҳ���һ�γ����½���λ�á�
     * <p>
     * ������ ��εõ�346987521����һ��
     * 1����β����ǰ�ҵ�һ��P(i-1) < P(i)��λ��
     * 3 4 6 <- 9 <- 8 <- 7 <- 5 <- 2 <- 1
     * �����ҵ�6�ǵ�һ����С�����֣���¼��6��λ��i-1
     * <p>
     * 2����iλ�������ҵ����һ������6����
     * 3 4 6 -> 9 -> 8 -> 7 5 2 1
     * �����ҵ�7��λ�ã���¼λ��Ϊm
     * <p>
     * 3������λ��i-1��m��ֵ
     * 3 4 7 9 8 6 5 2 1
     * 4������iλ�ú����������
     * 3 4 7 1 2 5 6 8 9
     * ��347125689Ϊ346987521����һ������
     *
     * @param str
     * @return
     */
    public ArrayList<String> Permutation2(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return list;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        list.add(String.valueOf(chars));
        int len = chars.length;
        while (true) {
            int lIndex = len - 1;
            int rIndex;
            while (lIndex >= 1 && chars[lIndex - 1] >= chars[lIndex]) {
                lIndex--;
            }
            if (lIndex == 0)
                break;
            rIndex = lIndex;
            while (rIndex < len && chars[rIndex] > chars[lIndex - 1]) {
                rIndex++;
            }
            swap(chars, lIndex - 1, rIndex - 1);
            reverse(chars, lIndex);

            list.add(String.valueOf(chars));
        }

        return list;
    }

    private void reverse(char[] chars, int k) {
        if (chars == null || chars.length <= k)
            return;
        int len = chars.length;
        for (int i = 0; i < (len - k) / 2; i++) {
            int m = k + i;
            int n = len - 1 - i;
            if (m <= n) {
                swap(chars, m, n);
            }
        }

    }
}
