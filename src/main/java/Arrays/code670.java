//670. 最大交换
//能得到的最大值。
//
//示例 1 :
//
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
//示例 2 :
//
//输入: 9973
//输出: 9973
//解释: 不需要交换。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/maximum-swap
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package Arrays;


//思路：由于只能交换一次，所以从高位遍历，交换当前数字的后面中的最大值，为了找到这个最大值，
//      需要倒序遍历，找出每个数字后面最大值得索引。
public class code670 {
    public int maximumSwap(int num) {
        char[] c = String.valueOf(num).toCharArray();

        //倒序遍历c这个数组，用nums这个数组存储后面最大值的索引
        int[] nums = new int[c.length];
        int index = c.length-1;
        int max = 0;

        for (int i = c.length-1; i>=0; i--){
            int tmp = Integer.parseInt(String.valueOf(c[i]));

            if (tmp > max){
                max = tmp;
                index = i;
            }

            nums[i] = index;
        }

        for (int i = 0; i<c.length; i++){
            //后面比当前数最大的数
            int maxLater = Integer.parseInt(String.valueOf(c[nums[i]]));

            int nowNum = Integer.parseInt(String.valueOf(c[i]));

            if (nums[i] != i && nowNum>maxLater) {
                char tmp = c[nums[i]];
                c[nums[i]] = c[i];
                c[i] = tmp;

                //只能交换一次
                break;
            }
        }

        return Integer.parseInt(new String(c));

    }
}
