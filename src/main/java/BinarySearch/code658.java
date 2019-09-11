//658. 找到 K 个最接近的元素
//给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
//
//示例 1:
//
//输入: [1,2,3,4,5], k=4, x=3
//输出: [1,2,3,4]
// 
//
//示例 2:
//
//输入: [1,2,3,4,5], k=4, x=-1
//输出: [1,2,3,4]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/find-k-closest-elements
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


package BinarySearch;

import java.util.ArrayList;
import java.util.List;

//思路： 双指针，由于数组是连续的，所以距离最接近的几个数一定是连续的
//      所以用两个指针分别从前后端进行比较

public class code658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        int left = 0;
        int right = len -1;

        int removes = len - k;

        while (removes > 0){
            if (x - arr[left] <= arr[right] - x){
                right--;
            }else {
                left++;
            }
            removes--;
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i< left + k; i++){
            result.add(i);
        }

        return result;
    }
}
