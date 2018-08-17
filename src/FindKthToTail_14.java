/**
 * Created by Administrator on 2018/8/12.
 */
public class FindKthToTail_14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        head = reverseList(head);
        ListNode tmp = head;
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

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }

    public static ListNode FindKthToTail1(ListNode head, int k) {
        ListNode p, q;
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

    public static ListNode FindKthToTail2(ListNode head, int k) {
        ListNode tmp = head;
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
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        FindKthToTail_14 find = new FindKthToTail_14();
//        head = reverseList(head);
//        ListNode temp = head;
//        while(temp != null) {
//            System.out.println(temp.val);
//            temp = temp.next;
//        }
        ListNode node = find.FindKthToTail(head, 1);
        System.out.println(node.val);
    }
}
