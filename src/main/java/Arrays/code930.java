//930. 和相同的二元子数组

//在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。
//
// 
//
//示例：
//
//输入：A = [1,0,1,0,1], S = 2
//输出：4
//解释：
//如下面黑体所示，有 4 个满足题目要求的子数组：
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Arrays;

import java.util.HashMap;
import java.util.Map;

//有个坑， 必须是连续子数组

public class code930 {
    public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int sum = 0;

        map.put(0,1);

        for (int a : A){
            sum = sum + a;
            res = res + map.getOrDefault(sum - S, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
