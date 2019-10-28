//993. 二叉树的堂兄弟节点
//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
//
//如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
//
//我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
//
//只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
//
// 
//
//示例 1：
//
//
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DFS;

import java.util.HashMap;
import java.util.Map;

public class code993 {

    Map<Integer, TreeNode> parentMap;
    Map<Integer, Integer> depthMap;

    public boolean isCousins(TreeNode root, int x, int y) {
        //分别用两个map 记录每个节点的父节点以及深度
        parentMap = new HashMap<>();
        depthMap = new HashMap<>();

        dfs(root, null);

        if (parentMap.get(x) != parentMap.get(y) && depthMap.get(x) == depthMap.get(y)){
            return true;
        }else{
            return false;
        }

    }

    public void dfs(TreeNode node, TreeNode parent){
        if (node != null){
            if (parent == null){
                depthMap.put(node.val, 0);
            }else{
                depthMap.put(node.val, depthMap.get(parent) + 1);
            }

            parentMap.put(node.val, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
