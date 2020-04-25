//面试题07. 重建二叉树
//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
// 
//
//例如，给出
//
//前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//返回如下的二叉树：
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package backTracking;

import DFS.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class buildTree07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0){
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }

        return help(preorder, 0, preorder.length-1, inorder, 0, inorder.length -1,map);
    }

    public TreeNode help(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map){
        if (preStart > preEnd){
            return null;
        }else{
            TreeNode root = new TreeNode(preorder[preStart]);
            if (preStart == preEnd){
                return root;
            }else{
                int mid = map.get(preorder[preStart]);
                int left = mid - inStart; // 左子树的长度
                int right = inEnd - mid; // 右子树的长度

                TreeNode leftSubtree = help(preorder, preStart+1, preStart+left, inorder, inStart, mid-1, map);
                TreeNode rightSubtree = help(preorder, preEnd- right+1, preEnd, inorder, mid+1, inEnd, map);
                root.left = leftSubtree;
                root.right = rightSubtree;
                return root;
            }
        }
    }
}
