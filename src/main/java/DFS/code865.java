package DFS;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class code865 {
    Map<TreeNode, Integer> map;
    int depth;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        map = new HashMap<>();
        depth = -1;
        dfs(root, null);

        //找到最大深度
        for (Integer d : map.values()){
            depth = Math.max(depth, d);
        }

        return findResult(root);
    }


    //用深度优先遍历，将每个节点的深度存在map 中
    public void dfs(TreeNode node, TreeNode parent){
        if (node != null){
            map.put(node, map.get(parent) + 1);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public TreeNode findResult(TreeNode node){
        if (node == null || map.get(node) == depth){
            return node;
        }

        TreeNode left = findResult(node.left);
        TreeNode right = findResult(node.right);

        if (left != null && right != null){
            return node;
        }

        if (left != null){
            return left;
        }

        if (right != null){
            return right;
        }

        return null;
    }
}
