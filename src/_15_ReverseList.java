import bean.Beans.*;
/**
 * Created by Administrator on 2018/8/14.
 */
public class _15_ReverseList {
    public SingleNode ReverseList(SingleNode head) {
        SingleNode pre = null;
        while(head != null) {
            SingleNode cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }
}
