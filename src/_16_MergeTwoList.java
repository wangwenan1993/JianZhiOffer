import bean.Beans.*;
/**
 * Created by Administrator on 2018/8/14.
 */
public class _16_MergeTwoList {
    public SingleNode Merge(SingleNode list1,SingleNode list2) {
        SingleNode p, q;
        p = list1;
        q = list2;
        SingleNode head = new SingleNode(0);
        SingleNode tmp = head;
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
