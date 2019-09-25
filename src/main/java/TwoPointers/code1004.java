//1004. 最大连续1的个数 III
//给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
//
//返回仅包含 1 的最长（连续）子数组的长度。
//
// 
//
//示例 1：
//
//输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释：
//[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。
//示例 2：
//
//输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：
//[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package TwoPointers;

public class code1004 {

    //模板，但是超时了
    public int longestOnes(int[] A, int K) {
        int result = 0;
        int count = 0;

        for (int left = 0, right = 0; right < A.length; right++){
            if (A[right] == 1){
                count++;
            }

            while (right - left + 1 - count >K){
                if (A[left] == 1){
                    left++;
                    count--;
                }
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public int longestOnes2(int[] A, int K) {
        int count = 0;
        int left = 0;
        int right = 0;
        int max = 0;

        for (int i = 0; i<A.length; i++){
            if (A[left] == 0){
                count++;
            }

            while (count > K){
                if (A[left] == 0){
                    count--;
                }
                left++;
            }

            max = Math.max(max, i - left + 1);
        }

        return Math.max(max, right - left +1);
    }
}
