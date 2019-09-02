//962. 最大宽度坡
//给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
//
//找出 A 中的坡的最大宽度，如果不存在，返回 0 。
//
// 
//
//示例 1：
//
//输入：[6,0,8,2,1,5]
//输出：4
//解释：
//最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
//示例 2：
//
//输入：[9,8,1,0,1,9,4,0,4,1]
//输出：7
//解释：
//最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/maximum-width-ramp
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package Arrays;

public class code962 {
    public int maxWidthRamp(int[] A) {
        int result = 0;

        for (int i = 0; i<A.length; i++){
            for (int j = A.length - 1; j >= i; j--){
                if (A[j] >= A[i] && j-i >result){
                    result = j-i;
                    break;
                }
            }
        }

        return result;

    }

    public int maxWidthRamp2(int[] A) {

        int i = A.length - 1;

        while (i >= 0){
            int left = 0;
            int right = i;

            while (right < A.length){
                if (A[right] > A[left]){
                    return right = left;
                }else{

                    //等距离滑动区间
                    left++;
                    right++;
                }
            }

            i--;
        }

        return 0;

    }

}
