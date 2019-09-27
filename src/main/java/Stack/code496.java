//496. 下一个更大元素 I
//给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
//
//nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
//
//示例 1:
//
//输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
//    对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
//    对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
//示例 2:
//
//输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于num1中的数字2，第二个数组中的下一个较大数字是3。
//    对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/next-greater-element-i
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//思路： 维护一个栈，遍历nums2 ，
//   将nums2 中的第一个值放入栈中， 然后遍历到第二个值， 此时这个值
//   比栈顶大， 就把栈顶弹出来和当前遍历到的值放入map 中， 然后依然把这个遍历的值放入栈中
//    以此类推， 那么这个map 中就是nums2 中的值和之后比它大的第一个数的键值对
//    然后遍历nums1 ， 从map 中取到的值就可以放到结果数组中了

public class code496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        int[] result = new int[nums1.length];

        for (int num : nums2){
            while (!stack.isEmpty() && stack.peek() < num){
                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        for (int i = 0; i<nums2.length; i++){
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}
