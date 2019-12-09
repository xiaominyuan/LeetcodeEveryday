//436. 寻找右区间
//给定一组区间，对于每一个区间 i，检查是否存在一个区间 j，它的起始点大于或等于区间 i 的终点，这可以称为 j 在 i 的“右侧”。
//
//对于任何区间，你需要存储的满足条件的区间 j 的最小索引，这意味着区间 j 有最小的起始点可以使其成为“右侧”区间。如果区间 j 不存在，则将区间 i 存储为 -1。最后，你需要输出一个值为存储的区间值的数组。
//
//注意:
//
//你可以假设区间的终点总是大于它的起始点。
//你可以假定这些区间都不具有相同的起始点。
//示例 1:
//
//输入: [ [1,2] ]
//输出: [-1]
//
//解释:集合中只有一个区间，所以输出-1。
//示例 2:
//
//输入: [ [3,4], [2,3], [1,2] ]
//输出: [-1, 0, 1]
//
//解释:对于[3,4]，没有满足条件的“右侧”区间。
//对于[2,3]，区间[3,4]具有最小的“右”起点;
//对于[1,2]，区间[2,3]具有最小的“右”起点。
//示例 3:
//
//输入: [ [1,4], [2,3], [3,4] ]
//输出: [-1, 2, -1]
//
//解释:对于区间[1,4]和[3,4]，没有满足条件的“右侧”区间。
//对于[2,3]，区间[3,4]有最小的“右”起点。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/find-right-interval
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//https://leetcode-cn.com/problems/find-right-interval/solution/er-fen-cha-zhao-hong-hei-shu-by-liweiwei1419/

package BinarySearch;

import java.util.HashMap;
import java.util.Map;

public class code436 {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        if (len == 0){
            return new int[0];
        }

        int[] arr = new int[len];
        int[] res = new int[len];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++){
            //储蓄每个小数组的索引
            map.put(intervals[i][0], i);
            //把每个小数组的第一个数拿出来， 然后用来排序，用来二分查找大于等于target 的最小数
            arr[i] = intervals[i][0];
        }

        for (int i = 0; i <len-1; i++){
            boolean flag = false;
            for (int j = 0; j< len-1-i; j++){
                if (arr[j+1] < arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                }
            }

            if (!flag){
                break;
            }
        }

        for (int i = 0; i< len; i++){
            int index = search(arr, intervals[i][1]);
            if (index == -1){
                res[i] = -1;
            }else{
                //大于等于 target 的最小的小数组的第一位数
                int num = arr[index];
                //获取这个数字的索引， 就是小数组在大数组的索引
                int inx = map.get(num);
                res[i] = inx;
            }
        }

        return res;
    }

    public int search(int[] arr, int target){
        int len = arr.length;
        if(arr[len-1] < target){
            return -1;
        }

        int left = 0;
        int right = len-1;

        while (left < right){
            int mid = (left + right)/2;
            if (arr[mid] < target){
                left = mid +1;
            }else{
                right = mid;
            }
        }

        return left;
    }
}
