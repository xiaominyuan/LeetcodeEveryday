package backTracking;

import DFS.TreeNode;

import java.util.*;

public class distanceK863 {

    private Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    private Set<TreeNode> flag = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        findParent(root, null);
        List<Integer> res = new ArrayList<>();
        dfs(target, res, K);
        return res;
    }

    public void findParent(TreeNode root, TreeNode parentNode){
        if (root == null){
            return;
        }

        parentMap.put(root, parentNode);
        findParent(root.left, parentNode);
        findParent(root.right, parentNode);
    }

    public void dfs(TreeNode root, List<Integer> res, int distance){
        if (root != null && !flag.contains(root)){
            if (distance <= 0){
                res.add(root.val);
                return;
            }

            flag.add(root);
            dfs(root.left, res, distance-1);
            dfs(root.right, res, distance-1);
            dfs(parentMap.get(root), res, distance-1);
        }
    }


}
