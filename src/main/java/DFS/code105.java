//105. 从前序与中序遍历序列构造二叉树
//根据一棵树的前序遍历与中序遍历构造二叉树。
//
//        注意:
//        你可以假设树中没有重复的元素。
//
//        例如，给出
//
//        前序遍历 preorder = [3,9,20,15,7]
//        中序遍历 inorder = [9,3,15,20,7]
//        返回如下的二叉树：
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package DFS;

import java.util.HashMap;
import java.util.Map;

public class code105 {
    public int pre_index = 0;
    public int[] preorder;
    public int[] inorder;
    public Map<Integer,Integer> map = new HashMap<Integer,Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int idx = 0;
        for (int val : inorder){
            map.put(val, idx++);
        }
        int high = inorder.length;
        return find(0,high);
    }

    public TreeNode find(int low, int high){
        if (low == high){
            return null;
        }

        int root_val = preorder[pre_index];
        TreeNode root = new TreeNode(root_val);

        pre_index = pre_index+1;

        int index = map.get(root_val);

        //中序遍历数组中，某个数字前面都为左子树，后边都是右子树
        root.left = find(low, index);
        root.right = find(index+1, high);
        return root;
    }
}
