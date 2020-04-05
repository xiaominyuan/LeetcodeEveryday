//450. 删除二叉搜索树中的节点
//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
//
//一般来说，删除节点可分为两个步骤：
//
//首先找到需要删除的节点；
//如果找到了，删除它。
//说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
//
//示例:
//
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DFS;

// 思路： 中序遍历为升序

public class deleteNode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }

        if (root.val > key){
            //目标值在左子树
            root.left = deleteNode(root.left, key);
            return root;

        }else if (root.val < key){
            //目标值在右子树
            root.right = deleteNode(root.right, key);
            return root;
        }else {
            //目标值为root
            if (root.left == null){
                TreeNode right = root.right;
                root.right = null;
                return right;
            }

            if (root.right == null){
                TreeNode left = root.left;
                root.left = null;
                return left;
            }
            TreeNode rightMin = minNode(root.right);
            rightMin.right = deleteMin(root.right);
            rightMin.left = root.left;
            root.left = null;
            root.right = null;
            return rightMin;
        }
    }

    //找到最小节点
    public TreeNode minNode(TreeNode node){
        if (node.left == null){
            return node;
        }

        return minNode(node.left);
    }

    //移除子树中的最小节点
    public TreeNode deleteMin(TreeNode node){
        if (node.left == null){
            TreeNode right = node.right;
            node.right = null;
            return right;
        }
        node.left = deleteMin(node.left);
        return node;
    }
}
