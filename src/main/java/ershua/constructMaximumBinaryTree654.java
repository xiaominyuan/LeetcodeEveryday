//654. 最大二叉树
//给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
//
//二叉树的根是数组中的最大元素。
//左子树是通过数组中最大值左边部分构造出的最大二叉树。
//右子树是通过数组中最大值右边部分构造出的最大二叉树。
//通过给定的数组构建最大二叉树，并且输出这个树的根节点。
//
// 
//
//示例 ：
//
//输入：[3,2,1,6,0,5]
//输出：返回下面这棵树的根节点：
//
//      6
//    /   \
//   3     5
//    \    /
//     2  0
//       \
//        1
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/maximum-binary-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

import DFS.TreeNode;

public class constructMaximumBinaryTree654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return find(nums, 0, nums.length);
    }

    public TreeNode find(int[] nums, int start, int end){
        if (start >= end){
            return null;
        }

        int maxNum = 0;
        int maxIndex = 0;
        for (int i = start; i < end; i++){
            if (nums[i] > maxNum){
                maxNum = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(maxNum);
        root.left = find(nums, start, maxIndex);
        root.right = find(nums, maxIndex+1, end);
        return root;
    }
}
