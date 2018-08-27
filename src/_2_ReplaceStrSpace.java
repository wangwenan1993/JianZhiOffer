/**
 * Created by Administrator on 2018/8/7.
 */
public class _2_ReplaceStrSpace {
    public String replaceSpace(StringBuffer str) {
        StringBuffer str_bk = new StringBuffer();
        for(int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            if (s.equals(" ")) {
                str_bk.append('%');
                str_bk.append('2');
                str_bk.append('0');
            } else {
                str_bk.append(s);
            }
        }
        return str_bk.toString();
//        StringBuilder str_bk = new StringBuilder();
//        for(int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == ' ') {
//                str_bk.append('%');
//                str_bk.append('2');
//                str_bk.append('0');
//            } else {
//                str_bk.append(str.charAt(i));
//            }
//        }
//        return str_bk.toString();
    }

    public static void main(String[] args) {
        _2_ReplaceStrSpace r = new _2_ReplaceStrSpace();
        System.out.println(r.replaceSpace(new StringBuffer("Hello World")));
    }
}
