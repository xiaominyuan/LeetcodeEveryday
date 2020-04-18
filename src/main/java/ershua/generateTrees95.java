//95. 不同的二叉搜索树 II
//给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
//
//示例:
//
//输入: 3
//输出:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释:
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package ershua;

import DFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class generateTrees95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new ArrayList<>();
        }

        return help(1, n);
    }

    public List<TreeNode> help(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if (start > end){
            res.add(null);
            return res;
        }

        if (start == end){
            TreeNode node = new TreeNode(start);
            res.add(node);
            return res;
        }

        for (int i = start; i<= end; i++){
            List<TreeNode> lefts = help(start, i-1);
            List<TreeNode> rights = help(i+1, end);
            for (TreeNode left : lefts){
                for (TreeNode right : rights){
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = left;
                    tmp.right = right;
                    res.add(tmp);
                }
            }
        }

        return res;
    }
}
