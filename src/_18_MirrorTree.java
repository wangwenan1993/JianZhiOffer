import java.util.Stack;

/**
 * @Author wangwenan
 * @data 2018/8/15 8:55
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */

public class _18_MirrorTree {
    //递归实现
    public TreeNode Mirror(TreeNode head) {
        TreeNode tmp = head;
        mirror(tmp);
        return head;
    }

    public static void mirror(TreeNode head) {
        if (head == null) return;
        TreeNode tmp = head.left;
        head.left = head.right;
        head.right = tmp;
        mirror(head.right);
        mirror(head.left);
    }

    // 非递归实现
    public void Mirror1(TreeNode pRoot) {
        //非递归实现
        if(pRoot==null)
            return;
        Stack<TreeNode> stackNode = new Stack<>();
        stackNode.push(pRoot);
        while(!stackNode.empty()){
            TreeNode tree = stackNode.peek();
            stackNode.pop();
            if(tree.left != null || tree.right != null){
                TreeNode ptemp=tree.left;
                tree.left=tree.right;
                tree.right=ptemp;
            }
            if(tree.left != null)
                stackNode.push(tree.left);
            if(tree.right != null)
                stackNode.push(tree.right);
        }
    }
}
