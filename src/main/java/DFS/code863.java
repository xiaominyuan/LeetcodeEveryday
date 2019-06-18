//863. 二叉树中所有距离为 K 的结点
//        给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
//
//        返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
//
//         
//
//        示例 1：
//
//        输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//
//        输出：[7,4,1]
//
//        解释：
//        所求结点为与目标结点（值为 5）距离为 2 的结点，
//        值分别为 7，4，以及 1



package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code863 {
    //先用dfs找到target节点，并保存根节点到target节点中的各个节点到target的距离到map中，随后
    //在此用find(dfs)遍历整个二叉树，若map中存在这个节点，直接取出它到target节点的距离，并判断
    //是否等于K，若等于K，将其添加到result中,与此同时，重置递归函数find中的vals参数。
    //


    Map<Integer, Integer> map = new HashMap<Integer,Integer>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<Integer>();
        dfs(root, target);
        int val = map.get(root.val);
        find(root, K, val, result);
        return result;
    }

    public int dfs(TreeNode root, TreeNode target){
        if (root == null){
            return -1;
        }

        if (root == target){
            map.put(root.val, 0);
            return 0;
        }

        int leftNode = dfs(root.left, target);
        int rightNode = dfs(root.right, target);

        if (leftNode != -1){
            map.put(root.val, leftNode+1);
            return leftNode+1;
        }else if (rightNode != -1){
            map.put(root.val, rightNode+1);
            return rightNode+1;
        }else {
            return -1;
        }

    }

    public void find(TreeNode root, int K, int vals, List<Integer> result){

        if (root == null){
            return;
        }

        if (map.containsKey(root.val)){
            vals = map.get(root.val);
        }

        if (vals == K){
            result.add(root.val);
        }

        find(root.left,K,vals+1,result);
        find(root.right,K,vals+1,result);
    }
}
