import bean.Beans.*;

import java.util.ArrayList;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class _4_ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length <= 0) {
            return null;
        }
        ArrayList<Integer> _pre = new ArrayList<Integer>();
        ArrayList<Integer> _in = new ArrayList<Integer>();
        for (int i = 0; i < pre.length; i++) {
            _pre.add(pre[i]);
        }
        for (int i = 0; i < in.length; i++) {
            _in.add(in[i]);
        }
        TreeNode root = new TreeNode(_pre.get(0));
        int root_in_index = _in.indexOf(_pre.get(0));
        root.left = constructSubTree(_pre, 0+1, 0+(root_in_index-0), _in, 0, root_in_index-1);
        root.right = constructSubTree(_pre, 0+(root_in_index-0)+1, _pre.size()-1, _in, root_in_index+1, _in.size()-1);
        return root;
    }

    public TreeNode constructSubTree(ArrayList<Integer> pre, int pre_first, int pre_end, ArrayList<Integer> in, int in_first, int in_end) {
        if (in_first > in_end) return null;
        TreeNode root = new TreeNode(pre.get(pre_first));
        int root_in_index = in.indexOf(pre.get(pre_first));
        root.left = constructSubTree(pre, pre_first + 1, pre_first + (root_in_index-in_first), in, in_first, root_in_index-1);
        root.right = constructSubTree(pre, pre_first + (root_in_index-in_first) + 1, pre_end, in, root_in_index + 1, in_end);
        return root;
    }

    public int binarySearch(int[] arr, int a) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] < a) {
                left = mid + 1;
            } else if (arr[mid] > a) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
