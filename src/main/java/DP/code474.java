//474. 一和零
//现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
//
//你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
//
//注意:
//
//给定 0 和 1 的数量都不会超过 100。
//给定字符串数组的长度不会超过 600。
//示例 1:
//
//输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
//输出: 4
//
//解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/ones-and-zeroes
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DP;

public class code474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0){
            return 0;
        }

        int[][] dp = new int[m+1][n+1];

        for (String s : strs){
            int zero = 0;
            int one = 0;
            for (char c : s.toCharArray()){
                if (c == '0'){
                    zero++;
                }else {
                    one++;
                }
            }

            for (int i = m; i>=zero; i--){
                for (int j = n; i>=one; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i-m][j-n]+1);
                }
            }
        }

        return dp[m][n];
    }
}
