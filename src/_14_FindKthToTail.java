import bean.Beans.*;

/**
 * Created by Administrator on 2018/8/12.
 */
public class _14_FindKthToTail {
    public SingleNode FindKthToTail(SingleNode head, int k) {
        head = reverseList(head);
        SingleNode tmp = head;
        if (k == 0) {
            return null;
        }
        int i = 1;
        while(tmp != null && i < k) {
            tmp = tmp.next;
            i++;
        }
        reverseList(head);
        return tmp;
    }

    public static SingleNode reverseList(SingleNode head) {
        SingleNode pre = null;
        while(head != null) {
            SingleNode cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }

    public static SingleNode FindKthToTail1(SingleNode head, int k) {
        SingleNode p, q;
        p = q = head;
        int i = 0;
        while(p != null) {
            i++;
            p = p.next;
            if(i >= k) {
                q = q.next;
            }
        }

        return i < k ? null : q;
    }

    public static SingleNode FindKthToTail2(SingleNode head, int k) {
        SingleNode tmp = head;
        int count = 0;
        while(tmp != null) {
            count++;
            tmp =  tmp.next;
        }

        if (count < k) return null;
        for(int i = 0; i > count - k; i++) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        SingleNode head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(4);
        head.next.next.next.next = new SingleNode(5);
        _14_FindKthToTail find = new _14_FindKthToTail();
//        head = reverseList(head);
//        SingleNode temp = head;
//        while(temp != null) {
//            System.out.println(temp.val);
//            temp = temp.next;
//        }
        SingleNode node = find.FindKthToTail(head, 1);
        System.out.println(node.val);
    }
}
