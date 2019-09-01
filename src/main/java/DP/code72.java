//72. 编辑距离
//给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
//
//你可以对一个单词进行如下三种操作：
//
//插入一个字符
//删除一个字符
//替换一个字符
//示例 1:
//
//输入: word1 = "horse", word2 = "ros"
//输出: 3
//解释:
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/edit-distance
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DP;


//思路：动态规划

//状态方程： dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) , 此时 str1[i] != str[j]
//           dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1] - 1), 此时str1[i] == str[j]

public class code72 {
    public int minDistance(String word1, String word2) {
        int w1 = word1.length();
        int w2 = word2.length();

        if (w1 == 0 || w2 == 0){
            return w1 + w2;
        }

        int[][] dp = new int[w1+1][w2+1];

        for (int i = 0; i<w1+1; i++){
            dp[i][0] = i;
        }

        for (int i = 0; i < w2 + 1; i++){
            dp[0][i] = i;
        }

        for (int i = 1; i<w1+1; i++){
            for (int j = 1; j< w2 + 1; j++){
                int left = dp[i-1][j];
                int down = dp[i][j-1];
                int leftDown = dp[i-1][j-1];

                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i-1][j-1] = 1+ Math.min(left, Math.min(down, leftDown-1));
                }else {
                    dp[i-1][j-1] = 1+ Math.min(left, Math.min(down, leftDown));
                }
            }
        }

        return dp[w1][w2];
    }
}
