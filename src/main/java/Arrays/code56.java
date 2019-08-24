//56. 合并区间
//给出一个区间的集合，请合并所有重叠的区间。
//
//示例 1:
//
//输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/merge-intervals
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package Arrays;

import java.util.ArrayList;
import java.util.List;

public class code56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1 || intervals == null){
            return intervals;
        }

        //用冒泡排序，以子数组第一个数字排序，从小到大
        for (int i = 0; i<intervals.length-1; i++){
            //优化，如果一次遍历中没有发生交换说明已经有序了，无需再遍历了
            boolean flag = false;
            for (int j = 0; j<intervals.length-i-1; j++){
                if (intervals[j+1][0]<intervals[j][0]){
                    int[] tmp = intervals[j];
                    intervals[j] = intervals[j+1];
                    intervals[j+1] = tmp;
                    flag = true;
                }
            }

            if (!flag){
                break;
            }
        }

        List<int[]> result =new ArrayList<>();

        for (int i = 0; i<intervals.length; i++){
            if (result.size() == 0){
                result.add(intervals[i]);
            }else if (result.get(result.size()-1)[1] < intervals[i][0]){
                result.add(intervals[i]);
            }else{
                int maxNum = Math.max(intervals[i][1], result.get(result.size()-1)[1]);
                result.get(result.size()-1)[1] = maxNum;
                }
        }

        int[][] arr = new int[result.size()][2];

        for (int i = 0; i<result.size(); i++){
            arr[i][0] = result.get(i)[0];
            arr[i][1] = result.get(i)[1];
        }

        return arr;
    }


}
