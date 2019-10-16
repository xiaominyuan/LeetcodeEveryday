//744. 寻找比目标字母大的最小字母
//给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
//
//数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
//
//示例:
//
//输入:
//letters = ["c", "f", "j"]
//target = "a"
//输出: "c"
//
//输入:
//letters = ["c", "f", "j"]
//target = "c"
//输出: "f"
//
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package BinarySearch;

public class code744 {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters[0] > target || letters[letters.length - 1] <= target){
            return letters[0];
        }

        int left = 0;
        int right = letters.length-1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (letters[mid] <= target){
                left = mid +1;
            }else{
                if (letters[mid - 1] <= target){
                    return letters[mid];
                }else{
                    right = mid - 1;
                }
            }
        }

        return ' ';
    }
}
