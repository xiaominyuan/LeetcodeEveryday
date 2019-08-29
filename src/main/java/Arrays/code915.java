//915. 分割数组
//给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
//
//left 中的每个元素都小于或等于 right 中的每个元素。
//left 和 right 都是非空的。
//left 要尽可能小。
//在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
//
// 
//
//示例 1：
//
//输入：[5,0,3,8,6]
//输出：3
//解释：left = [5,0,3]，right = [8,6]
//示例 2：
//
//输入：[1,1,1,0,6,12]
//输出：4
//解释：left = [1,1,1,0]，right = [6,12]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/partition-array-into-disjoint-intervals
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package Arrays;


//思路：左边数组的最大值 <= 右边数组的最小值
public class code915 {
    public int partitionDisjoint(int[] A) {
        int len = A.length;
        int[] leftMax = new int[len];
        int[] rightMin = new int[len];

        int tmp = A[0];

        for (int i = 0; i<len; i++){
            tmp = Math.max(tmp, A[i]);
            leftMax[i] = tmp;
        }

        tmp = A[len-1];

        for (int i = len-1; i>=0; i--){
            tmp = Math.min(tmp, A[i]);
            rightMin[i] = tmp;
        }

        for (int i = 0; i<len-1; i++){
            if (leftMax[i] <= rightMin[i+1]){
                return i+1;
            }
        }

        return 0;
    }
}
