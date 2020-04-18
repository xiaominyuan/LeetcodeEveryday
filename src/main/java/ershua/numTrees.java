//96. 不同的二叉搜索树
package ershua;

public class numTrees {
    public int numTrees(int n) {
        //dp[n] 代表n个数构建的bst 个数
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i<=n; i++){

            //j 为左子树的节点个数
            for (int  j = 0; j <=n; j++){
                //种数等于左子树的种数乘以右子树的种树
                dp[i] += dp[j]*dp[i-j-1];
            }
        }

        return dp[n];
    }
}
