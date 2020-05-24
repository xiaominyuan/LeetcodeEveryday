//面试题 04.02. 最小高度树
//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
//
//示例:
//给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//          0
//         / \
//       -3   9
//       /   /
//     -10  5
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package dictionary;

import DFS.TreeNode;

import java.util.Arrays;

public class sortedArrayToBST02 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(nums[nums.length/2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length/2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length/2+1, nums.length));
        return root;
    }
}
