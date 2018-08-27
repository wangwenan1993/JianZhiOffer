/**
 * Created by Administrator on 2018/8/14.
 */
public class _16_MergeTwoList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode p, q;
        p = list1;
        q = list2;
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while(p != null && q != null) {
            if(p.val < q.val) {
                tmp.next = p;
                p = p.next;
            } else {
                tmp.next = q;
                q = q.next;
            }
            tmp = tmp.next;
        }
        while(p != null) {
            tmp.next = p;
            break;
        }
        while(q != null) {
            tmp.next  = q;
            break;
        }
        return head.next;
    }
}
