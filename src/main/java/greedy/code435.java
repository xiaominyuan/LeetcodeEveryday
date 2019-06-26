//435.无重叠区间
//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//
//        注意:
//
//        可以认为区间的终点总是大于它的起点。
//        区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
//        示例 1:
//
//        输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//        输出: 1
//
//        解释: 移除 [1,3] 后，剩下的区间没有重叠。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/non-overlapping-intervals
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
package greedy;

import java.util.Arrays;
import java.util.Comparator;

//将二维数组中的子数组按照最后一个数字升序排序，
//如果第二个子数组的首数字大于第一个子数组的末尾数字，则两个子数组重叠了
//需要移除的最小子数组个数=总子数组个数 - 最多不重叠的子数组个数


public class code435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <=1){
            return 0;
        }

        int result = 1;

        Comparator cmt = new myComparator();

        Arrays.sort(intervals,cmt);

        int minEnd = intervals[0][1];

        //求最多不重叠的子数组个数
        for (int i = 1; i<intervals.length; i++){
            if (intervals[i][0]>=minEnd){
                result++;
                minEnd = intervals[i][1];
            }
        }

        return (intervals.length - result);
    }
}

class myComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] arr1, int[] arr2){
        if (arr1[1]<arr2[1]){
            return -1;
        }else if(arr1[1]>arr2[1]){
            return 1;
        }else{
            return 0;
        }
    }
}
