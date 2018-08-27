import bean.Beans.*;

/**
 * @Author wangwenan
 * @data 2018/8/15 14:54
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */


public class _25_RandomListNodeClone {
    /**
     * 解题思路：
     * 1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
     * 2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
     * 3、拆分链表，将链表拆分为原链表和复制后的链表
     * @param root
     * @return
     */
    public RandomListNode Clone(RandomListNode root) {
        if (root == null) return null;
        // 复制next链表
        RandomListNode currentNode = root;
        while(currentNode != null) {
            RandomListNode currentNode_clone = new RandomListNode(currentNode.label);
            RandomListNode tmp = currentNode;
            currentNode_clone.next = currentNode.next;
            currentNode = currentNode.next;
            tmp.next = currentNode_clone;
        }

        // 复制Random指针
        currentNode = root;
        while(currentNode != null) {
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        // 拆分整个链表
        currentNode = root;
        RandomListNode root_clone = root.next;
        while(currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = currentNode.next ==  null ? null : cloneNode.next.next;
            currentNode = currentNode.next;
        }
        return root_clone;
    }
}
