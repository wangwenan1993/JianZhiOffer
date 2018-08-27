import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author wangwenan
 * @data 2018/8/15 10:58
 */
public class _22_BFSPrintFromTopToBottom {
    // 队列
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if(root == null) return res;
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        return res;
    }

}
