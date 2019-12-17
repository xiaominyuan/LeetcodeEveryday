//941. 有效的山脉数组
//给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
//
//让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
//
//A.length >= 3
//在 0 < i < A.length - 1 条件下，存在 i 使得：
//A[0] < A[1] < ... A[i-1] < A[i]
//A[i] > A[i+1] > ... > A[B.length - 1]
// 
//
//示例 1：
//
//输入：[2,1]
//输出：false
//示例 2：
//
//输入：[3,5,5]
//输出：false
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/valid-mountain-array
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Arrays;

public class code941 {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3){
            return false;
        }
        int len = A.length;
        int count = 0;
        for (int i = 1; i< len-1; i++){
            if (A[i] > A[i-1] && A[i] > A[i+1]){
                int left = i-1;
                int right = i+1;
                while (left >0 && A[left] > A[left-1]){
                    left--;
                }
                while (right < len-1 && A[right] > A[right+1]){
                    right++;
                }

                count = right-left+1;
                if (count == len){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean validMountainArray2(int[] A) {
        if (A == null || A.length < 3){
            return false;
        }

        int len = A.length;

        int left = 0;
        int right = len-1;

        while (left < len-2 && A[left] <A[left+1]){
            left++;
        }

        while (right > 1 && A[right] < A[right-1]){
            right--;
        }

        return left == right;
    }
}
