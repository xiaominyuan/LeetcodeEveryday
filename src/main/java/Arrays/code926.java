//926. 将字符串翻转到单调递增
//如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
//
//我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
//
//返回使 S 单调递增的最小翻转次数。
//
// 
//
//示例 1：
//
//输入："00110"
//输出：1
//解释：我们翻转最后一位得到 00111.
//示例 2：
//
//输入："010110"
//输出：2
//解释：我们翻转得到 011111，或者是 000111。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/flip-string-to-monotone-increasing
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。




//思路： 从前往后遍历，记录累计把0翻转成1的次数
//       从后往前遍历， 记录累计把1转换成0的次数，最后遍历一次字符串，找出前面两次遍历的最小之和
package Arrays;

public class code926 {
    public int minFlipsMonoIncr(String S) {
        int len = S.length();
        int[] forward = new int[len];
        int[] backward = new int[len];
        int left = 0;
        int right = 0;

        for (int i=0,j=len-1; i<len&&j>=0; i++,j--){
            if (S.charAt(i) == '1'){
                left++;
            }
            if (S.charAt(j) == '0'){
                right++;
            }
            forward[i] = left;
            backward[j] = right;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i<len-1; i++){
            int tmpSum = forward[i] + backward[i+1];
            if (result>tmpSum){
                result = tmpSum;
            }
        }

        result = Math.min(Math.min(result,forward[len-1]), backward[0]);

        return result;
    }
}
