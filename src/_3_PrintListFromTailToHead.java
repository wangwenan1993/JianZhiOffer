import bean.Beans;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/8/7.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _3_PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(Beans.SingleNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(listNode != null) {
            result.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(result);
        return result;
    }
}
