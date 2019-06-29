//402. 移掉K位数字
//        给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
//
//        注意:
//
//        num 的长度小于 10002 且 ≥ k。
//        num 不会包含任何前导零。
//        示例 1 :
//
//        输入: num = "1432219", k = 3
//        输出: "1219"
//        解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
//        示例 2 :
//
//        输入: num = "10200", k = 1
//        输出: "200"
//        解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
//        示例 3 :
//
//        输入: num = "10", k = 2
//        输出: "0"
//        解释: 从原数字移除所有的数字，剩余为空就是0。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/remove-k-digits
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package greedy;

import java.util.ArrayList;

//使用贪心算法，保证每次删去一个数字的时候是最小的
//若删除一个数字，比较最高位和第二位，如果最高位的数字高于第二位，就删去最高位就变成了了最小值
//如果最高位小于第二位，就把指针往右移动，再次以相同的规则比较，如果第二位小于第三位的数字，就把指针再次往右移

public class code402 {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k){
            return "0";
        }

        char[] arr = num.toCharArray();
        ArrayList<Integer> numList = new ArrayList<>();

        for (char a : arr){
            numList.add(Integer.parseInt(String.valueOf(a)));
        }

        int index = 0;
        int size = numList.size();

        while (k>0){
            while (index < size-1 && numList.get(index) <= numList.get(index+1)){
                index++;
            }

            numList.remove(index);

            if (index > 0){
                index--;
            }

            k--;
            size--;
        }

        while (numList.get(0) == 0){
            numList.remove(0);
            if (numList.size() == 0){
                break;
            }
        }

        String result = "";
        for (int a : numList){
            result = result + a;
        }

        if (result == ""){
            return "0";
        }

        return result;

    }
}
