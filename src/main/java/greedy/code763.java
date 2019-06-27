//763. 划分字母区间
//        字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
//
//        示例 1:
//
//        输入: S = "ababcbacadefegdehijhklij"
//        输出: [9,7,8]
//        解释:
//        划分结果为 "ababcbaca", "defegde", "hijhklij"。
//        每个字母最多出现在一个片段中。
//        像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/partition-labels
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package greedy;

import java.util.ArrayList;
import java.util.List;

public class code763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;
        char[] arr = S.toCharArray();

        for (int i = 0; i<arr.length; i++){
            int nextIndex = S.indexOf(arr[i], i+1);
            if (nextIndex == -1 && i>=endIndex){
                result.add(i-startIndex+1);
                startIndex = i+1;
            }else {
                if (nextIndex > endIndex){
                    endIndex = nextIndex;
                }
            }
        }
        return result;
    }
}
