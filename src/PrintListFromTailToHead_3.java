import java.util.ArrayList;

/**
 * Created by Administrator on 2018/8/7.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintListFromTailToHead_3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(listNode != null) {
            result.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(result);
        return result;
    }
}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
