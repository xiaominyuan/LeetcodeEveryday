//和为S的连续正数序列
//小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
// 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

package jianzhioffer;

import java.util.ArrayList;
//双指针法
public class code34 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int low = 1;
        int high = 2;
        while (high > low){
            int sumTmp = (low + high)*(high - low +1)/2;
            if (sumTmp == sum){
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = low; i<=high; i++){
                    tmp.add(i);
                }
                res.add(tmp);
                low++;
            }else if (sumTmp < sum){
                high++;
            }else {
                low++;
            }
        }

        return res;
    }
}
