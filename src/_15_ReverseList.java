/**
 * Created by Administrator on 2018/8/14.
 */
public class _15_ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        while(head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }
}
