//1043. 分隔数组以得到最大和
//给出整数数组 A，将该数组分隔为长度最多为 K 的几个（连续）子数组。分隔完成后，每个子数组的中的值都会变为该子数组中的最大值。
//
//返回给定数组完成分隔后的最大和。
//
// 
//
//示例：
//
//输入：A = [1,15,7,9,2,5,10], K = 3
//输出：84
//解释：A 变为 [15,15,15,9,10,10,10]
// 
//
//提示：
//
//1 <= K <= A.length <= 500
//0 <= A[i] <= 10^6
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/partition-array-for-maximum-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package DP;

public class code1043 {
    public int maxSumAfterPartitioning(int[] A, int K) {
        //res[i] 代表0-i 的分割数组最大值
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++){
            int domainMax = A[i];
            for (int j = 1; j<=K && i-j+1>=0; j++){
                //不断更新区间的最大值
                domainMax = Math.max(domainMax, A[i-j+1]);
                if (i - j < 0){
                    //如果i正好是第一个分割区间的末尾，说明这个区间的最大值已经找到了，直接更新
                    res[i] = Math.max(res[i], j*domainMax);
                }else{
                    //此时i 不是第一个区间的末尾, 就需要加上前面没有判断最大值的区间（没有在这个内循环判断）
                    res[i] = Math.max(res[i], res[i-j]+j*domainMax);
                }
            }
        }

        return res[A.length-1];
    }
}
