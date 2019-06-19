//971. 翻转二叉树以匹配先序遍历
//        给定一个有 N 个节点的二叉树，每个节点都有一个不同于其他节点且处于 {1, ..., N} 中的值。
//
//        通过交换节点的左子节点和右子节点，可以翻转该二叉树中的节点。
//
//        考虑从根节点开始的先序遍历报告的 N 值序列。将这一 N 值序列称为树的行程。
//
//        （回想一下，节点的先序遍历意味着我们报告当前节点的值，然后先序遍历左子节点，再先序遍历右子节点。）
//
//        我们的目标是翻转最少的树中节点，以便树的行程与给定的行程 voyage 相匹配。 
//
//        如果可以，则返回翻转的所有节点的值的列表。你可以按任何顺序返回答案。
//
//        如果不能，则返回列表 [-1]。
//
//         
//        示例 1：
//        输入：root = [1,2], voyage = [2,1]
//        输出：[-1]
//
//        示例 2：
//        输入：root = [1,2,3], voyage = [1,3,2]
//        输出：[1]
//
//        示例 3：
//        输入：root = [1,2,3], voyage = [1,2,3]
//        输出：[]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/flip-binary-tree-to-match-preorder-traversal
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//进行深度优先遍历。如果遍历到某一个节点的时候，节点值不能与行程序列匹配，那么答案一定是 [-1]
//。否则，当行程序列中的下一个期望数字 voyage[i] 与我们即将遍历的子节点的值不同的时候，
//        我们就要翻转一下当前这个节点。



package DFS;

import java.util.ArrayList;
import java.util.List;

public class code971 {
    public List<Integer> result;
    public int[] voyage;
    public int index;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        result = new ArrayList();
        index = 0;
        this.voyage = voyage;
        // dfs(root,index,voyage);
        dfs(root);
        if (!result.isEmpty() && result.get(0) == -1){
            result.clear();
            result.add(-1);
            // return new ArrayList<Integer>(result.get(0));
        }

        return result;
    }

    public void dfs(TreeNode root){
        if (root != null){
            if (root.val != voyage[index]){
                result.clear();
                result.add(-1);
                return;
            }
            index = index+1;
            if (index < voyage.length &&root.left != null && root.left.val != voyage[index]){
                result.add(root.val);
                dfs(root.right);
                dfs(root.left);
            }else{
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
}
