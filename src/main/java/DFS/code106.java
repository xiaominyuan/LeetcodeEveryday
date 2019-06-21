//106. 从中序与后序遍历序列构造二叉树
//根据一棵树的中序遍历与后序遍历构造二叉树。
//        中序遍历 inorder = [9,3,15,20,7]
//        后序遍历 postorder = [9,15,7,20,3]
//        返回如下的二叉树：
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
package DFS;

import java.util.Arrays;

public class code106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;

        if (inLen == 0){
            return null;
        }

        if (inLen == 1){
            return new TreeNode(inorder[0]);
        }

        TreeNode root = new TreeNode(postorder[postLen-1]);

        int divideInt = 0;
        //找到分割点
        for (int i = 0; i<inLen; i++){
            if (inorder[i] == postorder[postLen-1]){
                divideInt = i;
                break;
            }
        }

        //中序遍历数组和后序遍历数组的左右子树都聚集在同一区域，只是根节点在数组的不同位置
        //如中序遍历是【4,9,1,3,8,15,6,20,7】
        //后序遍历是【4,1,9,8,6,15,7,20,3】
        //根节点是3，而且后序遍历数组的最后一个节点必然是根节点，其左右子数组的最后一个数字必然是各自子树的根节点
        root.left = buildTree(Arrays.copyOfRange(inorder,0,divideInt), Arrays.copyOfRange(postorder,0,divideInt));
        root.right = buildTree(Arrays.copyOfRange(inorder,divideInt+1,inLen), Arrays.copyOfRange(postorder,divideInt,postLen-1));
        return root;
    }
}
