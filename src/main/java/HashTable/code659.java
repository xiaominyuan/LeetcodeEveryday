//659. 分割数组为连续子序列
//输入一个按升序排序的整数数组（可能包含重复数字），你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。返回你是否能做出这样的分割？
//
// 
//
//示例 1：
//
//输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 :
//1, 2, 3
//3, 4, 5
// 
//
//示例 2：
//
//输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 :
//1, 2, 3, 4, 5
//3, 4, 5
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



//哈希表 counter 用于存储元素出现的次数，counter[n] 代表 n 出现的次数
//哈希表 end 用于存储以元素结尾的连续子序列（指至少包含三个连续整数的子序列）个数，end[n] 代表以 n 结尾的连续子序列的个数


package HashTable;

import java.util.HashMap;
import java.util.Map;

public class code659 {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();

        for (int num : nums){
            counter.put(num, counter.getOrDefault(num, 0)+1);
        }

        for (int num : nums){
            if (counter.getOrDefault(num, 0) == 0){
                continue;
            }

            counter.put(num, counter.get(num) - 1);

            if (end.getOrDefault(num - 1, 0) > 0){
                end.put(num-1, end.getOrDefault(num-1, 0)-1);
                end.put(num, end.getOrDefault(num, 0)+1);
            }else if (counter.getOrDefault(num + 1, 0)> 0 && counter.getOrDefault(num+2, 0)>0){
                counter.put(num + 1, counter.get(num+1)-1);
                counter.put(num + 2, counter.get(num+2)-1);
                end.put(num+2, end.getOrDefault(num+2, 0)+1);
            }else {
                return false;
            }
        }

        return true;
    }
}
