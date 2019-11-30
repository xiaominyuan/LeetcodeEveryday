//和为S的两个数字
//输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
// 如果有多对数字的和等于S，输出两个数的乘积最小的。

package jianzhioffer;

import java.util.ArrayList;

public class code35 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length == 0){
            return res;
        }

        int low = 0;
        int high = array.length - 1;
        while (low < high){
            int small = array[low];
            int big = array[high];
            int total = small + big;
            if (total == sum){
                res.add(small);
                res.add(big);
                return res;
            }else if (total < sum){
                low++;
            }else{
                high--;
            }
        }

        return res;
    }
}
