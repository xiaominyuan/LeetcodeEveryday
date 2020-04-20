//698. 划分为k个相等的子集
//给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
//
//示例 1：
//
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

package backTracking;

public class canPartitionKSubsets698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i< len; i++){
            sum += nums[i];
        }

        int avg = sum/k;
        boolean[] flag = new boolean[len];
        return dfs(nums, 0, 0, k, 0, flag, avg);
    }

    //subSum  每个子集的当前和
    //count  子集的当前个数
    public boolean dfs(int[] nums, int subSum, int count, int k, int index, boolean[] flag, int avg){
        if (index >= nums.length){
            return false;
        }

        if (count == k){
            return true;
        }

        for (int i = index; i< nums.length; i++){
            if (flag[i] == false){
                if (nums[i] + subSum == avg){
                    flag[i] = true;

                    //此时k = count+1 是因为： 比如数组【1，2，4，3】， k = 2,  那么当1+4 = 5 的时候， 需要再从 2 开始遍历 ， 结合38题理解
                    if (dfs(nums, 0, count+1, k, count+1, flag, avg)){
                        return true;
                    }
                    flag[i] = false;
                }

                if (nums[i] + subSum < avg){
                    flag[i] = false;
                    if (dfs(nums, subSum+nums[i], count, k,i+1, flag, avg)){
                        return true;
                    }
                    flag[i] = false;
                }
            }
        }

        return false;
    }
}
