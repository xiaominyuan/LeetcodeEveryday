//718. 最长重复子数组
//        给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//
//        示例 1:
//
//        输入:
//        A: [1,2,3,2,1]
//        B: [3,2,1,4,7]
//        输出: 3
//        解释:
//        长度最长的公共子数组是 [3, 2, 1]。
//        说明:
//
//        1 <= len(A), len(B) <= 1000
//        0 <= A[i], B[i] < 100
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//状态转移方程为
//dp[i+1][j+1] = A[i+1] == B[j+1] ? dp[i][j]+1 : 0
//dp[i][j] 表示已字符A[i], B[j]为结尾的相同子串的最大长度

package DP;

public class code718 {
    public int findLength(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;

        if (lenA == 0 || lenB == 0){
            return 0;
        }

        int[][] dp = new int[lenA+1][lenB+1];

        int result = 0;

        for (int i = 0; i<lenA; i++){
            for (int j = 0; j<lenB; j++){
                if (A[i] != B[j]){
                    dp[i][j] = 0;
                }else{
                    dp[i+1][j+1] = dp[i][j] + 1;
                    result = Math.max(result, dp[i+1][j+1]);
                }
            }
        }

        return result;
    }
}
