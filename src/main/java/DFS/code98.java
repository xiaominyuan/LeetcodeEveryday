package DFS;//下面假如我们在访问的过程就把节点入栈，直到左子节点为null，
//        说明我们已经找到了可以输出的数据起点，
//        这个时候刚好我是把这个数据起点保存在了栈数据结构最后一个，
//        那么这个时候我们入栈的次顺依次是ABD。
//        那么我们出栈就等于是开始输出中序遍历的第一个数据，
//        我们开始出栈D,由于是中序遍历那么我们接着出栈B,这个时候不能出栈了，
//        因为我们需要输出B节点的右子全部节点。因此我们又开始入栈F,然后是E.
//        ---------------------
//        作者：牛掰是怎么形成的
//        来源：CSDN
//        原文：https://blog.csdn.net/qq_33060405/article/details/78505347
//        版权声明：本文为博主原创文章，转载请附上博文链接！


//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
//        假设一个二叉搜索树具有如下特征：
//
//        节点的左子树只包含小于当前节点的数。
//        节点的右子树只包含大于当前节点的数。
//        所有左子树和右子树自身必须也是二叉搜索树。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/validate-binary-search-tree
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


import java.util.Stack;

public class code98 {
    public boolean isValidBST(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;
        while (p != null || !stack.empty()){
            while (p != null){
                stack.push(p);
                p=p.left;
            }
            p = stack.pop();
            if (pre != null && p.val <= pre.val){
                return false;
            }
            pre = p;
            p = p.right;
        }
        return true;
    }
}
