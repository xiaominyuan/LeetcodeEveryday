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
            for (int j = 0; j<intervals.length-i-1; j++){
                if (intervals[i][0]>intervals[i][0]){
                    int[] tmp = intervals[j];
                    intervals[j] = intervals[i];
                    intervals[i] = tmp;
                }
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
