import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author wangwenan
 * @data 2018/8/17 10:55
 */
public class _32_PrintMinNumberCombineWithIntArray {
    public String PrintMinNumber(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        if(numbers.length == 0) return sb.toString();

        int len = numbers.length;
        String[] str = new String[len];
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        for(int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();

    }
}
