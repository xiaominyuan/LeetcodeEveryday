//228. 汇总区间
//给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
//
//示例 1:
//
//输入: [0,1,2,4,5,7]
//输出: ["0->2","4->5","7"]
//解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
//示例 2:
//
//输入: [0,2,3,4,6,8,9]
//输出: ["0","2->4","6","8->9"]
//解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/summary-ranges
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class code228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        for (int i = 0, j= 0; j<nums.length; j++){
            if (j+1 < nums.length && nums[j]+1 == nums[j+1]){
                continue;
            }

            if (i != j){
                result.add(nums[i] + "->" + nums[j]);
            }else {
                result.add(nums[i] + "");
            }

            i=j+1;
        }

        return result;
    }
}
